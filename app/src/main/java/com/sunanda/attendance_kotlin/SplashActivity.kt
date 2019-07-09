package com.sunanda.attendance_kotlin

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.LinearLayout
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class SplashActivity : AppCompatActivity() {

    internal lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splash)

        init()
    }

    private fun init() {

        sessionManager = SessionManager(this)

        StartAnimations()

        val SPLASH_TIME_OUT = 4000
        Handler().postDelayed({ NextTask() }, SPLASH_TIME_OUT.toLong())
    }

    private fun StartAnimations() {
        var anim = AnimationUtils.loadAnimation(this, R.anim.alpha)
        anim.reset()
        val l = findViewById<View>(R.id.lin_lay) as LinearLayout
        l.clearAnimation()
        l.startAnimation(anim)

        anim = AnimationUtils.loadAnimation(this, R.anim.translate)
        anim.reset()
        val iv = findViewById<View>(R.id.imageView2) as ImageView
        iv.clearAnimation()
        iv.startAnimation(anim)
    }

    private fun NextTask() {
        val getDate = sessionManager.prefsDate

        val c = Calendar.getInstance()
        @SuppressLint("SimpleDateFormat")
        val df = SimpleDateFormat("yyyy-MM-dd")
        val formattedDate = df.format(c.time)

        try {
            if (sessionManager.isLoggedIn) {
                val todayDate = df.parse(formattedDate)
                val fDate = df.parse(getDate)
                if (todayDate == fDate) {
                    /*if (!sessionManager.isExit) {
                        startActivity(Intent(this@SplashActivity, NextActivity::class.java))
                        overridePendingTransition(R.anim.left_in, R.anim.right_out)
                        finish()
                        } else {
                            val dialog = Dialog(this)
                            dialog.setContentView(R.layout.custom_dialog3)
                            val text_dialog = dialog.findViewById<View>(R.id.text_dialog) as TextView
                            val btn_dialog = dialog.findViewById<TextView>(R.id.btn_dialog) as Button
                            text_dialog.text = "You have already 'Attendance Out' from the APP. Please try again tomorrow."
                            btn_dialog.text = "DISMISS"
                            // if button is clicked, close the custom dialog
                            btn_dialog.setOnClickListener {
                                dialog.dismiss()
                                finish()
                            }
                            dialog.show()
                            dialog.setCancelable(false)
                        }*/
                    startActivity(Intent(this@SplashActivity, NextActivity::class.java))
                    overridePendingTransition(R.anim.left_in, R.anim.right_out)
                    finish()
                }
                /*if (sessionManager.isFirstTIme) {
                    startActivity(Intent(this@SplashActivity, NextActivity::class.java))
                    overridePendingTransition(R.anim.left_in, R.anim.right_out)
                    finish()
                }*/ else {
                    //sessionManager.setIsExit(false)
                    //sessionManager.setIsFirst(true)
                    sessionManager.SetDate(formattedDate)
                    startActivity(Intent(this@SplashActivity, WelcomeActivity::class.java))
                    overridePendingTransition(R.anim.left_in, R.anim.right_out)
                    finish()
                }
            } else {
                sessionManager.setIsExit(false)
                startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
                overridePendingTransition(R.anim.left_in, R.anim.right_out)
                finish()
            }
        } catch (e: ParseException) {
            //e.printStackTrace()
            sessionManager.setIsExit(false)
            startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
            overridePendingTransition(R.anim.left_in, R.anim.right_out)
            finish()
        }
    }

    companion object {

        private val TAG = "SplashScreen"
    }
}
