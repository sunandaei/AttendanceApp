package com.sunanda.attendance_kotlin.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u00e2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u0091\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0004\u0091\u0001\u0092\u0001B\u0005\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020^H\u0002J\u0010\u0010_\u001a\u00020\\2\u0006\u0010`\u001a\u00020VH\u0002J\u0010\u0010a\u001a\u00020\\2\u0006\u0010`\u001a\u00020VH\u0002J\u0010\u0010b\u001a\u00020\\2\u0006\u0010c\u001a\u00020^H\u0002J\b\u0010d\u001a\u000207H\u0002J\b\u0010e\u001a\u00020\\H\u0005J\b\u0010f\u001a\u00020\\H\u0002J\u000e\u0010g\u001a\u00020\\2\u0006\u0010h\u001a\u00020iJ\u0010\u0010j\u001a\u0002072\b\u0010k\u001a\u0004\u0018\u00010lJ\u0010\u0010m\u001a\u00020\\2\u0006\u0010n\u001a\u00020RH\u0002J\b\u0010o\u001a\u00020^H\u0002J\u0010\u0010p\u001a\u00020q2\b\u0010r\u001a\u0004\u0018\u00010sJ\b\u0010t\u001a\u00020\\H\u0002J\b\u0010u\u001a\u00020\\H\u0002J\b\u0010v\u001a\u00020\\H\u0002J\b\u0010w\u001a\u00020\\H\u0016J\u0012\u0010x\u001a\u00020\\2\b\u0010y\u001a\u0004\u0018\u00010zH\u0016J\u0010\u0010{\u001a\u00020\\2\u0006\u0010|\u001a\u00020}H\u0016J\u0010\u0010~\u001a\u00020\\2\u0006\u0010\u007f\u001a\u00020VH\u0016J\u0014\u0010\u0080\u0001\u001a\u00020\\2\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010zH\u0014J\u0014\u0010\u0082\u0001\u001a\u00020\\2\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010\"H\u0016J\t\u0010\u0084\u0001\u001a\u00020\\H\u0014J\t\u0010\u0085\u0001\u001a\u00020\\H\u0002J\u001a\u0010\u0086\u0001\u001a\u00020\\2\u0007\u0010\u0087\u0001\u001a\u00020^2\u0006\u0010`\u001a\u00020VH\u0002J\t\u0010\u0088\u0001\u001a\u00020\\H\u0003J\u001a\u0010\u0089\u0001\u001a\u00020\\2\b\u0010\u008a\u0001\u001a\u00030\u008b\u00012\u0007\u0010\u008c\u0001\u001a\u00020&J\t\u0010\u008d\u0001\u001a\u00020\\H\u0002J#\u0010\u008e\u0001\u001a\u00020\\2\u0007\u0010\u008f\u0001\u001a\u00020^2\u0007\u0010\u0090\u0001\u001a\u00020^2\u0006\u0010`\u001a\u00020VH\u0002R\u001a\u0010\u0006\u001a\u00020\u0007X\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0007X\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000bR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u00020&X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u00103\u001a\u00020\u0013X\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0015\"\u0004\b5\u0010\u0017R\u001e\u00106\u001a\u0004\u0018\u000107X\u0080\u000e\u00a2\u0006\u0010\n\u0002\u0010<\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001a\u0010=\u001a\u00020>X\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001a\u0010C\u001a\u00020DX\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR*\u0010I\u001a\u0012\u0012\u0004\u0012\u00020K0Jj\b\u0012\u0004\u0012\u00020K`LX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR*\u0010Q\u001a\u0012\u0012\u0004\u0012\u00020R0Jj\b\u0012\u0004\u0012\u00020R`LX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bS\u0010N\"\u0004\bT\u0010PR\u001a\u0010U\u001a\u00020VX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010Z\u00a8\u0006\u0093\u0001"}, d2 = {"Lcom/sunanda/attendance_kotlin/activity/WelcomeActivity;", "Landroid/support/v7/app/AppCompatActivity;", "Lcom/google/android/gms/location/LocationListener;", "Lcom/google/android/gms/common/api/GoogleApiClient$ConnectionCallbacks;", "Lcom/google/android/gms/common/api/GoogleApiClient$OnConnectionFailedListener;", "()V", "attendance", "Landroid/widget/Button;", "getAttendance$app_debug", "()Landroid/widget/Button;", "setAttendance$app_debug", "(Landroid/widget/Button;)V", "databaseHandler", "Lcom/sunanda/attendance_kotlin/database/DatabaseHandler;", "getDatabaseHandler", "()Lcom/sunanda/attendance_kotlin/database/DatabaseHandler;", "setDatabaseHandler", "(Lcom/sunanda/attendance_kotlin/database/DatabaseHandler;)V", "email", "Landroid/widget/TextView;", "getEmail$app_debug", "()Landroid/widget/TextView;", "setEmail$app_debug", "(Landroid/widget/TextView;)V", "leave", "getLeave$app_debug", "setLeave$app_debug", "loadingDialog", "Lcom/sunanda/attendance_kotlin/helper/LoadingDialog;", "getLoadingDialog", "()Lcom/sunanda/attendance_kotlin/helper/LoadingDialog;", "setLoadingDialog", "(Lcom/sunanda/attendance_kotlin/helper/LoadingDialog;)V", "mCurrentLocation", "Landroid/location/Location;", "mFusedLocationClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "mGoogleApiClient", "Lcom/google/android/gms/common/api/GoogleApiClient;", "getMGoogleApiClient", "()Lcom/google/android/gms/common/api/GoogleApiClient;", "setMGoogleApiClient", "(Lcom/google/android/gms/common/api/GoogleApiClient;)V", "mLocationCallback", "Lcom/google/android/gms/location/LocationCallback;", "mLocationRequest", "Lcom/google/android/gms/location/LocationRequest;", "mLocationSettingsRequest", "Lcom/google/android/gms/location/LocationSettingsRequest;", "mSettingsClient", "Lcom/google/android/gms/location/SettingsClient;", "name", "getName$app_debug", "setName$app_debug", "network", "", "getNetwork$app_debug", "()Ljava/lang/Boolean;", "setNetwork$app_debug", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "networkChangeReceiver", "Lcom/sunanda/attendance_kotlin/activity/NetworkChangeReceiver;", "getNetworkChangeReceiver$app_debug", "()Lcom/sunanda/attendance_kotlin/activity/NetworkChangeReceiver;", "setNetworkChangeReceiver$app_debug", "(Lcom/sunanda/attendance_kotlin/activity/NetworkChangeReceiver;)V", "sessionManager", "Lcom/sunanda/attendance_kotlin/helper/SessionManager;", "getSessionManager$app_debug", "()Lcom/sunanda/attendance_kotlin/helper/SessionManager;", "setSessionManager$app_debug", "(Lcom/sunanda/attendance_kotlin/helper/SessionManager;)V", "taskPojoArrayListDB", "Ljava/util/ArrayList;", "Lcom/sunanda/attendance_kotlin/model/NewTaskPojo;", "Lkotlin/collections/ArrayList;", "getTaskPojoArrayListDB", "()Ljava/util/ArrayList;", "setTaskPojoArrayListDB", "(Ljava/util/ArrayList;)V", "taskPojoRoomDB", "Lcom/sunanda/attendance_kotlin/room/TaskPojoUsingRoom;", "getTaskPojoRoomDB", "setTaskPojoRoomDB", "totel_count", "", "getTotel_count", "()I", "setTotel_count", "(I)V", "ErrorDialog", "", "error", "", "SendData", "pos", "SendRoomData", "ShowDialog", "msg", "checkPlayServices", "createLocationRequest", "deleteAllImage", "deleteCache", "context", "Landroid/content/Context;", "deleteDir", "dir", "Ljava/io/File;", "deleteTask", "task", "getAlbumName", "getFileDataFromDrawable", "", "bitmap", "Landroid/graphics/Bitmap;", "getPermission", "getTasks", "initValue", "onBackPressed", "onConnected", "bundle", "Landroid/os/Bundle;", "onConnectionFailed", "connectionResult", "Lcom/google/android/gms/common/ConnectionResult;", "onConnectionSuspended", "i", "onCreate", "savedInstanceState", "onLocationChanged", "location", "onResume", "requestAllPermission", "sendImageData", "finename", "startLocationUpdates", "turnGPSOn1", "activity", "Landroid/app/Activity;", "googleApiClient", "updateLocationUI", "uploadFileSource", "str", "str2", "Companion", "GeocoderHandler", "app_debug"})
public final class WelcomeActivity extends android.support.v7.app.AppCompatActivity implements com.google.android.gms.location.LocationListener, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener {
    @org.jetbrains.annotations.NotNull()
    public android.widget.Button attendance;
    @org.jetbrains.annotations.NotNull()
    public android.widget.Button leave;
    @org.jetbrains.annotations.NotNull()
    public android.widget.TextView name;
    @org.jetbrains.annotations.NotNull()
    public android.widget.TextView email;
    @org.jetbrains.annotations.NotNull()
    public com.sunanda.attendance_kotlin.helper.SessionManager sessionManager;
    @org.jetbrains.annotations.NotNull()
    public com.sunanda.attendance_kotlin.helper.LoadingDialog loadingDialog;
    @org.jetbrains.annotations.NotNull()
    public java.util.ArrayList<com.sunanda.attendance_kotlin.model.NewTaskPojo> taskPojoArrayListDB;
    @org.jetbrains.annotations.NotNull()
    public com.sunanda.attendance_kotlin.database.DatabaseHandler databaseHandler;
    @org.jetbrains.annotations.NotNull()
    public com.google.android.gms.common.api.GoogleApiClient mGoogleApiClient;
    private com.google.android.gms.location.FusedLocationProviderClient mFusedLocationClient;
    private com.google.android.gms.location.SettingsClient mSettingsClient;
    private com.google.android.gms.location.LocationSettingsRequest mLocationSettingsRequest;
    private com.google.android.gms.location.LocationCallback mLocationCallback;
    private com.google.android.gms.location.LocationRequest mLocationRequest;
    private android.location.Location mCurrentLocation;
    @org.jetbrains.annotations.NotNull()
    public com.sunanda.attendance_kotlin.activity.NetworkChangeReceiver networkChangeReceiver;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Boolean network;
    @org.jetbrains.annotations.NotNull()
    public java.util.ArrayList<com.sunanda.attendance_kotlin.room.TaskPojoUsingRoom> taskPojoRoomDB;
    private int totel_count;
    private static final long UPDATE_INTERVAL_IN_MILLISECONDS = 10000L;
    private static final long FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS = 5000L;
    private static final int REQUEST_CHECK_SETTINGS = 100;
    private static final int REQUEST_LOCATION_LIB = 1001;
    private static final java.lang.String[] INITIAL_PERMS = null;
    private static final int INITIAL_REQUEST = 1514;
    public static final com.sunanda.attendance_kotlin.activity.WelcomeActivity.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.Button getAttendance$app_debug() {
        return null;
    }
    
    public final void setAttendance$app_debug(@org.jetbrains.annotations.NotNull()
    android.widget.Button p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.Button getLeave$app_debug() {
        return null;
    }
    
    public final void setLeave$app_debug(@org.jetbrains.annotations.NotNull()
    android.widget.Button p0) {
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
    public final com.sunanda.attendance_kotlin.helper.SessionManager getSessionManager$app_debug() {
        return null;
    }
    
    public final void setSessionManager$app_debug(@org.jetbrains.annotations.NotNull()
    com.sunanda.attendance_kotlin.helper.SessionManager p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.sunanda.attendance_kotlin.helper.LoadingDialog getLoadingDialog() {
        return null;
    }
    
    public final void setLoadingDialog(@org.jetbrains.annotations.NotNull()
    com.sunanda.attendance_kotlin.helper.LoadingDialog p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.sunanda.attendance_kotlin.model.NewTaskPojo> getTaskPojoArrayListDB() {
        return null;
    }
    
    public final void setTaskPojoArrayListDB(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.sunanda.attendance_kotlin.model.NewTaskPojo> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.sunanda.attendance_kotlin.database.DatabaseHandler getDatabaseHandler() {
        return null;
    }
    
    public final void setDatabaseHandler(@org.jetbrains.annotations.NotNull()
    com.sunanda.attendance_kotlin.database.DatabaseHandler p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.android.gms.common.api.GoogleApiClient getMGoogleApiClient() {
        return null;
    }
    
    public final void setMGoogleApiClient(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.common.api.GoogleApiClient p0) {
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
    public final java.util.ArrayList<com.sunanda.attendance_kotlin.room.TaskPojoUsingRoom> getTaskPojoRoomDB() {
        return null;
    }
    
    public final void setTaskPojoRoomDB(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.sunanda.attendance_kotlin.room.TaskPojoUsingRoom> p0) {
    }
    
    public final int getTotel_count() {
        return 0;
    }
    
    public final void setTotel_count(int p0) {
    }
    
    private final void requestAllPermission() {
    }
    
    private final void getPermission() {
    }
    
    private final void initValue() {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void getTasks() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    private final void uploadFileSource(java.lang.String str, java.lang.String str2, int pos) {
    }
    
    private final void sendImageData(java.lang.String finename, int pos) {
    }
    
    private final void SendData(int pos) {
    }
    
    private final void SendRoomData(int pos) {
    }
    
    private final void deleteTask(com.sunanda.attendance_kotlin.room.TaskPojoUsingRoom task) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final byte[] getFileDataFromDrawable(@org.jetbrains.annotations.Nullable()
    android.graphics.Bitmap bitmap) {
        return null;
    }
    
    private final void deleteAllImage() {
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
    
    private final void ShowDialog(java.lang.String msg) {
    }
    
    private final void ErrorDialog(java.lang.String error) {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    @java.lang.Override()
    public void onLocationChanged(@org.jetbrains.annotations.Nullable()
    android.location.Location location) {
    }
    
    @java.lang.Override()
    public void onConnected(@org.jetbrains.annotations.Nullable()
    android.os.Bundle bundle) {
    }
    
    @java.lang.Override()
    public void onConnectionSuspended(int i) {
    }
    
    @java.lang.Override()
    public void onConnectionFailed(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.common.ConnectionResult connectionResult) {
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    private final void startLocationUpdates() {
    }
    
    private final void updateLocationUI() {
    }
    
    public final void turnGPSOn1(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    com.google.android.gms.common.api.GoogleApiClient googleApiClient) {
    }
    
    private final boolean checkPlayServices() {
        return false;
    }
    
    @android.annotation.SuppressLint(value = {"RestrictedApi"})
    protected final void createLocationRequest() {
    }
    
    public WelcomeActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/sunanda/attendance_kotlin/activity/WelcomeActivity$GeocoderHandler;", "Landroid/os/Handler;", "(Lcom/sunanda/attendance_kotlin/activity/WelcomeActivity;)V", "handleMessage", "", "message", "Landroid/os/Message;", "app_debug"})
    final class GeocoderHandler extends android.os.Handler {
        
        @java.lang.Override()
        public void handleMessage(@org.jetbrains.annotations.NotNull()
        android.os.Message message) {
        }
        
        public GeocoderHandler() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/sunanda/attendance_kotlin/activity/WelcomeActivity$Companion;", "", "()V", "FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS", "", "INITIAL_PERMS", "", "", "[Ljava/lang/String;", "INITIAL_REQUEST", "", "REQUEST_CHECK_SETTINGS", "REQUEST_LOCATION_LIB", "UPDATE_INTERVAL_IN_MILLISECONDS", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}