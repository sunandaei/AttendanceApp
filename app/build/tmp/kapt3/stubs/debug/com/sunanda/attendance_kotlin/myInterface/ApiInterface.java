package com.sunanda.attendance_kotlin.myInterface;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\'J\u009a\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\u00062\b\b\u0001\u0010\r\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010\u0010\u001a\u00020\u00062\b\b\u0001\u0010\u0011\u001a\u00020\u00062\b\b\u0001\u0010\u0012\u001a\u00020\u00062\b\b\u0001\u0010\u0013\u001a\u00020\u00062\b\b\u0001\u0010\u0014\u001a\u00020\u0006H\'J\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0016\u001a\u00020\u00062\b\b\u0001\u0010\u0017\u001a\u00020\u0006H\'\u00a8\u0006\u0018"}, d2 = {"Lcom/sunanda/attendance_kotlin/myInterface/ApiInterface;", "", "getList", "Lretrofit2/Call;", "Lokhttp3/ResponseBody;", "user_id", "", "key", "insert_data", "address", "task", "lat", "lon", "type", "date_from", "date_to", "time", "imageName", "day", "month", "year", "loginRequest", "username", "password", "app_debug"})
public abstract interface ApiInterface {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "api-attendence-login")
    @retrofit2.http.FormUrlEncoded()
    public abstract retrofit2.Call<okhttp3.ResponseBody> loginRequest(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "email")
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "password")
    java.lang.String password);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "api-attendence-insert")
    @retrofit2.http.FormUrlEncoded()
    public abstract retrofit2.Call<okhttp3.ResponseBody> insert_data(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "key")
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "user_id")
    java.lang.String user_id, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "address")
    java.lang.String address, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "task")
    java.lang.String task, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "lat")
    java.lang.String lat, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "long")
    java.lang.String lon, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "type")
    java.lang.String type, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "date_from")
    java.lang.String date_from, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "date_to")
    java.lang.String date_to, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "time")
    java.lang.String time, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "imageName")
    java.lang.String imageName, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "attn_day")
    java.lang.String day, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "attn_month")
    java.lang.String month, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "attn_year")
    java.lang.String year);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "api-attendence-list")
    @retrofit2.http.FormUrlEncoded()
    public abstract retrofit2.Call<okhttp3.ResponseBody> getList(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "user_id")
    java.lang.String user_id, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "key")
    java.lang.String key);
}