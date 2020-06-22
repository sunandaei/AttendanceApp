package com.sunanda.attendance_kotlin.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020\u00042\u0006\u0010Y\u001a\u00020\u0004H\u0002J\u0010\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020\u0004H\u0002J\u0010\u0010]\u001a\u00020[2\u0006\u0010^\u001a\u00020\u0004H\u0002J\b\u0010_\u001a\u00020[H\u0016J\u0012\u0010`\u001a\u00020[2\b\u0010a\u001a\u0004\u0018\u00010bH\u0014J\u0010\u0010c\u001a\u00020,2\u0006\u0010d\u001a\u00020eH\u0016J\b\u0010f\u001a\u00020[H\u0014J\b\u0010g\u001a\u00020[H\u0002J\b\u0010h\u001a\u00020[H\u0003J\b\u0010i\u001a\u00020[H\u0002J\b\u0010j\u001a\u00020[H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\u0016X\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010!\u001a\n #*\u0004\u0018\u00010\"0\"X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'R\"\u0010(\u001a\n #*\u0004\u0018\u00010\"0\"X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010%\"\u0004\b*\u0010\'R\u001e\u0010+\u001a\u0004\u0018\u00010,X\u0080\u000e\u00a2\u0006\u0010\n\u0002\u00101\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00102\u001a\u000203X\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001c\u00108\u001a\u0004\u0018\u000109X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001a\u0010>\u001a\u00020?X\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001a\u0010D\u001a\u00020EX\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001a\u0010J\u001a\u00020\u0016X\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u0018\"\u0004\bL\u0010\u001aR\u001a\u0010M\u001a\u00020NX\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u001a\u0010S\u001a\u00020\u0004X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\u0006\"\u0004\bU\u0010\b\u00a8\u0006k"}, d2 = {"Lcom/sunanda/attendance_kotlin/activity/LeaveApply;", "Landroid/support/v7/app/AppCompatActivity;", "()V", "Edate", "", "getEdate$app_debug", "()Ljava/lang/String;", "setEdate$app_debug", "(Ljava/lang/String;)V", "Sdate", "getSdate$app_debug", "setSdate$app_debug", "date", "Landroid/app/DatePickerDialog$OnDateSetListener;", "getDate$app_debug", "()Landroid/app/DatePickerDialog$OnDateSetListener;", "setDate$app_debug", "(Landroid/app/DatePickerDialog$OnDateSetListener;)V", "date2", "getDate2$app_debug", "setDate2$app_debug", "end_date", "Landroid/widget/TextView;", "getEnd_date$app_debug", "()Landroid/widget/TextView;", "setEnd_date$app_debug", "(Landroid/widget/TextView;)V", "loadingDialog", "Lcom/sunanda/attendance_kotlin/helper/LoadingDialog;", "getLoadingDialog$app_debug", "()Lcom/sunanda/attendance_kotlin/helper/LoadingDialog;", "setLoadingDialog$app_debug", "(Lcom/sunanda/attendance_kotlin/helper/LoadingDialog;)V", "myCalendar", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "getMyCalendar$app_debug", "()Ljava/util/Calendar;", "setMyCalendar$app_debug", "(Ljava/util/Calendar;)V", "myCalendar2", "getMyCalendar2$app_debug", "setMyCalendar2$app_debug", "network", "", "getNetwork$app_debug", "()Ljava/lang/Boolean;", "setNetwork$app_debug", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "networkChangeReceiver", "Lcom/sunanda/attendance_kotlin/activity/NetworkChangeReceiver;", "getNetworkChangeReceiver$app_debug", "()Lcom/sunanda/attendance_kotlin/activity/NetworkChangeReceiver;", "setNetworkChangeReceiver$app_debug", "(Lcom/sunanda/attendance_kotlin/activity/NetworkChangeReceiver;)V", "radioButton", "Landroid/widget/RadioButton;", "getRadioButton$app_debug", "()Landroid/widget/RadioButton;", "setRadioButton$app_debug", "(Landroid/widget/RadioButton;)V", "radioGroup", "Landroid/widget/RadioGroup;", "getRadioGroup$app_debug", "()Landroid/widget/RadioGroup;", "setRadioGroup$app_debug", "(Landroid/widget/RadioGroup;)V", "sessionManager", "Lcom/sunanda/attendance_kotlin/helper/SessionManager;", "getSessionManager$app_debug", "()Lcom/sunanda/attendance_kotlin/helper/SessionManager;", "setSessionManager$app_debug", "(Lcom/sunanda/attendance_kotlin/helper/SessionManager;)V", "start_date", "getStart_date$app_debug", "setStart_date$app_debug", "task", "Landroid/widget/EditText;", "getTask$app_debug", "()Landroid/widget/EditText;", "setTask$app_debug", "(Landroid/widget/EditText;)V", "value", "getValue$app_debug", "setValue$app_debug", "DayDifference", "", "dateBeforeString", "dateAfterString", "ErrorDialog", "", "error", "ShowDialog", "msg", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onResume", "sendLeaveInfo", "showDialog2", "updateLabe2", "updateLabel", "app_debug"})
public final class LeaveApply extends android.support.v7.app.AppCompatActivity {
    @org.jetbrains.annotations.Nullable()
    private android.widget.RadioButton radioButton;
    @org.jetbrains.annotations.NotNull()
    public android.widget.RadioGroup radioGroup;
    @org.jetbrains.annotations.NotNull()
    public com.sunanda.attendance_kotlin.helper.SessionManager sessionManager;
    @org.jetbrains.annotations.NotNull()
    public com.sunanda.attendance_kotlin.helper.LoadingDialog loadingDialog;
    @org.jetbrains.annotations.NotNull()
    public com.sunanda.attendance_kotlin.activity.NetworkChangeReceiver networkChangeReceiver;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Boolean network;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String value;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String Sdate;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String Edate;
    @org.jetbrains.annotations.NotNull()
    public android.widget.TextView start_date;
    @org.jetbrains.annotations.NotNull()
    public android.widget.TextView end_date;
    @org.jetbrains.annotations.NotNull()
    public android.widget.EditText task;
    private java.util.Calendar myCalendar;
    @org.jetbrains.annotations.NotNull()
    private android.app.DatePickerDialog.OnDateSetListener date;
    private java.util.Calendar myCalendar2;
    @org.jetbrains.annotations.NotNull()
    private android.app.DatePickerDialog.OnDateSetListener date2;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.RadioButton getRadioButton$app_debug() {
        return null;
    }
    
    public final void setRadioButton$app_debug(@org.jetbrains.annotations.Nullable()
    android.widget.RadioButton p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.RadioGroup getRadioGroup$app_debug() {
        return null;
    }
    
    public final void setRadioGroup$app_debug(@org.jetbrains.annotations.NotNull()
    android.widget.RadioGroup p0) {
    }
    
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
    public final java.lang.String getValue$app_debug() {
        return null;
    }
    
    public final void setValue$app_debug(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSdate$app_debug() {
        return null;
    }
    
    public final void setSdate$app_debug(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEdate$app_debug() {
        return null;
    }
    
    public final void setEdate$app_debug(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getStart_date$app_debug() {
        return null;
    }
    
    public final void setStart_date$app_debug(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getEnd_date$app_debug() {
        return null;
    }
    
    public final void setEnd_date$app_debug(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.EditText getTask$app_debug() {
        return null;
    }
    
    public final void setTask$app_debug(@org.jetbrains.annotations.NotNull()
    android.widget.EditText p0) {
    }
    
    public final java.util.Calendar getMyCalendar$app_debug() {
        return null;
    }
    
    public final void setMyCalendar$app_debug(java.util.Calendar p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.DatePickerDialog.OnDateSetListener getDate$app_debug() {
        return null;
    }
    
    public final void setDate$app_debug(@org.jetbrains.annotations.NotNull()
    android.app.DatePickerDialog.OnDateSetListener p0) {
    }
    
    public final java.util.Calendar getMyCalendar2$app_debug() {
        return null;
    }
    
    public final void setMyCalendar2$app_debug(java.util.Calendar p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.DatePickerDialog.OnDateSetListener getDate2$app_debug() {
        return null;
    }
    
    public final void setDate2$app_debug(@org.jetbrains.annotations.NotNull()
    android.app.DatePickerDialog.OnDateSetListener p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    private final void updateLabel() {
    }
    
    private final void updateLabe2() {
    }
    
    private final void ErrorDialog(java.lang.String error) {
    }
    
    private final void ShowDialog(java.lang.String msg) {
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    private final void showDialog2() {
    }
    
    private final int DayDifference(java.lang.String dateBeforeString, java.lang.String dateAfterString) {
        return 0;
    }
    
    private final void sendLeaveInfo() {
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    public LeaveApply() {
        super();
    }
}