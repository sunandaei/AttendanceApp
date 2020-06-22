package com.sunanda.attendance_kotlin.activity

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.IntentSender
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.location.Location
import android.os.*
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.*
import com.sunanda.attendance_kotlin.R
import com.sunanda.attendance_kotlin.database.DatabaseHandler
import com.sunanda.attendance_kotlin.helper.*
import com.sunanda.attendance_kotlin.model.NewTaskPojo
import com.sunanda.attendance_kotlin.model.ServerResponse
import com.sunanda.attendance_kotlin.myInterface.ApiConfig
import com.sunanda.attendance_kotlin.myInterface.ApiInterface
import com.sunanda.attendance_kotlin.room.DatabaseClient
import com.sunanda.attendance_kotlin.room.TaskPojoUsingRoom
import okhttp3.*
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.IOException
import java.util.concurrent.TimeUnit

class WelcomeActivity : AppCompatActivity(), LocationListener, GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener {

    internal lateinit var attendance: Button
    internal lateinit var leave: Button
    internal lateinit var name: TextView
    internal lateinit var email: TextView
    internal lateinit var sessionManager: SessionManager
    lateinit var loadingDialog: LoadingDialog
    lateinit var taskPojoArrayListDB: ArrayList<NewTaskPojo>
    lateinit var databaseHandler: DatabaseHandler

    lateinit var mGoogleApiClient: GoogleApiClient

    private var mFusedLocationClient: FusedLocationProviderClient? = null
    private var mSettingsClient: SettingsClient? = null
    private var mLocationSettingsRequest: LocationSettingsRequest? = null
    private var mLocationCallback: LocationCallback? = null
    private var mLocationRequest: LocationRequest? = null
    private var mCurrentLocation: Location? = null

    internal lateinit var networkChangeReceiver: NetworkChangeReceiver
    internal var network: Boolean? = false

    lateinit var taskPojoRoomDB: ArrayList<TaskPojoUsingRoom>
    var totel_count = 0

