package com.sunanda.attendance_kotlin.myInterface;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\'\u00a8\u0006\t"}, d2 = {"Lcom/sunanda/attendance_kotlin/myInterface/ApiConfig;", "", "uploadFile", "Lretrofit2/Call;", "Lcom/sunanda/attendance_kotlin/model/ServerResponse;", "file", "Lokhttp3/MultipartBody$Part;", "name", "Lokhttp3/RequestBody;", "app_debug"})
public abstract interface ApiConfig {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "RoutineImageUploadApi.php")
    @retrofit2.http.Multipart()
    public abstract retrofit2.Call<com.sunanda.attendance_kotlin.model.ServerResponse> uploadFile(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Part()
    okhttp3.MultipartBody.Part file, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Part(value = "name")
    okhttp3.RequestBody name);
}