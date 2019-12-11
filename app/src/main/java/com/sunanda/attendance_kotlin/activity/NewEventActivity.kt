package com.sunanda.attendance_kotlin.activity

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.content.IntentSender
import android.graphics.*
import android.location.Location
import android.media.ExifInterface
import android.net.Uri
import android.os.*
import android.provider.MediaStore
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.text.InputType
import android.text.TextUtils
import android.util.Base64
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.view.Window
import android.view.inputmethod.EditorInfo
import android.widget.*
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.*
import com.sunanda.attendance_kotlin.Interface.ApiConfig
import com.sunanda.attendance_kotlin.Interface.ApiInterface
import com.sunanda.attendance_kotlin.R
import com.sunanda.attendance_kotlin.database.DatabaseHandler
import com.sunanda.attendance_kotlin.helper.*
import com.sunanda.attendance_kotlin.model.ServerResponse
import kotlinx.android.synthetic.main.activity_new_event.*
import okhttp3.*
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.*
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit


class NewEventActivity : AppCompatActivity() {

    internal lateinit var sessionManager: SessionManager
    internal lateinit var loadingDialog: LoadingDialog
    internal lateinit var networkChangeReceiver: NetworkChangeReceiver
    internal var network: Boolean? = false

    private var mAlbumStorageDirFactory: AlbumStorageDirFactory? = null
    private val CAMERA_REQUEST = 11
    private var mCurrentPhotoPath: String = ""
    internal lateinit var ivPicture: ImageView

    private val JPEG_FILE_SUFFIX = ".png"

    lateinit var databaseHandler: DatabaseHandler

    internal lateinit var tvAddress: TextView
    internal lateinit var tvLatitude: TextView
    internal lateinit var tvLongitude: TextView
    internal lateinit var current_location: TextView

    internal lateinit var address: EditText
    internal lateinit var task: EditText

