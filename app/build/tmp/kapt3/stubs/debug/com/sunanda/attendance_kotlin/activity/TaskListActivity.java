package com.sunanda.attendance_kotlin.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020)H\u0002J\b\u0010+\u001a\u00020)H\u0016J\u0012\u0010,\u001a\u00020)2\b\u0010-\u001a\u0004\u0018\u00010.H\u0014J\u0010\u0010/\u001a\u00020\u00102\u0006\u00100\u001a\u000201H\u0016J\b\u00102\u001a\u00020)H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0080\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0016\u001a\u00020\u0017X\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'\u00a8\u00063"}, d2 = {"Lcom/sunanda/attendance_kotlin/activity/TaskListActivity;", "Landroid/support/v7/app/AppCompatActivity;", "()V", "databaseHandler", "Lcom/sunanda/attendance_kotlin/database/DatabaseHandler;", "getDatabaseHandler", "()Lcom/sunanda/attendance_kotlin/database/DatabaseHandler;", "setDatabaseHandler", "(Lcom/sunanda/attendance_kotlin/database/DatabaseHandler;)V", "loadingDialog", "Lcom/sunanda/attendance_kotlin/helper/LoadingDialog;", "getLoadingDialog$app_debug", "()Lcom/sunanda/attendance_kotlin/helper/LoadingDialog;", "setLoadingDialog$app_debug", "(Lcom/sunanda/attendance_kotlin/helper/LoadingDialog;)V", "network", "", "getNetwork$app_debug", "()Ljava/lang/Boolean;", "setNetwork$app_debug", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "networkChangeReceiver", "Lcom/sunanda/attendance_kotlin/activity/NetworkChangeReceiver;", "getNetworkChangeReceiver$app_debug", "()Lcom/sunanda/attendance_kotlin/activity/NetworkChangeReceiver;", "setNetworkChangeReceiver$app_debug", "(Lcom/sunanda/attendance_kotlin/activity/NetworkChangeReceiver;)V", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView$app_debug", "()Landroid/support/v7/widget/RecyclerView;", "setRecyclerView$app_debug", "(Landroid/support/v7/widget/RecyclerView;)V", "sessionManager", "Lcom/sunanda/attendance_kotlin/helper/SessionManager;", "getSessionManager$app_debug", "()Lcom/sunanda/attendance_kotlin/helper/SessionManager;", "setSessionManager$app_debug", "(Lcom/sunanda/attendance_kotlin/helper/SessionManager;)V", "getListFromDB", "", "getTasks", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onResume", "app_debug"})
public final class TaskListActivity extends android.support.v7.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    public com.sunanda.attendance_kotlin.helper.SessionManager sessionManager;
    @org.jetbrains.annotations.NotNull()
    public com.sunanda.attendance_kotlin.helper.LoadingDialog loadingDialog;
    @org.jetbrains.annotations.NotNull()
    public com.sunanda.attendance_kotlin.activity.NetworkChangeReceiver networkChangeReceiver;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Boolean network;
    @org.jetbrains.annotations.NotNull()
    public com.sunanda.attendance_kotlin.database.DatabaseHandler databaseHandler;
    @org.jetbrains.annotations.NotNull()
    public android.support.v7.widget.RecyclerView recyclerView;
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
    public final com.sunanda.attendance_kotlin.database.DatabaseHandler getDatabaseHandler() {
        return null;
    }
    
    public final void setDatabaseHandler(@org.jetbrains.annotations.NotNull()
    com.sunanda.attendance_kotlin.database.DatabaseHandler p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.support.v7.widget.RecyclerView getRecyclerView$app_debug() {
        return null;
    }
    
    public final void setRecyclerView$app_debug(@org.jetbrains.annotations.NotNull()
    android.support.v7.widget.RecyclerView p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    private final void getListFromDB() {
    }
    
    private final void getTasks() {
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    public TaskListActivity() {
        super();
    }
}