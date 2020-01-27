package com.sunanda.attendance_kotlin.activity

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.content.IntentSender
import android.location.Location
import android.location.LocationListener
import android.os.*
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.*
import com.sunanda.attendance_kotlin.R
import com.sunanda.attendance_kotlin.database.DatabaseHandler
import com.sunanda.attendance_kotlin.helper.LoadingDialog
import com.sunanda.attendance_kotlin.helper.LocationAddress
import com.sunanda.attendance_kotlin.helper.SessionManager
import com.sunanda.attendance_kotlin.room.DatabaseClient
import com.sunanda.attendance_kotlin.room.TaskPojoUsingRoom
import java.text.SimpleDateFormat
import java.util.*

class NextActivity : AppCompatActivity(), LocationListener {

    internal lateinit var sessionManager: SessionManager
    internal lateinit var address: EditText
    internal lateinit var task: EditText
    internal lateinit var name: TextView
    internal lateinit var email: TextView
    internal lateinit var tvAddress: TextView
    internal lateinit var tvLatitude: TextView
    internal lateinit var tvLongitude: TextView
    internal lateinit var current_location: TextView
    internal lateinit var loadingDialog: LoadingDialog

    lateinit var databaseHandler: DatabaseHandler

    private var mFusedLocationClient: FusedLocationProviderClient? = null
    private var mSettingsClient: SettingsClient? = null
    private var mLocationSettingsRequest: LocationSettingsRequest? = null
    private var mLocationCallback: LocationCallback? = null
    private var mLocationRequest: LocationRequest? = null
    private var mCurrentLocation: Location? = null
    private var current_date = ""
    private var current_date_time = ""

