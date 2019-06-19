package com.sunanda.attendance_kotlin

import android.Manifest
import android.app.Dialog
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.os.Build
import android.os.Handler
import android.os.Message
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.TextView

import com.google.android.gms.location.LocationListener

class WelcomeActivity : AppCompatActivity(), LocationListener {

    private var mCurrentLocation: Location? = null
    internal lateinit var attendance: Button
    internal lateinit var leave: Button
    internal lateinit var name: TextView
    internal lateinit var email: TextView
    internal lateinit var sessionManager: SessionManager

    private fun requestAllPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this@WelcomeActivity,
                        Manifest.permission.ACCESS_FINE_LOCATION) || ActivityCompat.shouldShowRequestPermissionRationale(this@WelcomeActivity,
                        Manifest.permission.ACCESS_COARSE_LOCATION)) {
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
            if (ActivityCompat.checkSelfPermission(this@WelcomeActivity, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(this@WelcomeActivity, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
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

        sessionManager = SessionManager(this)

        attendance = findViewById(R.id.attendance)
        leave = findViewById(R.id.leave)
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
            startActivity(Intent(this@WelcomeActivity, AttendanceActivity::class.java))
            overridePendingTransition(R.anim.left_in, R.anim.right_out)
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        getPermission()
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

    companion object {
        private val UPDATE_INTERVAL_IN_MILLISECONDS: Long = 10000
        private val FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS: Long = 5000
        private val REQUEST_CHECK_SETTINGS = 100

        private val INITIAL_PERMS = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION)

        private val INITIAL_REQUEST = 1514
    }
}