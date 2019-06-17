package com.sunanda.attendance_kotlin

import android.app.Dialog
import android.content.Intent
import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView

import org.json.JSONException
import org.json.JSONObject

import java.io.IOException
import java.util.ArrayList
import java.util.concurrent.TimeUnit

import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TaskListActivity : AppCompatActivity() {

    internal lateinit var sessionManager: SessionManager
    internal lateinit var loadingDialog: LoadingDialog
    internal lateinit var networkChangeReceiver: NetworkChangeReceiver
    internal var network: Boolean? = false

    internal lateinit var recyclerView: RecyclerView
    internal var taskPojoArrayList = ArrayList<TaskPojo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_list)

        sessionManager = SessionManager(this)
        networkChangeReceiver = NetworkChangeReceiver(this)
        network = networkChangeReceiver.isNetworkAvailable
        loadingDialog = LoadingDialog(this)

        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar!!.title = ""
        val toolbar_title = findViewById<View>(R.id.title_txt) as TextView
        toolbar_title.typeface = Typeface.createFromAsset(assets, "proxima_nova_light.ttf")
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.left_arrow)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        toolbar_title.text = "Task Lists"

        recyclerView = findViewById(R.id.ticketTrailRecycler)
        val mLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = mLayoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
    }

    public override fun onResume() {
        super.onResume()
        if (network!!) {
            getList()
        } else {
            startActivity(Intent(this@TaskListActivity, NetworkConnection::class.java))
            overridePendingTransition(R.anim.left_in, R.anim.right_out)
        }
    }

    private fun getList() {

        taskPojoArrayList = ArrayList()

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

        val loginResponseCall = services.getList(sessionManager.keyId!!, "abc123456")
        loginResponseCall.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {

                if (response.body() != null) {

                    var constObject: JSONObject? = null
                    try {
                        constObject = JSONObject(response.body()!!.string())
                        if (constObject.getInt("resCode") == 200) {
                            val jsonArray = constObject.getJSONArray("attendence")
                            if (jsonArray.length() != 0) {
                                for (i in 0 until jsonArray.length()) {
                                    val jsonObject = jsonArray.getJSONObject(i)
                                    val address = jsonObject.getString("address")
                                    val task = jsonObject.getString("task")
                                    val updated_at = jsonObject.getString("updated_at")
                                    val taskPojo = TaskPojo()
                                    taskPojo.address = address
                                    taskPojo.task = task
                                    taskPojo.updatedAt = updated_at
                                    taskPojoArrayList.add(taskPojo)
                                }
                                val trailAdapter = TaskAdapter(this@TaskListActivity, taskPojoArrayList)
                                recyclerView.adapter = trailAdapter
                            } else {
                                val dialog = Dialog(this@TaskListActivity)
                                dialog.setContentView(R.layout.error_popup)
                                val dialogButton = dialog.findViewById<View>(R.id.dialogButtonOK) as Button
                                val text = dialog.findViewById<TextView>(R.id.text)
                                text.text = "No Record Found!"
                                // if button is clicked, close the custom dialog
                                dialogButton.setOnClickListener {
                                    dialog.dismiss()
                                    overridePendingTransition(R.anim.right_in, R.anim.left_out)
                                    finish()
                                }
                                dialog.show()
                                dialog.setCancelable(false)
                            }
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }

                }
                loadingDialog.hideDialog()
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                //Toast.makeText(TaskListActivity.this, "dvavg", Toast.LENGTH_SHORT).show();
                loadingDialog.hideDialog()
            }
        })
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
