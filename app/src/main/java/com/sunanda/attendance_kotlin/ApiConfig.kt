package com.sunanda.attendance_kotlin

import com.sunanda.attendance_kotlin.ServerResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiConfig {

    @Multipart
    @POST("WtpImageUploadApi.php")
    fun uploadFile(@Part file: MultipartBody.Part, @Part("name") name: RequestBody,
                   @Part("key") key: RequestBody, @Part("user_id") user_id: RequestBody,
                   @Part("address") address: RequestBody, @Part("task") task: RequestBody,
                   @Part("lat") lat: RequestBody, @Part("long") lon: RequestBody,
                   @Part("type") type: RequestBody, @Part("date_from") date_from: RequestBody,
                   @Part("date_to") date_to: RequestBody): Call<ServerResponse>
}