    @SuppressLint("SimpleDateFormat", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        sessionManager = SessionManager(this)
        address = findViewById(R.id.address)
        task = findViewById(R.id.task)
        name = findViewById(R.id.name)
        email = findViewById(R.id.email)
        tvAddress = findViewById(R.id.tvAddress)
        tvLatitude = findViewById(R.id.tvLatitude)
        tvLongitude = findViewById(R.id.tvLongitude)
        current_location = findViewById(R.id.current_location)
        loadingDialog = LoadingDialog(this)

        //task.imeOptions = EditorInfo.IME_ACTION_DONE
        //task.setRawInputType(InputType.TYPE_CLASS_TEXT)

        databaseHandler = DatabaseHandler(this)

        name.text = sessionManager.name
        email.text = sessionManager.email

        findViewById<View>(R.id.logout).setOnClickListener { logout() }

        findViewById<View>(R.id.viewAll).setOnClickListener {
            startActivity(Intent(this@NextActivity, TaskListActivity::class.java))
            overridePendingTransition(R.anim.left_in, R.anim.right_out)
        }

        findViewById<View>(R.id.out).setOnClickListener {
            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)

            dialog.setContentView(R.layout.exit_dialog)
            dialog.setCancelable(false)

            val btnCancel = dialog.findViewById<View>(R.id.btn_cancel) as Button
            val btnOkay = dialog.findViewById<View>(R.id.btn_okay) as Button
            val txt_exit = dialog.findViewById<View>(R.id.txt_exit) as TextView

            txt_exit.text = "Do you want to Attendance Out?"

            val nwaddress: String = try {
                tvAddress.text.toString().split(":".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[1]
            } catch (e: Exception) {
                "Address Not found"
            }

            btnOkay.setOnClickListener {
                dialog.dismiss()
                //sendDataExit()

                val c = Calendar.getInstance()
                @SuppressLint("SimpleDateFormat")
                val df2 = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                @SuppressLint("SimpleDateFormat")
                val formattedDate2 = df2.format(c.time)
                current_date_time = formattedDate2

                /*if (databaseHandler.insertData(sessionManager.keyId!!,
                                nwaddress, "Attendance Out", tvLatitude.text.toString(), tvLongitude.text.toString(),
                                "Attendance", current_date, current_date, "", current_date_time)) {
                    //ShowDialog("Successfully Attendance Out. Thank You.")
                    val mydialog = Dialog(this@NextActivity)
                    mydialog.requestWindowFeature(Window.FEATURE_NO_TITLE)

                    mydialog.setContentView(R.layout.custom_dialog)
                    mydialog.setCancelable(false)

                    val restart = mydialog.findViewById<View>(R.id.restart) as Button
                    val titleTxt = mydialog.findViewById<TextView>(R.id.title_txt)
                    titleTxt.text = "Successfully Attendance Out. Thank You."

                    restart.setOnClickListener {
                        mydialog.dismiss()
                        //sessionManager.setIsExit(true)
                        sessionManager.setIsFirst(false)
                        finish()
                    }
                    mydialog.show()
                } else {
                    ErrorDialog("Please Try Again!")
                }*/

                saveTask(0, sessionManager.keyId!!,
                        nwaddress, "Attendance Out", tvLatitude.text.toString(), tvLongitude.text.toString(),
                        "Attendance", current_date, current_date, current_date_time)
            }
            btnCancel.setOnClickListener { dialog.dismiss() }
            dialog.show()
        }

        /*address.imeOptions = EditorInfo.IME_ACTION_NEXT
        address.setRawInputType(InputType.TYPE_CLASS_TEXT)
        task.imeOptions = EditorInfo.IME_ACTION_DONE
        task.setRawInputType(InputType.TYPE_CLASS_TEXT)*/

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
            try {
                if (!TextUtils.isEmpty(tvAddress.text.toString())) {
                    address.setText(tvAddress.text.toString().split(":".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[1])
                    address.setSelection(address.text.toString().length)
                } else {
                    Toast.makeText(this@NextActivity, "Current location not found!", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Toast.makeText(this@NextActivity, "Unable to get Current Address. Please input it manually!", Toast.LENGTH_LONG).show()
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

        /*addEvent.setOnClickListener {
            startActivity(Intent(this@NextActivity, NewEventActivity::class.java))
            overridePendingTransition(R.anim.left_in, R.anim.right_out)
        }*/
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
                                rae.startResolutionForResult(this@NextActivity, REQUEST_CHECK_SETTINGS)
                            } catch (sie: IntentSender.SendIntentException) {
                                Log.i("", "PendingIntent unable to execute request.")
                            }

                        }
                        LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE -> {
                            val errorMessage = "Location settings are inadequate, and cannot be " + "fixed here. Fix in Settings."
                            Log.e("", errorMessage)

                            Toast.makeText(this@NextActivity, errorMessage, Toast.LENGTH_LONG).show()
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

    private fun ShowSubmitDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)

        dialog.setContentView(R.layout.alertdialog_custom_view)
        dialog.setCancelable(false)

        val dialog_neutral_btn = dialog.findViewById<View>(R.id.dialog_neutral_btn) as Button
        val dialog_positive_btn = dialog.findViewById<View>(R.id.dialog_positive_btn) as Button

        dialog_positive_btn.setOnClickListener {
            dialog.dismiss()
            //sendData()
        }
        dialog_neutral_btn.setOnClickListener { dialog.dismiss() }
        dialog.show()
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
            address.setText("")
            task.setText("")
            address.requestFocus()
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

    /* private fun sendData() {

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
                 tvLongitude.text.toString(), "Task", current_date, current_date, "")
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
     }*/

    /*private fun sendDataExit() {

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

        val address: String = try {
            tvAddress.text.toString().split(":".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[1]
        } catch (e: Exception) {
            "Not found"
        }

        val loginResponseCall = services.insert_data("abc123456", sessionManager.keyId!!,
                address, "Attendance Out", tvLatitude.text.toString(), tvLongitude.text.toString(),
                "Task", current_date, current_date, "")

        loginResponseCall.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {

                if (response.body() != null) {

                    try {
                        val jsonObject = JSONObject(response.body()!!.string())
                        if (jsonObject.getInt("resCode") == 200) {
                            //ShowDialog("Successfully Attendance Out. Thank You.")
                            val dialog = Dialog(this@NextActivity)
                            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)

                            dialog.setContentView(R.layout.custom_dialog)
                            dialog.setCancelable(false)

                            val restart = dialog.findViewById<View>(R.id.restart) as Button
                            val titleTxt = dialog.findViewById<TextView>(R.id.title_txt)
                            titleTxt.text = "Successfully Attendance Out. Thank You."

                            restart.setOnClickListener {
                                dialog.dismiss()
                                sessionManager.setIsExit(true)
                                finish()
                            }
                            dialog.show()
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
    }*/

    private fun SaveData() {

        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)

        dialog.setContentView(R.layout.alertdialog_custom_view)
        dialog.setCancelable(false)

        val dialog_neutral_btn = dialog.findViewById<View>(R.id.dialog_neutral_btn) as Button
        val dialog_positive_btn = dialog.findViewById<View>(R.id.dialog_positive_btn) as Button

        dialog_positive_btn.setOnClickListener {
            dialog.dismiss()
            //sendData()
            /*if (databaseHandler.insertData(sessionManager.keyId!!,
                            address.text.toString(), task.text.toString(), tvLatitude.text.toString(),
                            tvLongitude.text.toString(), "Task", current_date, current_date, "", current_date_time)) {
                ShowDialog("Data Saved Successfully")
            } else {
                ErrorDialog("Unable To Save Data!")
            }*/

            saveTask(1, sessionManager.keyId!!,
                    address.text.toString(), task.text.toString(), tvLatitude.text.toString(),
                    tvLongitude.text.toString(), "Task", current_date, current_date, current_date_time)
        }
        dialog_neutral_btn.setOnClickListener { dialog.dismiss() }
        dialog.show()

        // Display the custom alert dialog on interface
        dialog.show()
    }

    private fun logout() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)

        dialog.setContentView(R.layout.exit_dialog)
        dialog.setCancelable(false)

        val btnCancel = dialog.findViewById<View>(R.id.btn_cancel) as Button
        val btnOkay = dialog.findViewById<View>(R.id.btn_okay) as Button
        val txt_exit = dialog.findViewById<View>(R.id.txt_exit) as TextView

        txt_exit.text = "Do you want to Logout?"

        btnOkay.setOnClickListener {
            dialog.dismiss()
            sessionManager.setLogin(false, "", "", sessionManager.email!!, "", "0000-00-00")
            sessionManager.setIsFirst(false)
            overridePendingTransition(R.anim.right_in, R.anim.left_out)
            finishAffinity()
        }
        btnCancel.setOnClickListener { dialog.dismiss() }
        dialog.show()
    }

