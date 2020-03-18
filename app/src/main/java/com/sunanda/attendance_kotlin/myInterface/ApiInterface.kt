package com.sunanda.attendance_kotlin.myInterface

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiInterface {

   /* @get:GET("https://api.androidhive.info/json/movies.json")
    val lists: Call<List<TaskPojo>> */

    //login
    @FormUrlEncoded
    @POST("api-attendence-login")
    fun loginRequest(@Field("email") username: String, @Field("password") password: String): Call<ResponseBody>

    @FormUrlEncoded
    @POST("api-attendence-insert")
    fun insert_data(@Field("key") key: String, @Field("user_id") user_id: String,
                    @Field("address") address: String, @Field("task") task: String,
                    @Field("lat") lat: String, @Field("long") lon: String, @Field("type") type: String,
                    @Field("date_from") date_from: String, @Field("date_to") date_to: String,
                    @Field("time") time: String, @Field("imageName") imageName: String,
                    @Field("attn_day") day: String, @Field("attn_month") month: String,
                    @Field("attn_year") year: String): Call<ResponseBody>

    @FormUrlEncoded
    @POST("api-attendence-list")
    fun getList(@Field("user_id") user_id: String, @Field("key") key: String): Call<ResponseBody>
}
