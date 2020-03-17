package com.sunanda.attendance_kotlin.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 52\u00020\u0001:\u00015B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020\"H\u0002J\b\u0010&\u001a\u00020\"H\u0002J\b\u0010\'\u001a\u00020\"H\u0016J\u0012\u0010(\u001a\u00020\"2\b\u0010)\u001a\u0004\u0018\u00010*H\u0014J\b\u0010+\u001a\u00020\"H\u0014J\u0018\u0010,\u001a\u00020\"2\u0006\u0010-\u001a\u00020$2\u0006\u0010.\u001a\u00020$H\u0002J\u0012\u0010/\u001a\u00020\"*\u0002002\u0006\u00101\u001a\u00020$J\u0012\u00102\u001a\u00020\"*\u0002032\u0006\u00104\u001a\u00020$R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0080\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u00020\u0013X\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0006X\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\b\"\u0004\b \u0010\n\u00a8\u00066"}, d2 = {"Lcom/sunanda/attendance_kotlin/activity/LoginActivity;", "Landroid/support/v7/app/AppCompatActivity;", "()V", "loadingDialog", "Lcom/sunanda/attendance_kotlin/helper/LoadingDialog;", "login_password", "Landroid/widget/EditText;", "getLogin_password$app_debug", "()Landroid/widget/EditText;", "setLogin_password$app_debug", "(Landroid/widget/EditText;)V", "network", "", "getNetwork$app_debug", "()Ljava/lang/Boolean;", "setNetwork$app_debug", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "networkChangeReceiver", "Lcom/sunanda/attendance_kotlin/activity/NetworkChangeReceiver;", "getNetworkChangeReceiver$app_debug", "()Lcom/sunanda/attendance_kotlin/activity/NetworkChangeReceiver;", "setNetworkChangeReceiver$app_debug", "(Lcom/sunanda/attendance_kotlin/activity/NetworkChangeReceiver;)V", "sessionManager", "Lcom/sunanda/attendance_kotlin/helper/SessionManager;", "getSessionManager$app_debug", "()Lcom/sunanda/attendance_kotlin/helper/SessionManager;", "setSessionManager$app_debug", "(Lcom/sunanda/attendance_kotlin/helper/SessionManager;)V", "uname", "getUname$app_debug", "setUname$app_debug", "ErrorDialog", "", "error", "", "ShowDialog", "ShowDialog2", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "userLogin", "email", "password", "loadUrl", "Landroid/widget/ImageView;", "url", "toast", "Landroid/content/Context;", "text", "Companion", "app_debug"})
public final class LoginActivity extends android.support.v7.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    public com.sunanda.attendance_kotlin.activity.NetworkChangeReceiver networkChangeReceiver;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Boolean network;
    @org.jetbrains.annotations.NotNull()
    public android.widget.EditText uname;
    @org.jetbrains.annotations.NotNull()
    public android.widget.EditText login_password;
    private com.sunanda.attendance_kotlin.helper.LoadingDialog loadingDialog;
    @org.jetbrains.annotations.NotNull()
    public com.sunanda.attendance_kotlin.helper.SessionManager sessionManager;
    public static final com.sunanda.attendance_kotlin.activity.LoginActivity.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
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
    public final android.widget.EditText getUname$app_debug() {
        return null;
    }
    
    public final void setUname$app_debug(@org.jetbrains.annotations.NotNull()
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.EditText getLogin_password$app_debug() {
        return null;
    }
    
    public final void setLogin_password$app_debug(@org.jetbrains.annotations.NotNull()
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.sunanda.attendance_kotlin.helper.SessionManager getSessionManager$app_debug() {
        return null;
    }
    
    public final void setSessionManager$app_debug(@org.jetbrains.annotations.NotNull()
    com.sunanda.attendance_kotlin.helper.SessionManager p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void toast(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$toast, @org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    public final void loadUrl(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView $this$loadUrl, @org.jetbrains.annotations.NotNull()
    java.lang.String url) {
    }
    
    private final void userLogin(java.lang.String email, java.lang.String password) {
    }
    
    private final void ErrorDialog(java.lang.String error) {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    private final void ShowDialog() {
    }
    
    private final void ShowDialog2() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    public LoginActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/sunanda/attendance_kotlin/activity/LoginActivity$Companion;", "", "()V", "isValidEmail", "", "target", "", "app_debug"})
    public static final class Companion {
        
        public final boolean isValidEmail(@org.jetbrains.annotations.NotNull()
        java.lang.CharSequence target) {
            return false;
        }
        
        private Companion() {
            super();
        }
    }
}