    override fun onBackPressed() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)

        dialog.setContentView(R.layout.custom_dialog2)
        dialog.setCancelable(false)

        val btn_yes = dialog.findViewById<View>(R.id.btn_yes) as Button
        val btn_no = dialog.findViewById<View>(R.id.btn_no) as Button

        btn_yes.setOnClickListener {
            overridePendingTransition(R.anim.right_in, R.anim.left_out)
            finishAffinity()
        }
        btn_no.setOnClickListener { dialog.dismiss() }
        dialog.show()
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

    override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {

    }

    override fun onProviderEnabled(provider: String) {

    }

    override fun onProviderDisabled(provider: String) {

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
        private val UPDATE_INTERVAL_IN_MILLISECONDS: Long = 10000 * 60
        private val FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS: Long = 15000
        private val REQUEST_CHECK_SETTINGS = 100
    }

    /* Using room*/
    private fun saveTask(value: Int, user_id: String, address: String, tasks: String, lat: String, lon: String,
                         type: String, date_from: String, date_to: String, time: String) {

        class SaveTask : AsyncTask<Void, Void, Void>() {

            override fun doInBackground(vararg voids: Void): Void? {

                //creating a task
                val taskPojo = TaskPojoUsingRoom()
                taskPojo.user_id = user_id
                taskPojo.address = address
                taskPojo.tasks = tasks
                taskPojo.lat = lat
                taskPojo.lon = lon
                taskPojo.type = type
                taskPojo.date_from = date_from
                taskPojo.date_to = date_to
                taskPojo.time = time

                //adding to database
                DatabaseClient.getInstance(applicationContext).appDatabase
                        .taskDao()
                        .insert(taskPojo)
                return null
            }

            @SuppressLint("SetTextI18n")
            override fun onPostExecute(aVoid: Void?) {
                super.onPostExecute(aVoid)
                if (value == 1)
                    ShowDialog("Data Saved Successfully")
                else {
                    val mydialog = Dialog(this@NextActivity)
                    mydialog.requestWindowFeature(Window.FEATURE_NO_TITLE)

                    mydialog.setContentView(R.layout.custom_dialog)
                    mydialog.setCancelable(false)

                    val restart = mydialog.findViewById<View>(R.id.restart) as Button
                    val titleTxt = mydialog.findViewById<TextView>(R.id.title_txt)
                    titleTxt.text = "Successfully Attendance Out. Thank You."

                    restart.setOnClickListener {
                        mydialog.dismiss()
                        //sessionManager.setIsExit(true)
                        sessionManager.setIsFirst(false)
                        finish()
                    }
                    mydialog.show()
                }
            }
        }

        val st = SaveTask()
        st.execute()
    }
}
