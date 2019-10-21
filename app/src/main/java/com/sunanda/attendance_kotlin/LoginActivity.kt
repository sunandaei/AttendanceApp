package com.sunanda.attendance_kotlin

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.view.Window
import android.view.animation.AnimationUtils
import android.widget.*

import org.json.JSONException
import org.json.JSONObject

import java.io.IOException
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.concurrent.TimeUnit

import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginActivity : AppCompatActivity() {

    internal lateinit var networkChangeReceiver: NetworkChangeReceiver
    internal var network: Boolean? = false
    internal lateinit var uname: EditText
    internal lateinit var login_password: EditText
    private var loadingDialog: LoadingDialog? = null
    internal lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sessionManager = SessionManager(this)
        loadingDialog = LoadingDialog(this)

        networkChangeReceiver = NetworkChangeReceiver(this)
        network = networkChangeReceiver.isNetworkAvailable

        uname = findViewById(R.id.email)
        login_password = findViewById(R.id.password)

        if (!TextUtils.isEmpty(sessionManager.email) && !sessionManager.email!!.equals("email", ignoreCase = true)) {
            uname.setText(sessionManager.email)
            login_password.requestFocus()
        }
    }

    fun Context.toast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    fun ImageView.loadUrl(url: String) {
        //Picasso.with(context).load(url).into(this)
    }

    private fun userLogin(email: String, password: String) {

        val httpClient = OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .addInterceptor { chain ->
                    val ongoing = chain.request().newBuilder()
                    chain.proceed(ongoing.build())
                }
                .build()

        loadingDialog!!.showDialog()
        val retrofit = Retrofit.Builder()
                .baseUrl(Constants.ROOT_URL)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val services = retrofit.create(ApiInterface::class.java)

        val loginResponseCall = services.loginRequest(email, password)
        loginResponseCall.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {

                val c = Calendar.getInstance()
                @SuppressLint("SimpleDateFormat")
                val df = SimpleDateFormat("yyyy-MM-dd")
                val formattedDate = df.format(c.time)

                if (response.body() != null) {

                    try {
                        val jsonObject = JSONObject(response.body()!!.string())
                        if (jsonObject.getInt("resCode") == 200) {

                            val details = jsonObject.getJSONObject("details")
                            sessionManager.setLogin(true, details.getString("_id"),
                                    details.getString("name"), details.getString("email"), "", formattedDate)

                            ShowDialog()
                        } else {
                            ErrorDialog("Invalid Credential!")
                            //ShowDialog2();
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }

                } else {
                    ErrorDialog("Invalid Credential / Unable to fetch data")
                }
                loadingDialog!!.hideDialog()
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                loadingDialog!!.hideDialog()
                ErrorDialog("Unable to get Network")
            }
        })
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
        super.onBackPressed()
        overridePendingTransition(R.anim.left_in, R.anim.right_out)
        finish()
    }

    private fun ShowDialog() {

        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)

        dialog.setContentView(R.layout.custom_dialog)
        dialog.setCancelable(false)

        val restart = dialog.findViewById<View>(R.id.restart) as Button

        restart.setOnClickListener {
            dialog.dismiss()
            startActivity(Intent(this@LoginActivity, WelcomeActivity::class.java))
            overridePendingTransition(R.anim.left_in, R.anim.right_out)
            finish()
        }
        dialog.show()
    }

    private fun ShowDialog2() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)

        dialog.setContentView(R.layout.custom_dialog3)
        dialog.setCancelable(false)

        val btn_dialog = dialog.findViewById<View>(R.id.btn_dialog) as Button

        btn_dialog.setOnClickListener { dialog.dismiss() }
        dialog.show()
    }

    override fun onResume() {
        super.onResume()
        networkChangeReceiver = NetworkChangeReceiver(this)
        network = networkChangeReceiver.isNetworkAvailable

        findViewById<View>(R.id.btnLogin).setOnClickListener {
            if (network!!) {

                val UNAME = uname.text.toString().trim { it <= ' ' }
                val password = login_password.text.toString().trim { it <= ' ' }
                if (UNAME.isEmpty()) {
                    val shake = AnimationUtils.loadAnimation(this@LoginActivity, R.anim.shake)
                    uname.startAnimation(shake)
                    uname.error = "Please Enter Email ID"
                    uname.requestFocus()
                } else if (!isValidEmail(UNAME)) {
                    val shake = AnimationUtils.loadAnimation(this@LoginActivity, R.anim.shake)
                    uname.startAnimation(shake)
                    uname.error = "Please Enter Valid Email Id"
                    uname.requestFocus()
                } else if (password.isEmpty()) {

                    val shake = AnimationUtils.loadAnimation(this@LoginActivity, R.anim.shake)
                    login_password.startAnimation(shake)
                    login_password.error = "Please Enter Your Password"
                    login_password.requestFocus()
                } else {
                    userLogin(UNAME, password)
                }
            } else {
                startActivity(Intent(this@LoginActivity, NetworkConnection::class.java))
                overridePendingTransition(R.anim.left_enter, R.anim.right_out)
            }
        }
    }

    companion object {

        fun isValidEmail(target: CharSequence): Boolean {
            return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()
        }
    }

}