    private var mFusedLocationClient: FusedLocationProviderClient? = null
    private var mSettingsClient: SettingsClient? = null
    private var mLocationSettingsRequest: LocationSettingsRequest? = null
    private var mLocationCallback: LocationCallback? = null
    private var mLocationRequest: LocationRequest? = null
    private var mCurrentLocation: Location? = null
    private var current_date = ""
    private var current_date_time = ""

    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {

        mAlbumStorageDirFactory = fetchAlbumDirectory()

        val builder1 = StrictMode.VmPolicy.Builder()
        StrictMode.setVmPolicy(builder1.build())

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_event)

        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar!!.title = ""
        val toolbar_title = findViewById<View>(R.id.title_txt) as TextView
        toolbar_title.typeface = Typeface.createFromAsset(assets, "proxima_nova_light.ttf")
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.left_arrow)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        toolbar_title.text = "Add Event"

        sessionManager = SessionManager(this)
        address = findViewById(R.id.address)
        task = findViewById(R.id.task)
        tvAddress = findViewById(R.id.tvAddress)
        tvLatitude = findViewById(R.id.tvLatitude)
        tvLongitude = findViewById(R.id.tvLongitude)
        current_location = findViewById(R.id.current_location)
        loadingDialog = LoadingDialog(this)

        //task.imeOptions = EditorInfo.IME_ACTION_DONE
        //task.setRawInputType(InputType.TYPE_CLASS_TEXT)

        databaseHandler = DatabaseHandler(this)

        /*address.imeOptions = EditorInfo.IME_ACTION_NEXT
        address.setRawInputType(InputType.TYPE_CLASS_TEXT)
        task.imeOptions = EditorInfo.IME_ACTION_DONE
        task.setRawInputType(InputType.TYPE_CLASS_TEXT)*/

        ivPicture = findViewById(R.id.ivPicture)
        btnTakeImage.setOnClickListener(View.OnClickListener {
            /*val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            var f: File? = null
            try {
                f = setUpPhotoFile()
                mCurrentPhotoPath = f!!.absolutePath
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f))
            } catch (e: Exception) {
                f = null
                mCurrentPhotoPath = ""
                e.printStackTrace()
            }
            startActivityForResult(takePictureIntent, CAMERA_REQUEST)*/
            selectImage()
        })

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        mSettingsClient = LocationServices.getSettingsClient(this)

        mLocationRequest = LocationRequest()
        mLocationRequest!!.interval = UPDATE_INTERVAL_IN_MILLISECONDS
        mLocationRequest!!.fastestInterval = FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS
        mLocationRequest!!.priority = LocationRequest.PRIORITY_HIGH_ACCURACY

        mLocationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult?) {
                super.onLocationResult(locationResult)
                // location is received
                mCurrentLocation = locationResult!!.lastLocation
                updateLocationUI()
            }
        }

        val builder = LocationSettingsRequest.Builder()
        builder.addLocationRequest(mLocationRequest!!)
        mLocationSettingsRequest = builder.build()

        startLocationUpdates()

        current_location.setOnClickListener {
            if (!TextUtils.isEmpty(tvAddress.text.toString())) {
                address.setText(tvAddress.text.toString().split(":".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[1])
                address.setSelection(address.text.toString().length)
            } else {
                Toast.makeText(this@NewEventActivity, "Current location not found!", Toast.LENGTH_SHORT).show()
            }
        }

        var c = Calendar.getInstance()
        val df = SimpleDateFormat("yyyy-MM-dd")
        @SuppressLint("SimpleDateFormat")
        val formattedDate = df.format(c.time)
        current_date = formattedDate

        c = Calendar.getInstance()
        @SuppressLint("SimpleDateFormat")
        val df2 = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        @SuppressLint("SimpleDateFormat")
        val formattedDate2 = df2.format(c.time)
        current_date_time = formattedDate2

        findViewById<View>(R.id.addTask).setOnClickListener {
            if (TextUtils.isEmpty(address.text.toString())) {
                address.error = "Please Enter Your Address"
                address.isFocusable = true
            } else if (TextUtils.isEmpty(task.text.toString())) {
                task.error = "Please Enter Task"
                task.isFocusable = true
            } else {
                //Toast.makeText(NextActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                SaveData()
            }
        }
    }

    private fun SaveData() {

        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)

        dialog.setContentView(R.layout.alertdialog_custom_view)
        dialog.setCancelable(false)

        val dialog_neutral_btn = dialog.findViewById<View>(R.id.dialog_neutral_btn) as Button
        val dialog_positive_btn = dialog.findViewById<View>(R.id.dialog_positive_btn) as Button

        dialog_positive_btn.setOnClickListener {
            dialog.dismiss()
            if (TextUtils.isEmpty(mCurrentPhotoPath)) {
                Toast.makeText(applicationContext, "Take Picture of the Event", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            //uploadFileSource(mCurrentPhotoPath, mCurrentPhotoPath.substring(mCurrentPhotoPath.lastIndexOf('/') + 1))
            if (databaseHandler.insertData(sessionManager.keyId!!, address.text.toString(), task.text.toString(), tvLatitude.text.toString(),
                            tvLongitude.text.toString(), "Event", current_date, current_date, mCurrentPhotoPath, current_date_time)) {
                ShowDialog("Data Saved Successfully")
            } else {
                ErrorDialog("Unable To Save Data!")
            }
        }
        dialog_neutral_btn.setOnClickListener { dialog.dismiss() }
        dialog.show()

        // Display the custom alert dialog on interface
        dialog.show()
    }

    private fun uploadFileSource(str: String, str2: String) {

        loadingDialog.showDialog()

        deleteCache(this)

        // Map is used to multipart the file using okhttp3.RequestBody
        val file = File(mCurrentPhotoPath)
        // Parsing any Media type file
        val requestBody = RequestBody.create(MediaType.parse("*/*"), file)
        val fileToUpload = MultipartBody.Part.createFormData("image", file.name, requestBody)
        val filename = RequestBody.create(MediaType.parse("text/plain"),
                mCurrentPhotoPath.substring(mCurrentPhotoPath.lastIndexOf('/') + 1))

        val getResponse = AppConfig.retrofit.create(ApiConfig::class.java)
        val call = getResponse.uploadFile(fileToUpload, filename)
        call.enqueue(object : Callback<ServerResponse> {
            override fun onResponse(call: Call<ServerResponse>, response: Response<ServerResponse>) {
                val serverResponse = response.body()
                Log.d("RESPONSE", serverResponse.toString())
                if (serverResponse != null) {
                    if (serverResponse.success.equals("200")) {
                        //ShowDialog(serverResponse.message!!)
                        sendData(str2)
                        //Toast.makeText(applicationContext, serverResponse.message, Toast.LENGTH_SHORT).show();
                    } else {
                        ErrorDialog(serverResponse.message!!)
                        Toast.makeText(applicationContext, serverResponse.message, Toast.LENGTH_SHORT).show()
                    }
                } else {
                    assert(false)
                    //Log.v("Response", serverResponse!!.toString())
                    val builder1 = AlertDialog.Builder(this@NewEventActivity)
                    builder1.setMessage("Source Image Not Send. Please try again")
                    builder1.setCancelable(true)
                    builder1.setPositiveButton(
                            "Ok"
                    ) { dialog, id ->
                        dialog.dismiss()
                        uploadFileSource(str, str2)
                    }
                    val alert11 = builder1.create()
                    if (!this@NewEventActivity.isFinishing()) {
                        alert11.show()
                    }
                }
                loadingDialog.hideDialog()
            }

            override fun onFailure(call: Call<ServerResponse>, t: Throwable) {
                Log.v("Response", "Error" + t.message)
                ErrorDialog("Unable to send data!")
                loadingDialog.hideDialog()
            }
        })
    }

    private fun sendData(finename: String) {

        val httpClient = OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .addInterceptor { chain ->
                    val ongoing = chain.request().newBuilder()
                    chain.proceed(ongoing.build())
                }
                .build()

        loadingDialog.showDialog()
        val retrofit = Retrofit.Builder()
                .baseUrl(Constants.ROOT_URL)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val services = retrofit.create(ApiInterface::class.java)

        val loginResponseCall = services.insert_data("abc123456", sessionManager.keyId!!,
                address.text.toString(), task.text.toString(), tvLatitude.text.toString(),
                tvLongitude.text.toString(), "Event", current_date, current_date, finename)
        loginResponseCall.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {

                if (response.body() != null) {

                    try {
                        val jsonObject = JSONObject(response.body()!!.string())
                        if (jsonObject.getInt("resCode") == 200) {
                            ShowDialog(jsonObject.getString("message"))
                        } else {
                            ErrorDialog(jsonObject.getString("message"))
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }

                } else {
                    ErrorDialog("Something went wrong!")
                }
                loadingDialog.hideDialog()
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                loadingDialog.hideDialog()
            }
        })
    }

    private fun ShowDialog(msg: String) {

        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)

        dialog.setContentView(R.layout.custom_dialog)
        dialog.setCancelable(false)

        val restart = dialog.findViewById<View>(R.id.restart) as Button
        val title_txt = dialog.findViewById<TextView>(R.id.title_txt)
        title_txt.text = "Event Submitted Successfully"

        restart.setOnClickListener {
            dialog.dismiss()
            address.setText("")
            task.setText("")
            address.requestFocus()
            mCurrentPhotoPath = ""
            setPic()
            ivPicture.setImageDrawable(getResources().getDrawable(R.drawable.download));
        }
        dialog.show()
    }

    private fun ErrorDialog(error: String) {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.error_popup)
        val dialogButton = dialog.findViewById<View>(R.id.dialogButtonOK) as Button
        val text = dialog.findViewById<TextView>(R.id.text)
        text.text = error
        // if button is clicked, close the custom dialog
        dialogButton.setOnClickListener {
            dialog.dismiss()
            //Toast.makeText(getApplicationContext(), "Dismissed..!!", Toast.LENGTH_SHORT).show();
        }
        dialog.show()
        dialog.setCancelable(false)
    }

    private fun setUpPhotoFile(): File? {
        var f: File? = null
        try {
            f = createImageFile()
            mCurrentPhotoPath = f!!.absolutePath
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return f
    }

    @SuppressLint("SimpleDateFormat")
    private fun createImageFile(): File? {
        // Create an image file dCode
        var imageF: File? = null
        try {
            val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
            val imageFileName = sessionManager.keyId + "_" + timeStamp
            val albumF = getAlbumDir()
            imageF = File.createTempFile(imageFileName, JPEG_FILE_SUFFIX, albumF)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return imageF
    }

    private fun getAlbumDir(): File? {
        var storageDir: File? = null
        try {
            if (Environment.MEDIA_MOUNTED == Environment.getExternalStorageState()) {

                storageDir = mAlbumStorageDirFactory!!.getAlbumStorageDir(getAlbumName())

                if (!storageDir.mkdirs()) {
                    if (!storageDir.exists()) {
                        Log.d("CameraSample", "failed to create directory")
                        return null
                    }
                }
            } else {
                Log.v(getString(R.string.app_name), "External storage is not mounted READ/WRITE.")
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return storageDir
    }

    private fun getAlbumName(): String {
        return getString(R.string.app_name)
    }

    fun deleteCache(context: Context) {
        try {
            val dir = context.cacheDir
            deleteDir(dir)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun deleteDir(dir: File?): Boolean {
        if (dir != null && dir.isDirectory) {
            val children = dir.list()
            for (i in children.indices) {
                val success = deleteDir(File(dir, children[i]))
                if (!success) {
                    return false
                }
            }
            return dir.delete()
        } else return if (dir != null && dir.isFile) {
            dir.delete()
        } else {
            false
        }
    }

    private fun handleBigCameraPhoto() {
        if (mCurrentPhotoPath != "") {
            setPic()
        }
    }

    private fun setPic() {
        val bmOptions = BitmapFactory.Options()
        bmOptions.inJustDecodeBounds = true
        BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions)
        compressImage(mCurrentPhotoPath)
        bmOptions.inJustDecodeBounds = false
        bmOptions.inPurgeable = true
        val bitmap = BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions)
        ivPicture.setImageBitmap(bitmap)
    }

    fun compressImage(imageUri: String): String {
        val filePath = getRealPathFromURI(imageUri)
        var scaledBitmap: Bitmap? = null
        val options = BitmapFactory.Options()
        //  by setting this field as true, the actual bitmap pixels are not loaded in the memory. Just the bounds are loaded. If
        //  you try the use the bitmap here, you will get null.
        options.inJustDecodeBounds = true
        var bmp = BitmapFactory.decodeFile(filePath, options)
        var actualHeight = options.outHeight
        var actualWidth = options.outWidth
        //      max Height and width values of the compressed image is taken as 816x612
        val maxHeight = 1000.0f
        val maxWidth = 900.0f
        var imgRatio = actualWidth.toFloat() / actualHeight
        val maxRatio = maxWidth / maxHeight
        //      width and height values are set maintaining the aspect ratio of the image
        if (actualHeight > maxHeight || actualWidth > maxWidth) {
            if (imgRatio < maxRatio) {
                imgRatio = maxHeight / actualHeight
                actualWidth = (imgRatio * actualWidth).toInt()
                actualHeight = maxHeight.toInt()
            } else if (imgRatio > maxRatio) {
                imgRatio = maxWidth / actualWidth
                actualHeight = (imgRatio * actualHeight).toInt()
                actualWidth = maxWidth.toInt()
            } else {
                actualHeight = maxHeight.toInt()
                actualWidth = maxWidth.toInt()
            }
        }

        //      setting inSampleSize value allows to load a scaled down version of the original image
        options.inSampleSize = calculateInSampleSize(options, actualWidth, actualHeight)
        //      inJustDecodeBounds set to false to load the actual bitmap
        options.inJustDecodeBounds = false
        //      this options allow android to claim the bitmap memory if it runs low on memory
        options.inPurgeable = true
        options.inInputShareable = true
        options.inTempStorage = ByteArray(16 * 1024)
        try {
            //          load the bitmap from its path
            bmp = BitmapFactory.decodeFile(filePath, options)
        } catch (exception: OutOfMemoryError) {
            exception.printStackTrace()
        }

        try {
            scaledBitmap = Bitmap.createBitmap(actualWidth, actualHeight, Bitmap.Config.ARGB_8888)
        } catch (exception: Exception) {
            exception.printStackTrace()
        }

        try {
            val ratioX = actualWidth / options.outWidth.toFloat()
            val ratioY = actualHeight / options.outHeight.toFloat()
            val middleX = actualWidth / 2.0f
            val middleY = actualHeight / 2.0f
            val scaleMatrix = Matrix()
            scaleMatrix.setScale(ratioX, ratioY, middleX, middleY)
            val canvas = Canvas(scaledBitmap!!)
            canvas.matrix = scaleMatrix
            canvas.drawBitmap(bmp, middleX - bmp.width / 2, middleY - bmp.height / 2, Paint(Paint.FILTER_BITMAP_FLAG))
        } catch (e: Exception) {
            e.printStackTrace()
        }

        val exif: ExifInterface
        try {
            exif = ExifInterface(filePath)
            val orientation = exif.getAttributeInt(
                    ExifInterface.TAG_ORIENTATION, 0
            )
            Log.d("EXIF", "Exif: $orientation")
            val matrix = Matrix()
            if (orientation == 6) {
                matrix.postRotate(90f)
                Log.d("EXIF", "Exif: $orientation")
            } else if (orientation == 3) {
                matrix.postRotate(180f)
                Log.d("EXIF", "Exif: $orientation")
            } else if (orientation == 8) {
                matrix.postRotate(270f)
                Log.d("EXIF", "Exif: $orientation")
            }
            scaledBitmap = Bitmap.createBitmap(
                    scaledBitmap!!, 0, 0,
                    scaledBitmap.width, scaledBitmap.height, matrix,
                    true
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }

        var out: FileOutputStream? = null
        val filename = getFilename(imageUri)
        try {
            out = FileOutputStream(filename)
            //          write the compressed bitmap at the destination specified by filename.
            scaledBitmap!!.compress(Bitmap.CompressFormat.JPEG, 100, out)

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return filename
    }

    fun getFilename(imageUri: String): String {
        val file = File(imageUri)
        if (!file.exists()) {
            file.mkdirs()
        }
        return file.absolutePath
    }

    fun calculateInSampleSize(options: BitmapFactory.Options, reqWidth: Int, reqHeight: Int): Int {
        val height = options.outHeight
        val width = options.outWidth
        var inSampleSize = 1
        if (height > reqHeight || width > reqWidth) {
            val heightRatio = Math.round(height.toFloat() / reqHeight.toFloat())
            val widthRatio = Math.round(width.toFloat() / reqWidth.toFloat())
            inSampleSize = if (heightRatio < widthRatio) heightRatio else widthRatio
        }
        val totalPixels = (width * height).toFloat()
        val totalReqPixelsCap = (reqWidth * reqHeight * 2).toFloat()
        while (totalPixels / (inSampleSize * inSampleSize) > totalReqPixelsCap) {
            inSampleSize++
        }
        return inSampleSize
    }

    private fun getRealPathFromURI(contentURI: String): String? {
        val contentUri = Uri.parse(contentURI)
        val cursor = contentResolver.query(contentUri, null, null, null, null)
        if (cursor == null) {
            return contentUri.path
        } else {
            cursor.moveToFirst()
            val index = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA)
            return cursor.getString(index)
        }
    }

    @SuppressLint("MissingPermission")
    private fun startLocationUpdates() {
        mSettingsClient!!
                .checkLocationSettings(mLocationSettingsRequest)
                .addOnSuccessListener(this) {
                    Log.i("", "All location settings are satisfied.")

                    //Toast.makeText(getApplicationContext(), "Started location updates!", Toast.LENGTH_SHORT).show();

                    mFusedLocationClient!!.requestLocationUpdates(mLocationRequest,
                            mLocationCallback!!, Looper.myLooper())

                    updateLocationUI()
                }
                .addOnFailureListener(this) { e ->
                    val statusCode = (e as ApiException).statusCode
                    when (statusCode) {
                        LocationSettingsStatusCodes.RESOLUTION_REQUIRED -> {
                            Log.i("", "Location settings are not satisfied. Attempting to upgrade " + "location settings ")
                            try {
                                // Show the dialog by calling startResolutionForResult(), and check the
                                // result in onActivityResult().
                                val rae = e as ResolvableApiException
                                rae.startResolutionForResult(this@NewEventActivity, REQUEST_CHECK_SETTINGS)
                            } catch (sie: IntentSender.SendIntentException) {
                                Log.i("", "PendingIntent unable to execute request.")
                            }

                        }
                        LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE -> {
                            val errorMessage = "Location settings are inadequate, and cannot be " + "fixed here. Fix in Settings."
                            Log.e("", errorMessage)

                            Toast.makeText(this@NewEventActivity, errorMessage, Toast.LENGTH_LONG).show()
                        }
                    }

                    updateLocationUI()
                }
    }

    private fun updateLocationUI() {
        if (mCurrentLocation != null) {

            tvLatitude.text = mCurrentLocation!!.latitude.toString()
            tvLongitude.text = mCurrentLocation!!.longitude.toString()

            val latitude = mCurrentLocation!!.latitude
            val longitude = mCurrentLocation!!.longitude
            val locationAddress = LocationAddress
            locationAddress.getAddressFromLocation(latitude, longitude, applicationContext, GeocoderHandler())
        }
    }

    private inner class GeocoderHandler : Handler() {
        override fun handleMessage(message: Message) {
            val locationAddress: String?
            when (message.what) {
                1 -> {
                    val bundle = message.data
                    locationAddress = bundle.getString("address")
                }
                else -> locationAddress = null
            }
            tvAddress.text = locationAddress
        }
    }


    companion object {
        private val UPDATE_INTERVAL_IN_MILLISECONDS: Long = 10000
        private val FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS: Long = 5000
        private val REQUEST_CHECK_SETTINGS = 100
    }


    private fun selectImage() {
        val options = arrayOf<CharSequence>("Take Photo", "Choose from Gallery", "Cancel")
        val builder = android.support.v7.app.AlertDialog.Builder(this@NewEventActivity)
        builder.setTitle("Add Photo!")
        builder.setItems(options) { dialog, item ->
            if (options[item] == "Take Photo") {
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                val f = File(Environment.getExternalStorageDirectory(), "temp.jpg")
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f))
                startActivityForResult(intent, 1)
            } else if (options[item] == "Choose from Gallery") {
                val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(intent, 2)
            } else if (options[item] == "Cancel") {
                dialog.dismiss()
            }
        }
        builder.show()
    }


    /*
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {

            CAMERA_REQUEST -> when (resultCode) {
                Activity.RESULT_OK -> handleBigCameraPhoto()
                Activity.RESULT_CANCELED -> {
                    mCurrentPhotoPath = ""
                    ivPicture.setImageBitmap(null)
                }
            }
        }
    }
    * */

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            if (requestCode == 1) {
                var f = File(Environment.getExternalStorageDirectory().toString())
                for (temp in f.listFiles()) {
                    if (temp.name == "temp.jpg") {
                        f = temp
                        break
                    }
                }
                try {
                    var bitmap: Bitmap
                    val bitmapOptions = BitmapFactory.Options()
                    bitmap = BitmapFactory.decodeFile(f.absolutePath, bitmapOptions)
                    bitmap = getResizedBitmap(bitmap, 1000)
                    ivPicture.setImageBitmap(bitmap)
                    //upload_bitmap = bitmap
                    mCurrentPhotoPath = BitMapToString(bitmap)!!

                    val path = (Environment
                            .getExternalStorageDirectory().toString()
                            + File.separator
                            + getString(R.string.app_name) + File.separator + "default")
                    f.delete()
                    var outFile: OutputStream? = null
                    val file = File(path, System.currentTimeMillis().toString() + ".jpg")
                    try {
                        outFile = FileOutputStream(file)
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 85, outFile)
                        outFile.flush()
                        outFile.close()
                    } catch (e: FileNotFoundException) {
                        e.printStackTrace()
                    } catch (e: IOException) {
                        e.printStackTrace()
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }

                } catch (e: Exception) {
                    e.printStackTrace()
                }

            } else if (requestCode == 2) {

                try {
                    val uri = data!!.data
                    val realPath = getRealPathFromURI(uri!!)

                    /* val selectedImage = data.data
                val filePath = arrayOf(MediaStore.Images.Media.DATA)
                val c = contentResolver.query(selectedImage, filePath, null, null, null)
                c!!.moveToFirst()
                val columnIndex = c.getColumnIndex(filePath[0])
                val picturePath = c.getString(columnIndex)
                c.close()*/
                    var thumbnail = BitmapFactory.decodeFile(realPath)
                    thumbnail = getResizedBitmap(thumbnail, 1000)
                    //Log.d("path image from gallery", picturePath + "");
                    ivPicture.setImageBitmap(thumbnail)
                    //upload_bitmap = thumbnail
                    //mCurrentPhotoPath = BitMapToString(thumbnail)!!
                    mCurrentPhotoPath = realPath
                }catch (e : Exception){
                    Toast.makeText(this, "Unable to fetch the image path. Please try different image.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    fun getRealPathFromURI(uri: Uri): String {
        val projection: Array<String> = arrayOf(MediaStore.Images.Media.DATA)

        val cursor = managedQuery(uri, projection, null, null, null)
        val column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
        cursor.moveToFirst()
        return cursor.getString(column_index)
    }

    fun BitMapToString(userImage1: Bitmap): String? {
        val baos = ByteArrayOutputStream()
        userImage1.compress(Bitmap.CompressFormat.PNG, 50, baos)
        val b = baos.toByteArray()
        mCurrentPhotoPath = Base64.encodeToString(b, Base64.DEFAULT)
        return mCurrentPhotoPath
    }

    fun getResizedBitmap(image: Bitmap, maxSize: Int): Bitmap {
        var width = image.width
        var height = image.height

        val bitmapRatio = width.toFloat() / height.toFloat()
        if (bitmapRatio > 1) {
            width = maxSize
            height = (width / bitmapRatio).toInt()
        } else {
            height = maxSize
            width = (height * bitmapRatio).toInt()
        }
        return Bitmap.createScaledBitmap(image, width, height, true)
    }

    fun StringToBitMap(image: String): Bitmap? {
        try {
            val encodeByte = Base64.decode(image, Base64.DEFAULT)
            val inputStream = ByteArrayInputStream(encodeByte)
            val bitmap = BitmapFactory.decodeStream(inputStream)
            return bitmap
        } catch (e: Exception) {
            return null
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            super.onBackPressed()
            overridePendingTransition(R.anim.right_in, R.anim.left_out)
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.right_in, R.anim.left_out)
        finish()
    }
}
