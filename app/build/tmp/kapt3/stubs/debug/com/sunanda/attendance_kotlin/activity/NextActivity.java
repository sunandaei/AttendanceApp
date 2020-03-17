package com.sunanda.attendance_kotlin.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u0000 g2\u00020\u00012\u00020\u0002:\u0002ghB\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u000bH\u0002J\b\u0010F\u001a\u00020DH\u0002J\u0010\u0010G\u001a\u00020D2\u0006\u0010H\u001a\u00020\u000bH\u0002J\b\u0010I\u001a\u00020DH\u0002J\u0018\u0010J\u001a\u00020\u000b2\u0006\u0010K\u001a\u00020\u000b2\u0006\u0010L\u001a\u00020\u000bH\u0002J\b\u0010M\u001a\u00020DH\u0002J\b\u0010N\u001a\u00020DH\u0016J\u0012\u0010O\u001a\u00020D2\b\u0010P\u001a\u0004\u0018\u00010QH\u0015J\u0012\u0010R\u001a\u00020D2\b\u0010S\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010T\u001a\u00020D2\u0006\u0010U\u001a\u00020\u000bH\u0016J\u0010\u0010V\u001a\u00020D2\u0006\u0010U\u001a\u00020\u000bH\u0016J \u0010W\u001a\u00020D2\u0006\u0010U\u001a\u00020\u000b2\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020QH\u0016JX\u0010[\u001a\u00020D2\u0006\u0010\\\u001a\u00020Y2\u0006\u0010]\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010^\u001a\u00020\u000b2\u0006\u0010_\u001a\u00020\u000b2\u0006\u0010`\u001a\u00020\u000b2\u0006\u0010a\u001a\u00020\u000b2\u0006\u0010b\u001a\u00020\u000b2\u0006\u0010c\u001a\u00020\u000b2\u0006\u0010d\u001a\u00020\u000bH\u0002J\b\u0010e\u001a\u00020DH\u0003J\b\u0010f\u001a\u00020DH\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u000eX\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\u001a\u0010\u001c\u001a\u00020\u001dX\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\'X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010.\u001a\u00020\u000eX\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0010\"\u0004\b0\u0010\u0012R\u001a\u00101\u001a\u000202X\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00107\u001a\u00020\u0005X\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0007\"\u0004\b9\u0010\tR\u001a\u0010:\u001a\u00020\u000eX\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0010\"\u0004\b<\u0010\u0012R\u001a\u0010=\u001a\u00020\u000eX\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0010\"\u0004\b?\u0010\u0012R\u001a\u0010@\u001a\u00020\u000eX\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0010\"\u0004\bB\u0010\u0012\u00a8\u0006i"}, d2 = {"Lcom/sunanda/attendance_kotlin/activity/NextActivity;", "Landroid/support/v7/app/AppCompatActivity;", "Landroid/location/LocationListener;", "()V", "address", "Landroid/widget/EditText;", "getAddress$app_debug", "()Landroid/widget/EditText;", "setAddress$app_debug", "(Landroid/widget/EditText;)V", "current_date", "", "current_date_time", "current_location", "Landroid/widget/TextView;", "getCurrent_location$app_debug", "()Landroid/widget/TextView;", "setCurrent_location$app_debug", "(Landroid/widget/TextView;)V", "databaseHandler", "Lcom/sunanda/attendance_kotlin/database/DatabaseHandler;", "getDatabaseHandler", "()Lcom/sunanda/attendance_kotlin/database/DatabaseHandler;", "setDatabaseHandler", "(Lcom/sunanda/attendance_kotlin/database/DatabaseHandler;)V", "email", "getEmail$app_debug", "setEmail$app_debug", "loadingDialog", "Lcom/sunanda/attendance_kotlin/helper/LoadingDialog;", "getLoadingDialog$app_debug", "()Lcom/sunanda/attendance_kotlin/helper/LoadingDialog;", "setLoadingDialog$app_debug", "(Lcom/sunanda/attendance_kotlin/helper/LoadingDialog;)V", "mCurrentLocation", "Landroid/location/Location;", "mFusedLocationClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "mLocationCallback", "Lcom/google/android/gms/location/LocationCallback;", "mLocationRequest", "Lcom/google/android/gms/location/LocationRequest;", "mLocationSettingsRequest", "Lcom/google/android/gms/location/LocationSettingsRequest;", "mSettingsClient", "Lcom/google/android/gms/location/SettingsClient;", "name", "getName$app_debug", "setName$app_debug", "sessionManager", "Lcom/sunanda/attendance_kotlin/helper/SessionManager;", "getSessionManager$app_debug", "()Lcom/sunanda/attendance_kotlin/helper/SessionManager;", "setSessionManager$app_debug", "(Lcom/sunanda/attendance_kotlin/helper/SessionManager;)V", "task", "getTask$app_debug", "setTask$app_debug", "tvAddress", "getTvAddress$app_debug", "setTvAddress$app_debug", "tvLatitude", "getTvLatitude$app_debug", "setTvLatitude$app_debug", "tvLongitude", "getTvLongitude$app_debug", "setTvLongitude$app_debug", "ErrorDialog", "", "error", "SaveData", "ShowDialog", "msg", "ShowSubmitDialog", "convertDate", "dateInMilliseconds", "dateFormat", "logout", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onLocationChanged", "location", "onProviderDisabled", "provider", "onProviderEnabled", "onStatusChanged", "status", "", "extras", "saveTask", "value", "user_id", "tasks", "lat", "lon", "type", "date_from", "date_to", "time", "startLocationUpdates", "updateLocationUI", "Companion", "GeocoderHandler", "app_debug"})
public final class NextActivity extends android.support.v7.app.AppCompatActivity implements android.location.LocationListener {
    @org.jetbrains.annotations.NotNull()
    public com.sunanda.attendance_kotlin.helper.SessionManager sessionManager;
    @org.jetbrains.annotations.NotNull()
    public android.widget.EditText address;
    @org.jetbrains.annotations.NotNull()
    public android.widget.EditText task;
    @org.jetbrains.annotations.NotNull()
    public android.widget.TextView name;
    @org.jetbrains.annotations.NotNull()
    public android.widget.TextView email;
    @org.jetbrains.annotations.NotNull()
    public android.widget.TextView tvAddress;
    @org.jetbrains.annotations.NotNull()
    public android.widget.TextView tvLatitude;
    @org.jetbrains.annotations.NotNull()
    public android.widget.TextView tvLongitude;
    @org.jetbrains.annotations.NotNull()
    public android.widget.TextView current_location;
    @org.jetbrains.annotations.NotNull()
    public com.sunanda.attendance_kotlin.helper.LoadingDialog loadingDialog;
    @org.jetbrains.annotations.NotNull()
    public com.sunanda.attendance_kotlin.database.DatabaseHandler databaseHandler;
    private com.google.android.gms.location.FusedLocationProviderClient mFusedLocationClient;
    private com.google.android.gms.location.SettingsClient mSettingsClient;
    private com.google.android.gms.location.LocationSettingsRequest mLocationSettingsRequest;
    private com.google.android.gms.location.LocationCallback mLocationCallback;
    private com.google.android.gms.location.LocationRequest mLocationRequest;
    private android.location.Location mCurrentLocation;
    private java.lang.String current_date;
    private java.lang.String current_date_time;
    private static final long UPDATE_INTERVAL_IN_MILLISECONDS = 600000L;
    private static final long FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS = 15000L;
    private static final int REQUEST_CHECK_SETTINGS = 100;
    public static final com.sunanda.attendance_kotlin.activity.NextActivity.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final com.sunanda.attendance_kotlin.helper.SessionManager getSessionManager$app_debug() {
        return null;
    }
    
    public final void setSessionManager$app_debug(@org.jetbrains.annotations.NotNull()
    com.sunanda.attendance_kotlin.helper.SessionManager p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.EditText getAddress$app_debug() {
        return null;
    }
    
    public final void setAddress$app_debug(@org.jetbrains.annotations.NotNull()
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.EditText getTask$app_debug() {
        return null;
    }
    
    public final void setTask$app_debug(@org.jetbrains.annotations.NotNull()
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getName$app_debug() {
        return null;
    }
    
    public final void setName$app_debug(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getEmail$app_debug() {
        return null;
    }
    
    public final void setEmail$app_debug(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getTvAddress$app_debug() {
        return null;
    }
    
    public final void setTvAddress$app_debug(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getTvLatitude$app_debug() {
        return null;
    }
    
    public final void setTvLatitude$app_debug(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getTvLongitude$app_debug() {
        return null;
    }
    
    public final void setTvLongitude$app_debug(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getCurrent_location$app_debug() {
        return null;
    }
    
    public final void setCurrent_location$app_debug(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.sunanda.attendance_kotlin.helper.LoadingDialog getLoadingDialog$app_debug() {
        return null;
    }
    
    public final void setLoadingDialog$app_debug(@org.jetbrains.annotations.NotNull()
    com.sunanda.attendance_kotlin.helper.LoadingDialog p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.sunanda.attendance_kotlin.database.DatabaseHandler getDatabaseHandler() {
        return null;
    }
    
    public final void setDatabaseHandler(@org.jetbrains.annotations.NotNull()
    com.sunanda.attendance_kotlin.database.DatabaseHandler p0) {
    }
    
    @android.annotation.SuppressLint(value = {"SimpleDateFormat", "SetTextI18n"})
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final java.lang.String convertDate(java.lang.String dateInMilliseconds, java.lang.String dateFormat) {
        return null;
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    private final void startLocationUpdates() {
    }
    
    private final void updateLocationUI() {
    }
    
    private final void ShowSubmitDialog() {
    }
    
    private final void ShowDialog(java.lang.String msg) {
    }
    
    private final void ErrorDialog(java.lang.String error) {
    }
    
    private final void SaveData() {
    }
    
    private final void logout() {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    @java.lang.Override()
    public void onLocationChanged(@org.jetbrains.annotations.Nullable()
    android.location.Location location) {
    }
    
    @java.lang.Override()
    public void onStatusChanged(@org.jetbrains.annotations.NotNull()
    java.lang.String provider, int status, @org.jetbrains.annotations.NotNull()
    android.os.Bundle extras) {
    }
    
    @java.lang.Override()
    public void onProviderEnabled(@org.jetbrains.annotations.NotNull()
    java.lang.String provider) {
    }
    
    @java.lang.Override()
    public void onProviderDisabled(@org.jetbrains.annotations.NotNull()
    java.lang.String provider) {
    }
    
    private final void saveTask(int value, java.lang.String user_id, java.lang.String address, java.lang.String tasks, java.lang.String lat, java.lang.String lon, java.lang.String type, java.lang.String date_from, java.lang.String date_to, java.lang.String time) {
    }
    
    public NextActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/sunanda/attendance_kotlin/activity/NextActivity$GeocoderHandler;", "Landroid/os/Handler;", "(Lcom/sunanda/attendance_kotlin/activity/NextActivity;)V", "handleMessage", "", "message", "Landroid/os/Message;", "app_debug"})
    final class GeocoderHandler extends android.os.Handler {
        
        @java.lang.Override()
        public void handleMessage(@org.jetbrains.annotations.NotNull()
        android.os.Message message) {
        }
        
        public GeocoderHandler() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/sunanda/attendance_kotlin/activity/NextActivity$Companion;", "", "()V", "FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS", "", "REQUEST_CHECK_SETTINGS", "", "UPDATE_INTERVAL_IN_MILLISECONDS", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}