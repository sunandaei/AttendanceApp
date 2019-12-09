package com.sunanda.attendance_kotlin.activity

import android.Manifest
import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.content.IntentSender
import android.location.Location
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.support.v7.app.AppCompatActivity
import android.text.InputType
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.view.Window
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.*
import com.sunanda.attendance_kotlin.Interface.ApiInterface
import com.sunanda.attendance_kotlin.R
import com.sunanda.attendance_kotlin.database.DatabaseHandler
import com.sunanda.attendance_kotlin.helper.Constants
import com.sunanda.attendance_kotlin.helper.LoadingDialog
import com.sunanda.attendance_kotlin.helper.LocationAddress
import com.sunanda.attendance_kotlin.helper.SessionManager
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

class AttendanceActivity : AppCompatActivity(), LocationListener {

    internal lateinit var address: EditText
    internal lateinit var task: EditText
    internal lateinit var name: TextView
    internal lateinit var email: TextView
    internal lateinit var tvAddress: TextView
    internal lateinit var tvLatitude: TextView
    internal lateinit var tvLongitude: TextView
    internal lateinit var current_location: TextView
    internal lateinit var sessionManager: SessionManager
    internal lateinit var loadingDialog: LoadingDialog

    private var mFusedLocationClient: FusedLocationProviderClient? = null
    private var mSettingsClient: SettingsClient? = null
    private var mLocationSettingsRequest: LocationSettingsRequest? = null
    private var mLocationCallback: LocationCallback? = null
    private var mLocationRequest: LocationRequest? = null
    private var mCurrentLocation: Location? = null
    private var current_date: String? = null
    private var current_date_time: String? = null

    lateinit var databaseHandler: DatabaseHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attendance)
        
        initValue();
    }

    private fun initValue() {

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

        databaseHandler = DatabaseHandler(this)

        name.text = sessionManager.name
        email.text = sessionManager.email

        findViewById<View>(R.id.next).setOnClickListener {
            if (TextUtils.isEmpty(address.text.toString())) {
                address.error = "Please Enter Your Address"
                address.isFocusable = true
            } else if (TextUtils.isEmpty(task.text.toString())) {
                task.error = "Please Enter Task"
                task.isFocusable = true
            } else {
                ShowSubmitDialog()
            }
        }

        address.imeOptions = EditorInfo.IME_ACTION_NEXT
        address.setRawInputType(InputType.TYPE_CLASS_TEXT)
        task.imeOptions = EditorInfo.IME_ACTION_DONE
        task.setRawInputType(InputType.TYPE_CLASS_TEXT)

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
                Toast.makeText(this@AttendanceActivity, "Current location not found!", Toast.LENGTH_SHORT).show()
            }
        }

        var c = Calendar.getInstance()
        @SuppressLint("SimpleDateFormat")
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
                                rae.startResolutionForResult(this@AttendanceActivity, REQUEST_CHECK_SETTINGS)
                            } catch (sie: IntentSender.SendIntentException) {
                                Log.i("", "PendingIntent unable to execute request.")
                            }

                        }
                        LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE -> {
                            val errorMessage = "Location settings are inadequate, and cannot be " + "fixed here. Fix in Settings."
                            Log.e("", errorMessage)

                            Toast.makeText(this@AttendanceActivity, errorMessage, Toast.LENGTH_LONG).show()
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
            //SendData()
            if (databaseHandler.insertData(sessionManager.keyId!!,
                            address.text.toString(), task.text.toString(), tvLatitude.text.toString(), tvLongitude.text.toString(),
                            "Attendance", current_date!!, current_date!!, "", current_date_time!!)) {
                ShowDialog("Data Saved Successfully")
            } else {
                ErrorDialog("Unable To Save Data!")
            }
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
            startActivity(Intent(this@AttendanceActivity, NextActivity::class.java))
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

    private fun SendData() {

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
                tvLongitude.text.toString(), "Attendance", current_date!!, current_date!! , "")

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

    override fun onBackPressed() {
        /*final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        dialog.setContentView(R.layout.custom_dialog2);
        dialog.setCancelable(false);

        Button btn_yes = (Button) dialog.findViewById(R.id.btn_yes);
        Button btn_no = (Button) dialog.findViewById(R.id.btn_no);

        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
                finish();
            }
        });
        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();*/
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.error_popup)
        val dialogButton = dialog.findViewById<View>(R.id.dialogButtonOK) as Button
        val text = dialog.findViewById<TextView>(R.id.text)
        text.text = "Please give your Attendance first!"
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

        private val INITIAL_PERMS = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION)

        private val INITIAL_REQUEST = 1514
    }
}