    private fun requestAllPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this@WelcomeActivity,
                        Manifest.permission.ACCESS_FINE_LOCATION) ||
                ActivityCompat.shouldShowRequestPermissionRationale(this@WelcomeActivity,
                        Manifest.permission.ACCESS_COARSE_LOCATION) ||
                ActivityCompat.shouldShowRequestPermissionRationale(this@WelcomeActivity,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) ||
                ActivityCompat.shouldShowRequestPermissionRationale(this@WelcomeActivity,
                        Manifest.permission.READ_EXTERNAL_STORAGE) ||
                ActivityCompat.shouldShowRequestPermissionRationale(this@WelcomeActivity,
                        Manifest.permission.CAMERA)) {
            val builder1 = AlertDialog.Builder(this@WelcomeActivity)
            builder1.setMessage("This app cannot work without the Location Permission")
            builder1.setCancelable(false)
            builder1.setPositiveButton("Grant permission"
            ) { dialog, id ->
                dialog.dismiss()
                initValue()
            }
            val alert11 = builder1.create()
            if (!this@WelcomeActivity.isFinishing) {
                alert11.show()
            }
            initValue()
        } else {
            ActivityCompat.requestPermissions(this@WelcomeActivity, INITIAL_PERMS, INITIAL_REQUEST)
            initValue()
        }
    }

    private fun getPermission() {

        if (Build.VERSION.SDK_INT >= 23) {
            if (ActivityCompat.checkSelfPermission(this@WelcomeActivity,
                            Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                    || ActivityCompat.checkSelfPermission(this@WelcomeActivity,
                            Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
                    || ActivityCompat.checkSelfPermission(this@WelcomeActivity,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                    || ActivityCompat.checkSelfPermission(this@WelcomeActivity,
                            Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                    || ActivityCompat.checkSelfPermission(this@WelcomeActivity,
                            Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                val builder1 = AlertDialog.Builder(this@WelcomeActivity)
                builder1.setMessage("This app can't work without Location Permissions")
                builder1.setCancelable(false)
                builder1.setPositiveButton("Grant permission"
                ) { dialog, id ->
                    requestAllPermission()
                    dialog.dismiss()
                }
                val alert11 = builder1.create()
                if (!this@WelcomeActivity.isFinishing) {
                    alert11.show()
                }
            } else {
                initValue()
            }
        } else {
            initValue()
        }
    }

    private fun initValue() {

        mGoogleApiClient = GoogleApiClient.Builder(this@WelcomeActivity)
                .addConnectionCallbacks(this@WelcomeActivity)
                .addOnConnectionFailedListener(this@WelcomeActivity)
                .addApi(LocationServices.API).build()
        mGoogleApiClient.connect()

        taskPojoRoomDB = ArrayList()
        sessionManager = SessionManager(this)
        loadingDialog = LoadingDialog(this)

        networkChangeReceiver = NetworkChangeReceiver(this)

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

        attendance = findViewById<Button>(R.id.attendance)
        leave = findViewById(R.id.out)
        name = findViewById(R.id.name)
        email = findViewById(R.id.email)

        name.text = sessionManager.name
        email.text = sessionManager.email

        leave.setOnClickListener {
            startActivity(Intent(this@WelcomeActivity, LeaveApply::class.java))
            overridePendingTransition(R.anim.left_in, R.anim.right_out)
            finish()
        }

        attendance.setOnClickListener {

            getPermission()
            turnGPSOn1(this@WelcomeActivity, mGoogleApiClient)
            checkPlayServices()
            createLocationRequest()
            startLocationUpdates()

            startActivity(Intent(this@WelcomeActivity, AttendanceActivity::class.java))
            overridePendingTransition(R.anim.left_in, R.anim.right_out)
            finishAffinity()


            /*if (mCurrentLocation == null) {
                //Toast.makeText(SampleCollection_Activity.this, "Please wait for Location...", Toast.LENGTH_LONG).show();
                AlertDialog.Builder(this@WelcomeActivity)
                        .setTitle("Google Location Warning")
                        .setMessage("Please allow Location Permission")
                        .setPositiveButton(android.R.string.yes) { dialog, which ->

                            getPermission()
                            turnGPSOn1(this@WelcomeActivity, mGoogleApiClient)
                            checkPlayServices()
                            createLocationRequest()
                            startLocationUpdates()
                        }
                        //.setNegativeButton(android.R.string.no, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setCancelable(false)
                        .show()
            } else {
                startActivity(Intent(this@WelcomeActivity, AttendanceActivity::class.java))
                overridePendingTransition(R.anim.left_in, R.anim.right_out)
                finishAffinity()
            }*/

            /* AlertDialog.Builder(this)
                     .setTitle("Google Location Warning")
                     .setMessage("Before proceed please make sure your 'Location' setting is turned on.")
                     .setPositiveButton(android.R.string.ok, DialogInterface.OnClickListener { dialog, which ->
                         dialog.dismiss()
                         startActivity(Intent(this@WelcomeActivity, AttendanceActivity::class.java))
                         overridePendingTransition(R.anim.left_in, R.anim.right_out)
                         finish()
                     })
                     // A null listener allows the button to dismiss the dialog and take no further action.
                     //.setNegativeButton(android.R.string.no, null)
                     .setIcon(android.R.drawable.ic_dialog_alert)
                     .setCancelable(false)
                     .show()*/
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        getPermission()

        // Using Room
        getTasks()

        /*databaseHandler = DatabaseHandler(this)
        if (databaseHandler.getData().size != 0) {
            findViewById<View>(R.id.fab).visibility = View.VISIBLE
        } else {
            findViewById<View>(R.id.fab).visibility = View.GONE
        }*/
    }

    private fun getTasks() {

        class GetTasks : AsyncTask<Void, Void, List<TaskPojoUsingRoom>>() {

            override fun doInBackground(vararg voids: Void): List<TaskPojoUsingRoom> {
                return DatabaseClient
                        .getInstance(this@WelcomeActivity)
                        .appDatabase
                        .taskDao()
                        .all
            }

            override fun onPostExecute(tasks: List<TaskPojoUsingRoom>) {
                super.onPostExecute(tasks)

                taskPojoRoomDB = tasks as ArrayList
                totel_count = taskPojoRoomDB.size
                if (taskPojoRoomDB.size != 0) {
                    findViewById<View>(R.id.fab).visibility = View.VISIBLE
                    findViewById<View>(R.id.container).visibility = View.VISIBLE
                } else {
                    findViewById<View>(R.id.fab).visibility = View.GONE
                    findViewById<View>(R.id.container).visibility = View.GONE
                }
            }
        }

        val gt = GetTasks()
        gt.execute()
    }


    override fun onResume() {
        super.onResume()
        networkChangeReceiver = NetworkChangeReceiver(this)
        network = networkChangeReceiver.isNetworkAvailable

        findViewById<View>(R.id.fab).setOnClickListener {
            if (network!!) {
                /*taskPojoArrayListDB = databaseHandler.getData()
                for (i in 0 until taskPojoArrayListDB.size) {
                    SendData(i)*/

                for (i in 0 until taskPojoRoomDB.size)
                    SendRoomData(i)

                    /*if (TextUtils.isEmpty(taskPojoArrayListDB[i].imageName))
                        SendData(i)
                    else
                        uploadFileSource(taskPojoArrayListDB[i].imageName!!,
                                taskPojoArrayListDB[i].imageName!!.substring(taskPojoArrayListDB[i].imageName!!.lastIndexOf('/') + 1), i)*/
            } else {
                startActivity(Intent(this@WelcomeActivity, NetworkConnection::class.java))
                overridePendingTransition(R.anim.left_in, R.anim.right_out)
            }
        }

        findViewById<View>(R.id.fab2).setOnClickListener {
            startActivity(Intent(this@WelcomeActivity, TaskListActivity::class.java))
            overridePendingTransition(R.anim.left_in, R.anim.right_out)
        }
    }

    private fun uploadFileSource(str: String, str2: String, pos: Int) {

        loadingDialog.showDialog()

        deleteCache(this)

        // Map is used to multipart the file using okhttp3.RequestBody
        val file = File(str)
        // Parsing any Media type file
        val requestBody = RequestBody.create(MediaType.parse("*/*"), file)
        val fileToUpload = MultipartBody.Part.createFormData("image", file.name, requestBody)
        val filename = RequestBody.create(MediaType.parse("text/plain"),
                str.substring(str.lastIndexOf('/') + 1))

        val getResponse = AppConfig.retrofit.create(ApiConfig::class.java)
        val call = getResponse.uploadFile(fileToUpload, filename)
        call.enqueue(object : Callback<ServerResponse> {
            override fun onResponse(call: Call<ServerResponse>, response: Response<ServerResponse>) {
                val serverResponse = response.body()
                //Log.d("RESPONSE", serverResponse.toString())
                if (serverResponse != null) {
                    if (serverResponse.success.equals("200")) {
                        //ShowDialog(serverResponse.message!!)
                        sendImageData(str2, pos)
                        //Toast.makeText(applicationContext, serverResponse.message, Toast.LENGTH_SHORT).show();
                    } else {
                        ErrorDialog(serverResponse.message!!)
                        Toast.makeText(applicationContext, serverResponse.message, Toast.LENGTH_SHORT).show()
                    }
                } else {
                    assert(false)
                    //Log.v("Response", serverResponse!!.toString())
                    val builder1 = AlertDialog.Builder(this@WelcomeActivity)
                    builder1.setMessage("Source Image Not Send. Please try again")
                    builder1.setCancelable(true)
                    builder1.setPositiveButton(
                            "Ok"
                    ) { dialog, id ->
                        dialog.dismiss()
                        uploadFileSource(str, str2, pos)
                    }
                    val alert11 = builder1.create()
                    if (!this@WelcomeActivity.isFinishing()) {
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

    private fun sendImageData(finename: String, pos: Int) {

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

        val tempTime = taskPojoArrayListDB[pos].time!!.split(" ")[0]

        val loginResponseCall = services.insert_data("abc123456", sessionManager.keyId!!,
                taskPojoArrayListDB[pos].address!!, taskPojoArrayListDB[pos].task!!, taskPojoArrayListDB[pos].lat!!,
                taskPojoArrayListDB[pos].lon!!, "Event", taskPojoArrayListDB[pos].date_from!!,
                taskPojoArrayListDB[pos].date_to!!, taskPojoArrayListDB[pos].time!!, finename,
                tempTime.split("-")[2], tempTime.split("-")[1], tempTime.split("-")[0])
        loginResponseCall.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {

                if (response.body() != null) {

                    try {
                        val jsonObject = JSONObject(response.body()!!.string())
                        if (jsonObject.getInt("resCode") == 200) {
                            //ShowDialog(jsonObject.getString("message"))
                            databaseHandler.deleteData(taskPojoArrayListDB[pos]._id.toString())
                            if (databaseHandler.getData().size == 0) {
                                //Toast.makeText(this@WelcomeActivity, "All Data Uploaded Successfully", Toast.LENGTH_SHORT).show()
                                //finishAffinity()
                                val builder = AlertDialog.Builder(this@WelcomeActivity)
                                builder.setMessage("All Information Uploaded Successfully")
                                builder.setPositiveButton("DONE") { dialog, which ->
                                    dialog.dismiss()
                                    deleteAllImage()
                                }
                                builder.setCancelable(false)
                                builder.show()
                            }
                        } else {
                            ErrorDialog(jsonObject.getString("message"))
                        }
                    } catch (e: Exception) {
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

    private fun SendData(pos: Int) {

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

        val tempTime = taskPojoArrayListDB[pos].time!!.split(" ")[0]

        val loginResponseCall = services.insert_data("abc123456", sessionManager.keyId!!,
                taskPojoArrayListDB[pos].address!!, taskPojoArrayListDB[pos].task!!, taskPojoArrayListDB[pos].lat!!,
                taskPojoArrayListDB[pos].lon!!, "Attendance", taskPojoArrayListDB[pos].date_from!!,
                taskPojoArrayListDB[pos].date_to!!, taskPojoArrayListDB[pos].time!!, "",
                tempTime.split("-")[2], tempTime.split("-")[1], tempTime.split("-")[0])

        loginResponseCall.enqueue(object : Callback<ResponseBody> {

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {

                if (response.body() != null) {

                    try {
                        val jsonObject = JSONObject(response.body()!!.string())
                        Log.d("RESPONSE", jsonObject.toString())
                        if (jsonObject.getInt("resCode") == 200) {
                            //ShowDialog(jsonObject.getString("message"))
                            databaseHandler.deleteData(taskPojoArrayListDB[pos]._id.toString())
                            if (databaseHandler.getData().size == 0) {
                                //Toast.makeText(this@WelcomeActivity, "All Data Uploaded Successfully", Toast.LENGTH_SHORT).show()
                                //finishAffinity()
                                val builder = AlertDialog.Builder(this@WelcomeActivity)
                                //builder.setTitle("Androidly Alert")
                                builder.setMessage("All Information Uploaded Successfully")
                                //builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = x))

                                builder.setPositiveButton("DONE") { dialog, which ->
                                    dialog.dismiss()
                                    overridePendingTransition(R.anim.right_in, R.anim.left_out)
                                    finishAffinity()
                                    //deleteAllImage()
                                }
                                /*builder.setNegativeButton(android.R.string.no) { dialog, which ->
                                    Toast.makeText(applicationContext,
                                            android.R.string.no, Toast.LENGTH_SHORT).show()
                                }

                                builder.setNeutralButton("Maybe") { dialog, which ->
                                    Toast.makeText(applicationContext,
                                            "Maybe", Toast.LENGTH_SHORT).show()
                                }*/
                                builder.setCancelable(false)
                                builder.show()
                            }
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


    private fun SendRoomData(pos: Int) {

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

        /*val loginResponseCall = services.insert_data("abc123456", sessionManager.keyId!!,
                taskPojoArrayListDB[pos].address!!, taskPojoArrayListDB[pos].task!!, taskPojoArrayListDB[pos].lat!!,
                taskPojoArrayListDB[pos].lon!!, "Attendance", taskPojoArrayListDB[pos].date_from!!,
                taskPojoArrayListDB[pos].date_to!!, taskPojoArrayListDB[pos].time!!, "")*/

        val tempTime = taskPojoRoomDB[pos].time!!.split(" ")[0]

        val loginResponseCall = services.insert_data("abc123456", sessionManager.keyId!!,
                taskPojoRoomDB[pos].address!!, taskPojoRoomDB[pos].tasks!!, taskPojoRoomDB[pos].lat!!,
                taskPojoRoomDB[pos].lon!!, "Attendance", taskPojoRoomDB[pos].date_from!!,
                taskPojoRoomDB[pos].date_to!!, taskPojoRoomDB[pos].time!!, "",
                tempTime.split("-")[2], tempTime.split("-")[1], tempTime.split("-")[0])

        loginResponseCall.enqueue(object : Callback<ResponseBody> {

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {

                if (response.body() != null) {

                    try {
                        val jsonObject = JSONObject(response.body()!!.string())
                        //Log.d("RESPONSE", jsonObject.toString())
                        if (jsonObject.getInt("resCode") == 200) {
                            //ShowDialog(jsonObject.getString("message"))
                            deleteTask(taskPojoRoomDB[pos])
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

    private fun deleteTask(task: TaskPojoUsingRoom) {

        class DeleteTask : AsyncTask<Void, Void, Void>() {

            override fun doInBackground(vararg voids: Void): Void? {
                DatabaseClient.getInstance(this@WelcomeActivity).appDatabase
                        .taskDao()
                        .delete(task)
                return null
            }

            override fun onPostExecute(aVoid: Void?) {
                super.onPostExecute(aVoid)
                //Toast.makeText(activity, "Deleted", Toast.LENGTH_LONG).show()
                //Log.d("DELETE", "Deleted")
                totel_count--
                if (totel_count == 0) {

                    val builder = AlertDialog.Builder(this@WelcomeActivity)
                    //builder.setTitle("Androidly Alert")
                    builder.setMessage("All Information Uploaded Successfully")
                    //builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = x))

                    builder.setPositiveButton("DONE") { dialog, which ->
                        dialog.dismiss()
                        overridePendingTransition(R.anim.right_in, R.anim.left_out)
                        finishAffinity()
                        //deleteAllImage()
                    }
                    /*builder.setNegativeButton(android.R.string.no) { dialog, which ->
                        Toast.makeText(applicationContext,
                                android.R.string.no, Toast.LENGTH_SHORT).show()
                    }

                    builder.setNeutralButton("Maybe") { dialog, which ->
                        Toast.makeText(applicationContext,
                                "Maybe", Toast.LENGTH_SHORT).show()
                    }*/
                    builder.setCancelable(false)
                    builder.show()
                    builder.create()
                }
            }
        }

        val dt = DeleteTask()
        dt.execute()
    }




    fun getFileDataFromDrawable(bitmap: Bitmap?): ByteArray {
        val byteArrayOutputStream = ByteArrayOutputStream()
        bitmap!!.compress(Bitmap.CompressFormat.JPEG, 75, byteArrayOutputStream)
        return byteArrayOutputStream.toByteArray()
    }

    private fun deleteAllImage() {
        val mAlbumStorageDirFactory: AlbumStorageDirFactory = fetchAlbumDirectory()

        //File dir = new File(Environment.getExternalStorageDirectory()+"Dir_name_here");
        val dir: File?
        dir = mAlbumStorageDirFactory.getAlbumStorageDir(getAlbumName());
        if (dir.isDirectory) {
            val children = dir.list()
            for (child in children) {
                File(dir, child).delete()
            }
            overridePendingTransition(R.anim.right_in, R.anim.left_out)
            finishAffinity()
        }
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

    private fun ShowDialog(msg: String) {

        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)

        dialog.setContentView(R.layout.custom_dialog)
        dialog.setCancelable(false)

        val restart = dialog.findViewById<View>(R.id.restart) as Button
        val title_txt = dialog.findViewById<TextView>(R.id.title_txt)
        title_txt.text = msg

        restart.setOnClickListener {
            dialog.dismiss()
            startActivity(Intent(this@WelcomeActivity, NextActivity::class.java))
            overridePendingTransition(R.anim.left_in, R.anim.right_out)
            finish()
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

    /*private fun ShowDialog(msg: String) {

        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)

        dialog.setContentView(R.layout.custom_dialog)
        dialog.setCancelable(false)

        val restart = dialog.findViewById<View>(R.id.restart) as Button
        val title_txt = dialog.findViewById<TextView>(R.id.title_txt)
        title_txt.text = msg

        restart.setOnClickListener {
            dialog.dismiss()
            startActivity(Intent(this@WelcomeActivity, NextActivity::class.java))
            overridePendingTransition(R.anim.left_in, R.anim.right_out)
            finish()
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
    }*/

    override fun onBackPressed() {

        val dialog = Dialog(this)
        dialog.setContentView(R.layout.error_popup)
        val dialogButton = dialog.findViewById<View>(R.id.dialogButtonOK) as Button
        val text = dialog.findViewById<TextView>(R.id.text)
        text.text = "Please Select Any One To Proceed!"
        // if button is clicked, close the custom dialog
        dialogButton.setOnClickListener {
            dialog.dismiss()
            //Toast.makeText(getApplicationContext(), "Dismissed..!!", Toast.LENGTH_SHORT).show();
        }
        dialog.show()
        dialog.setCancelable(false)
    }

    override fun onLocationChanged(location: Location?) {
        mCurrentLocation = location

        if (location != null) {
            val latitude = location.latitude
            val longitude = location.longitude
            val locationAddress = LocationAddress
            locationAddress.getAddressFromLocation(latitude, longitude, applicationContext, GeocoderHandler())
        }
    }

    override fun onConnected(bundle: Bundle?) {
        if (ActivityCompat.checkSelfPermission(this@WelcomeActivity, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this@WelcomeActivity,
                        Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return
        }
        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this@WelcomeActivity)
    }

    override fun onConnectionSuspended(i: Int) {

    }

    override fun onConnectionFailed(connectionResult: ConnectionResult) {}

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
                                rae.startResolutionForResult(this@WelcomeActivity, REQUEST_CHECK_SETTINGS)
                            } catch (sie: IntentSender.SendIntentException) {
                                Log.i("", "PendingIntent unable to execute request.")
                            }

                        }
                        LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE -> {
                            val errorMessage = "Location settings are inadequate, and cannot be " + "fixed here. Fix in Settings."
                            Log.e("", errorMessage)

                            Toast.makeText(this@WelcomeActivity, errorMessage, Toast.LENGTH_LONG).show()
                        }
                    }

                    updateLocationUI()
                }
    }

    private fun updateLocationUI() {
        if (mCurrentLocation != null) {

            val latitude = mCurrentLocation!!.latitude
            val longitude = mCurrentLocation!!.longitude
            val locationAddress = LocationAddress
            locationAddress.getAddressFromLocation(latitude, longitude, applicationContext, GeocoderHandler())
        }
    }

    fun turnGPSOn1(activity: Activity, googleApiClient: GoogleApiClient) {

        val locationRequest = LocationRequest.create()
        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        locationRequest.interval = (30 * 1000).toLong()
        locationRequest.fastestInterval = (5 * 1000).toLong()
        val builder = LocationSettingsRequest.Builder()
                .addLocationRequest(locationRequest)
        builder.setAlwaysShow(true) //this is the key ingredient

        val result = LocationServices.SettingsApi.checkLocationSettings(googleApiClient, builder.build())
        result.setResultCallback { result ->
            val status = result.status
            when (status.statusCode) {
                LocationSettingsStatusCodes.SUCCESS -> {
                }
                LocationSettingsStatusCodes.RESOLUTION_REQUIRED ->
                    // Location settings are not satisfied. But could be fixed by showing the user
                    // a dialog.
                    try {
                        // Show the dialog by calling startResolutionForResult(),
                        // and check the result in onActivityResult().
                        status.startResolutionForResult(
                                activity, REQUEST_LOCATION_LIB)
                    } catch (e: IntentSender.SendIntentException) {
                        // Ignore the error.
                    }

                LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE -> {
                }
            }// All location settings are satisfied. The client can initialize location
            // requests here.
            // Location settings are not satisfied. However, we have no way to fix the
            // settings so we won't show the dialog.
        }
    }

    private fun checkPlayServices(): Boolean {
        val googleAPI = GoogleApiAvailability.getInstance()
        val result = googleAPI.isGooglePlayServicesAvailable(this@WelcomeActivity)
        if (result != ConnectionResult.SUCCESS) {
            if (googleAPI.isUserResolvableError(result)) {
                googleAPI.getErrorDialog(this@WelcomeActivity, result,
                        101).show()
            }

            return false
        }

        return true
    }

    @SuppressLint("RestrictedApi")
    protected fun createLocationRequest() {
        mLocationRequest = LocationRequest()
        mLocationRequest!!.interval = Constants.INTERVAL
        mLocationRequest!!.fastestInterval = Constants.FIRST_INTERVAL
        mLocationRequest!!.priority = LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY
    }

    companion object {

        private val UPDATE_INTERVAL_IN_MILLISECONDS: Long = 10000
        private val FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS: Long = 5000
        private val REQUEST_CHECK_SETTINGS = 100
        private val REQUEST_LOCATION_LIB = 1001

        private val INITIAL_PERMS = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA)

        private val INITIAL_REQUEST = 1514
    }
}