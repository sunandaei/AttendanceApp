package com.sunanda.attendance_kotlin.activity

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.text.TextUtils
import android.view.MenuItem
import android.view.View
import android.view.Window
import android.widget.*
import com.sunanda.attendance_kotlin.R
import com.sunanda.attendance_kotlin.helper.Constants
import com.sunanda.attendance_kotlin.helper.LoadingDialog
import com.sunanda.attendance_kotlin.helper.SessionManager
import com.sunanda.attendance_kotlin.myInterface.ApiInterface
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

class LeaveApply : AppCompatActivity() {

    internal var radioButton: RadioButton? = null
    internal lateinit var radioGroup: RadioGroup
    internal lateinit var sessionManager: SessionManager
    internal lateinit var loadingDialog: LoadingDialog
    internal lateinit var networkChangeReceiver: NetworkChangeReceiver
    internal var network: Boolean? = false
    internal var value = ""
    internal var Sdate = ""
    internal var Edate = ""
    internal lateinit var start_date: TextView
    internal lateinit var end_date: TextView
    internal lateinit var task: EditText

    internal var myCalendar = Calendar.getInstance()
    internal var date: DatePickerDialog.OnDateSetListener = DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
        myCalendar.set(Calendar.YEAR, year)
        myCalendar.set(Calendar.MONTH, monthOfYear)
        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
        updateLabel()
    }

    internal var myCalendar2 = Calendar.getInstance()
    internal var date2: DatePickerDialog.OnDateSetListener = DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
        myCalendar2.set(Calendar.YEAR, year)
        myCalendar2.set(Calendar.MONTH, monthOfYear)
        myCalendar2.set(Calendar.DAY_OF_MONTH, dayOfMonth)
        updateLabe2()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leave_apply)

        sessionManager = SessionManager(this)
        networkChangeReceiver = NetworkChangeReceiver(this)
        network = networkChangeReceiver.isNetworkAvailable
        loadingDialog = LoadingDialog(this)
        radioGroup = findViewById<View>(R.id.radioGroup) as RadioGroup
        start_date = findViewById(R.id.start_date)
        end_date = findViewById(R.id.end_date)
        task = findViewById(R.id.task)

        /*task.imeOptions = EditorInfo.IME_ACTION_DONE
        task.setRawInputType(InputType.TYPE_CLASS_TEXT)*/

        radioGroup.setOnCheckedChangeListener { _, _ ->
            value = (findViewById<View>(radioGroup.checkedRadioButtonId) as RadioButton)
                    .text.toString().trim { it <= ' ' }
            //Toast.makeText(getBaseContext(), value, Toast.LENGTH_SHORT).show();
            findViewById<View>(R.id.date_select).visibility = View.VISIBLE
            Sdate = ""
            Edate = ""
            if (value.equals("single day", ignoreCase = true)) {
                start_date.text = "Select Date"
                end_date.visibility = View.GONE
            } else {
                start_date.text = "Select Start Date"
                end_date.visibility = View.VISIBLE
            }
        }

        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar!!.title = ""
        val toolbar_title = findViewById<View>(R.id.title_txt) as TextView
        toolbar_title.typeface = Typeface.createFromAsset(assets, "proxima_nova_light.ttf")
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.left_arrow)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        toolbar_title.text = "Apply Leave"

        start_date.setOnClickListener {
            val datePickerDialog = DatePickerDialog(this@LeaveApply, date, myCalendar
                    .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH))
            //myCalendar.add(Calendar.DAY_OF_MONTH, 1)
            datePickerDialog.show()
            //datePickerDialog.getDatePicker().setMaxDate(new Date().getTime());
            datePickerDialog.datePicker.minDate = Date().time
        }

        end_date.setOnClickListener {
            val datePickerDialog = DatePickerDialog(this@LeaveApply, date2, myCalendar2
                    .get(Calendar.YEAR), myCalendar2.get(Calendar.MONTH),
                    myCalendar2.get(Calendar.DAY_OF_MONTH))
            myCalendar2.add(Calendar.DAY_OF_MONTH, 1)
            datePickerDialog.show()
            //datePickerDialog.getDatePicker().setMaxDate(new Date().getTime());
            datePickerDialog.datePicker.minDate = Date().time
        }
    }

    override fun onResume() {
        super.onResume()
        network = networkChangeReceiver.isNetworkAvailable
        findViewById<View>(R.id.applyLeave).setOnClickListener {
            if (TextUtils.isEmpty(value)) {
                ErrorDialog("Please select your option")
            } else if (value.equals("single day", ignoreCase = true)) {
                if (start_date.text.toString().equals("select date", ignoreCase = true))
                    ErrorDialog("Please Select Date")
                else if (TextUtils.isEmpty(task.text.toString()))
                    ErrorDialog("Enter Purpose of Leave")
                else {
                    Sdate = start_date.text.toString()
                    Edate = Sdate

                    if (network!!) {
                        sendLeaveInfo()
                    } else {
                        startActivity(Intent(this@LeaveApply, NetworkConnection::class.java))
                        overridePendingTransition(R.anim.left_in, R.anim.right_out)
                    }
                }
            } else {
                if (start_date.text.toString().equals("select start date", ignoreCase = true))
                    ErrorDialog("Please Select Start Date")
                else if (end_date.text.toString().equals("select end date", ignoreCase = true))
                    ErrorDialog("Please Select End Date")
                else if (DayDifference(start_date.text.toString(), end_date.text.toString()) < 2) {
                    ErrorDialog("Difference between Start & End Date should be > 1")
                } else if (TextUtils.isEmpty(task.text.toString()))
                    ErrorDialog("Enter Purpose of Leave")
                else {
                    Sdate = start_date.text.toString()
                    Edate = end_date.text.toString()

                    if (network!!) {
                        sendLeaveInfo()
                    } else {
                        startActivity(Intent(this@LeaveApply, NetworkConnection::class.java))
                        overridePendingTransition(R.anim.left_in, R.anim.right_out)
                    }
                }
            }
        }
    }

    private fun updateLabel() {
        @SuppressLint("SimpleDateFormat")
        val df = SimpleDateFormat("yyyy-MM-dd")
        start_date.text = df.format(myCalendar.time)
    }

    private fun updateLabe2() {
        @SuppressLint("SimpleDateFormat")
        val df = SimpleDateFormat("yyyy-MM-dd")
        end_date.text = df.format(myCalendar2.time)
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
            showDialog2()
        }
        dialog.show()
    }

    @SuppressLint("SetTextI18n")
    private fun showDialog2() {

        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)

        dialog.setContentView(R.layout.custom_dialog2)
        dialog.setCancelable(false)

        val btn_yes = dialog.findViewById<View>(R.id.btn_yes) as Button
        val btn_no = dialog.findViewById<View>(R.id.btn_no) as Button

        val title_txt = dialog.findViewById<TextView>(R.id.txt_dia)
        title_txt.text = "Do you want to stay in the App?"

        btn_yes.setOnClickListener {
            dialog.dismiss()
            startActivity(Intent(this@LeaveApply, AttendanceActivity::class.java))
            overridePendingTransition(R.anim.right_in, R.anim.left_out)
            finish()
        }
        btn_no.setOnClickListener {
            dialog.dismiss()
            overridePendingTransition(R.anim.right_in, R.anim.left_out)
            finish()
        }

        dialog.show()
    }

    private fun DayDifference(dateBeforeString: String, dateAfterString: String): Int {
        @SuppressLint("SimpleDateFormat")
        val myFormat = SimpleDateFormat("yyyy-MM-dd")
        var daysBetween = 0
        try {
            val dateBefore = myFormat.parse(dateBeforeString)
            val dateAfter = myFormat.parse(dateAfterString)
            val difference = dateAfter.time - dateBefore.time
            daysBetween = (difference / (1000 * 60 * 60 * 24)).toInt()
            /* You can also convert the milliseconds to days using this method
             * float daysBetween =
             *         TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS)
             */
            //Log.d("Number_Days:", daysBetween + "");
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return daysBetween
    }

    private fun sendLeaveInfo() {

        val c = Calendar.getInstance()
        @SuppressLint("SimpleDateFormat")
        val df = SimpleDateFormat("yyyy-MM-dd")
        @SuppressLint("SimpleDateFormat")
        val formattedDate = df.format(c.time)
        val current_date_time = formattedDate

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

        val tempTime = current_date_time.split(" ")[0]

        val loginResponseCall = services.insert_data("abc123456", sessionManager.keyId!!,// not null
                "NA", task.text.toString(), "0.0", "0.0", "Leave", Sdate, Edate, current_date_time, "",
                tempTime.split("-")[2], tempTime.split("-")[1], tempTime.split("-")[0])

        loginResponseCall.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {

                if (response.body() != null) {

                    try {
                        val jsonObject = JSONObject(response.body()!!.string())
                        if (jsonObject.getInt("resCode") == 200) {
                            ShowDialog("Leave have been applied successfully.")
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            super.onBackPressed()
            startActivity(Intent(this@LeaveApply, WelcomeActivity::class.java))
            overridePendingTransition(R.anim.right_in, R.anim.left_out)
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this@LeaveApply, WelcomeActivity::class.java))
        overridePendingTransition(R.anim.right_in, R.anim.left_out)
        finish()
    }
}
