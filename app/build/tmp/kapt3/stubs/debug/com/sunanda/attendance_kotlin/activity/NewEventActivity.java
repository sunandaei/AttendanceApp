package com.sunanda.attendance_kotlin.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u00ca\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u008c\u00012\u00020\u0001:\u0004\u008c\u0001\u008d\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010U\u001a\u0004\u0018\u00010\u00062\u0006\u0010V\u001a\u00020WJ\u0010\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020\u0006H\u0002J\b\u0010[\u001a\u00020YH\u0002J\u0010\u0010\\\u001a\u00020Y2\u0006\u0010]\u001a\u00020\u0006H\u0002J\u0010\u0010^\u001a\u0004\u0018\u00010W2\u0006\u0010_\u001a\u00020\u0006J\u001e\u0010`\u001a\u00020\u00042\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020\u00042\u0006\u0010d\u001a\u00020\u0004J\u000e\u0010e\u001a\u00020\u00062\u0006\u0010f\u001a\u00020\u0006J\n\u0010g\u001a\u0004\u0018\u00010hH\u0003J\u000e\u0010i\u001a\u00020Y2\u0006\u0010j\u001a\u00020kJ\u0010\u0010l\u001a\u0002072\b\u0010m\u001a\u0004\u0018\u00010hJ\n\u0010n\u001a\u0004\u0018\u00010hH\u0002J\b\u0010o\u001a\u00020\u0006H\u0002J\u000e\u0010p\u001a\u00020\u00062\u0006\u0010f\u001a\u00020\u0006J\u000e\u0010q\u001a\u00020\u00062\u0006\u0010r\u001a\u00020sJ\u0012\u0010q\u001a\u0004\u0018\u00010\u00062\u0006\u0010t\u001a\u00020\u0006H\u0002J\u0016\u0010u\u001a\u00020W2\u0006\u0010_\u001a\u00020W2\u0006\u0010v\u001a\u00020\u0004J\b\u0010w\u001a\u00020YH\u0002J\"\u0010x\u001a\u00020Y2\u0006\u0010y\u001a\u00020\u00042\u0006\u0010z\u001a\u00020\u00042\b\u0010{\u001a\u0004\u0018\u00010|H\u0014J\b\u0010}\u001a\u00020YH\u0016J\u0013\u0010~\u001a\u00020Y2\t\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u0001H\u0015J\u0013\u0010\u0081\u0001\u001a\u0002072\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0016J\t\u0010\u0084\u0001\u001a\u00020YH\u0002J\t\u0010\u0085\u0001\u001a\u00020YH\u0002J\u000b\u0010\u0086\u0001\u001a\u0004\u0018\u00010hH\u0002J\t\u0010\u0087\u0001\u001a\u00020YH\u0003J\t\u0010\u0088\u0001\u001a\u00020YH\u0002J\u001b\u0010\u0089\u0001\u001a\u00020Y2\u0007\u0010\u008a\u0001\u001a\u00020\u00062\u0007\u0010\u008b\u0001\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0010\u0010\'\u001a\u0004\u0018\u00010(X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u00106\u001a\u0004\u0018\u000107X\u0080\u000e\u00a2\u0006\u0010\n\u0002\u0010<\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001a\u0010=\u001a\u00020>X\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001a\u0010C\u001a\u00020DX\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001a\u0010I\u001a\u00020\bX\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\n\"\u0004\bK\u0010\fR\u001a\u0010L\u001a\u00020\u0010X\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u0012\"\u0004\bN\u0010\u0014R\u001a\u0010O\u001a\u00020\u0010X\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u0012\"\u0004\bQ\u0010\u0014R\u001a\u0010R\u001a\u00020\u0010X\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u0012\"\u0004\bT\u0010\u0014\u00a8\u0006\u008e\u0001"}, d2 = {"Lcom/sunanda/attendance_kotlin/activity/NewEventActivity;", "Landroid/support/v7/app/AppCompatActivity;", "()V", "CAMERA_REQUEST", "", "JPEG_FILE_SUFFIX", "", "address", "Landroid/widget/EditText;", "getAddress$app_debug", "()Landroid/widget/EditText;", "setAddress$app_debug", "(Landroid/widget/EditText;)V", "current_date", "current_date_time", "current_location", "Landroid/widget/TextView;", "getCurrent_location$app_debug", "()Landroid/widget/TextView;", "setCurrent_location$app_debug", "(Landroid/widget/TextView;)V", "databaseHandler", "Lcom/sunanda/attendance_kotlin/database/DatabaseHandler;", "getDatabaseHandler", "()Lcom/sunanda/attendance_kotlin/database/DatabaseHandler;", "setDatabaseHandler", "(Lcom/sunanda/attendance_kotlin/database/DatabaseHandler;)V", "ivPicture", "Landroid/widget/ImageView;", "getIvPicture$app_debug", "()Landroid/widget/ImageView;", "setIvPicture$app_debug", "(Landroid/widget/ImageView;)V", "loadingDialog", "Lcom/sunanda/attendance_kotlin/helper/LoadingDialog;", "getLoadingDialog$app_debug", "()Lcom/sunanda/attendance_kotlin/helper/LoadingDialog;", "setLoadingDialog$app_debug", "(Lcom/sunanda/attendance_kotlin/helper/LoadingDialog;)V", "mAlbumStorageDirFactory", "Lcom/sunanda/attendance_kotlin/helper/AlbumStorageDirFactory;", "mCurrentLocation", "Landroid/location/Location;", "mCurrentPhotoPath", "mFusedLocationClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "mLocationCallback", "Lcom/google/android/gms/location/LocationCallback;", "mLocationRequest", "Lcom/google/android/gms/location/LocationRequest;", "mLocationSettingsRequest", "Lcom/google/android/gms/location/LocationSettingsRequest;", "mSettingsClient", "Lcom/google/android/gms/location/SettingsClient;", "network", "", "getNetwork$app_debug", "()Ljava/lang/Boolean;", "setNetwork$app_debug", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "networkChangeReceiver", "Lcom/sunanda/attendance_kotlin/activity/NetworkChangeReceiver;", "getNetworkChangeReceiver$app_debug", "()Lcom/sunanda/attendance_kotlin/activity/NetworkChangeReceiver;", "setNetworkChangeReceiver$app_debug", "(Lcom/sunanda/attendance_kotlin/activity/NetworkChangeReceiver;)V", "sessionManager", "Lcom/sunanda/attendance_kotlin/helper/SessionManager;", "getSessionManager$app_debug", "()Lcom/sunanda/attendance_kotlin/helper/SessionManager;", "setSessionManager$app_debug", "(Lcom/sunanda/attendance_kotlin/helper/SessionManager;)V", "task", "getTask$app_debug", "setTask$app_debug", "tvAddress", "getTvAddress$app_debug", "setTvAddress$app_debug", "tvLatitude", "getTvLatitude$app_debug", "setTvLatitude$app_debug", "tvLongitude", "getTvLongitude$app_debug", "setTvLongitude$app_debug", "BitMapToString", "userImage1", "Landroid/graphics/Bitmap;", "ErrorDialog", "", "error", "SaveData", "ShowDialog", "msg", "StringToBitMap", "image", "calculateInSampleSize", "options", "Landroid/graphics/BitmapFactory$Options;", "reqWidth", "reqHeight", "compressImage", "imageUri", "createImageFile", "Ljava/io/File;", "deleteCache", "context", "Landroid/content/Context;", "deleteDir", "dir", "getAlbumDir", "getAlbumName", "getFilename", "getRealPathFromURI", "uri", "Landroid/net/Uri;", "contentURI", "getResizedBitmap", "maxSize", "handleBigCameraPhoto", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "selectImage", "setPic", "setUpPhotoFile", "startLocationUpdates", "updateLocationUI", "uploadFileSource", "str", "str2", "Companion", "GeocoderHandler", "app_debug"})
public final class NewEventActivity extends android.support.v7.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    public com.sunanda.attendance_kotlin.helper.SessionManager sessionManager;
    @org.jetbrains.annotations.NotNull()
    public com.sunanda.attendance_kotlin.helper.LoadingDialog loadingDialog;
    @org.jetbrains.annotations.NotNull()
    public com.sunanda.attendance_kotlin.activity.NetworkChangeReceiver networkChangeReceiver;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Boolean network;
    private com.sunanda.attendance_kotlin.helper.AlbumStorageDirFactory mAlbumStorageDirFactory;
    private final int CAMERA_REQUEST = 11;
    private java.lang.String mCurrentPhotoPath;
    @org.jetbrains.annotations.NotNull()
    public android.widget.ImageView ivPicture;
    private final java.lang.String JPEG_FILE_SUFFIX = ".png";
    @org.jetbrains.annotations.NotNull()
    public com.sunanda.attendance_kotlin.database.DatabaseHandler databaseHandler;
    @org.jetbrains.annotations.NotNull()
    public android.widget.TextView tvAddress;
    @org.jetbrains.annotations.NotNull()
    public android.widget.TextView tvLatitude;
    @org.jetbrains.annotations.NotNull()
    public android.widget.TextView tvLongitude;
    @org.jetbrains.annotations.NotNull()
    public android.widget.TextView current_location;
    @org.jetbrains.annotations.NotNull()
    public android.widget.EditText address;
    @org.jetbrains.annotations.NotNull()
    public android.widget.EditText task;
    private com.google.android.gms.location.FusedLocationProviderClient mFusedLocationClient;
    private com.google.android.gms.location.SettingsClient mSettingsClient;
    private com.google.android.gms.location.LocationSettingsRequest mLocationSettingsRequest;
    private com.google.android.gms.location.LocationCallback mLocationCallback;
    private com.google.android.gms.location.LocationRequest mLocationRequest;
    private android.location.Location mCurrentLocation;
    private java.lang.String current_date;
    private java.lang.String current_date_time;
    private static final long UPDATE_INTERVAL_IN_MILLISECONDS = 10000L;
    private static final long FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS = 5000L;
    private static final int REQUEST_CHECK_SETTINGS = 100;
    public static final com.sunanda.attendance_kotlin.activity.NewEventActivity.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final com.sunanda.attendance_kotlin.helper.SessionManager getSessionManager$app_debug() {
        return null;
    }
    
    public final void setSessionManager$app_debug(@org.jetbrains.annotations.NotNull()
    com.sunanda.attendance_kotlin.helper.SessionManager p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.sunanda.attendance_kotlin.helper.LoadingDialog getLoadingDialog$app_debug() {
        return null;
    }
    
    public final void setLoadingDialog$app_debug(@org.jetbrains.annotations.NotNull()
    com.sunanda.attendance_kotlin.helper.LoadingDialog p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.sunanda.attendance_kotlin.activity.NetworkChangeReceiver getNetworkChangeReceiver$app_debug() {
        return null;
    }
    
    public final void setNetworkChangeReceiver$app_debug(@org.jetbrains.annotations.NotNull()
    com.sunanda.attendance_kotlin.activity.NetworkChangeReceiver p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getNetwork$app_debug() {
        return null;
    }
    
    public final void setNetwork$app_debug(@org.jetbrains.annotations.Nullable()
    java.lang.Boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.ImageView getIvPicture$app_debug() {
        return null;
    }
    
    public final void setIvPicture$app_debug(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.sunanda.attendance_kotlin.database.DatabaseHandler getDatabaseHandler() {
        return null;
    }
    
    public final void setDatabaseHandler(@org.jetbrains.annotations.NotNull()
    com.sunanda.attendance_kotlin.database.DatabaseHandler p0) {
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
    
    @android.annotation.SuppressLint(value = {"SimpleDateFormat"})
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void SaveData() {
    }
    
    private final void uploadFileSource(java.lang.String str, java.lang.String str2) {
    }
    
    private final void ShowDialog(java.lang.String msg) {
    }
    
    private final void ErrorDialog(java.lang.String error) {
    }
    
    private final java.io.File setUpPhotoFile() {
        return null;
    }
    
    @android.annotation.SuppressLint(value = {"SimpleDateFormat"})
    private final java.io.File createImageFile() {
        return null;
    }
    
    private final java.io.File getAlbumDir() {
        return null;
    }
    
    private final java.lang.String getAlbumName() {
        return null;
    }
    
    public final void deleteCache(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    public final boolean deleteDir(@org.jetbrains.annotations.Nullable()
    java.io.File dir) {
        return false;
    }
    
    private final void handleBigCameraPhoto() {
    }
    
    private final void setPic() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String compressImage(@org.jetbrains.annotations.NotNull()
    java.lang.String imageUri) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFilename(@org.jetbrains.annotations.NotNull()
    java.lang.String imageUri) {
        return null;
    }
    
    public final int calculateInSampleSize(@org.jetbrains.annotations.NotNull()
    android.graphics.BitmapFactory.Options options, int reqWidth, int reqHeight) {
        return 0;
    }
    
    private final java.lang.String getRealPathFromURI(java.lang.String contentURI) {
        return null;
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    private final void startLocationUpdates() {
    }
    
    private final void updateLocationUI() {
    }
    
    private final void selectImage() {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRealPathFromURI(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String BitMapToString(@org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap userImage1) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.graphics.Bitmap getResizedBitmap(@org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap image, int maxSize) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.graphics.Bitmap StringToBitMap(@org.jetbrains.annotations.NotNull()
    java.lang.String image) {
        return null;
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    public NewEventActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/sunanda/attendance_kotlin/activity/NewEventActivity$GeocoderHandler;", "Landroid/os/Handler;", "(Lcom/sunanda/attendance_kotlin/activity/NewEventActivity;)V", "handleMessage", "", "message", "Landroid/os/Message;", "app_debug"})
    final class GeocoderHandler extends android.os.Handler {
        
        @java.lang.Override()
        public void handleMessage(@org.jetbrains.annotations.NotNull()
        android.os.Message message) {
        }
        
        public GeocoderHandler() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/sunanda/attendance_kotlin/activity/NewEventActivity$Companion;", "", "()V", "FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS", "", "REQUEST_CHECK_SETTINGS", "", "UPDATE_INTERVAL_IN_MILLISECONDS", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}