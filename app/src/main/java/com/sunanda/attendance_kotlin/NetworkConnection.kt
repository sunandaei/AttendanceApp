package com.sunanda.attendance_kotlin

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.view.Window
import android.view.WindowManager

class NetworkConnection : AppCompatActivity() {

    internal lateinit var retry: FloatingActionButton
    internal var network: Boolean? = false
    internal lateinit var networkChangeReceiver: NetworkChangeReceiver

    override fun onCreate(savedInstanceState: Bundle?) {

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network_connecction)

        networkChangeReceiver = NetworkChangeReceiver(this)

        retry = findViewById(R.id.fab_retryConnection)
        retry.setOnClickListener {
            network = networkChangeReceiver.isNetworkAvailable
            if (network!!) {
                finish()
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
