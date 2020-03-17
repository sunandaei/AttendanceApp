package com.sunanda.attendance_kotlin.helper;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 22\u00020\u0001:\u00012B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0015J\u0006\u0010,\u001a\u00020*J\u000e\u0010-\u001a\u00020*2\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010.\u001a\u00020*2\u0006\u0010\u0018\u001a\u00020\u0019J6\u0010/\u001a\u00020*2\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u00101\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\u0015R\u001a\u0010\u0005\u001a\u00020\u0006X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u0004R\u001a\u0010\u000e\u001a\u00020\u000fX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u00158F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00198F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u00198F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\u001c\u001a\u00020\u00198F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001aR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u00158F\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u0017R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u00158F\u00a2\u0006\u0006\u001a\u0004\b \u0010\u0017R\u001a\u0010!\u001a\u00020\"X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0013\u0010\'\u001a\u0004\u0018\u00010\u00158F\u00a2\u0006\u0006\u001a\u0004\b(\u0010\u0017\u00a8\u00063"}, d2 = {"Lcom/sunanda/attendance_kotlin/helper/SessionManager;", "", "_context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "PRIVATE_MODE", "", "getPRIVATE_MODE$app_debug", "()I", "setPRIVATE_MODE$app_debug", "(I)V", "get_context$app_debug", "()Landroid/content/Context;", "set_context$app_debug", "editor", "Landroid/content/SharedPreferences$Editor;", "getEditor$app_debug", "()Landroid/content/SharedPreferences$Editor;", "setEditor$app_debug", "(Landroid/content/SharedPreferences$Editor;)V", "email", "", "getEmail", "()Ljava/lang/String;", "isExit", "", "()Z", "isFirstTIme", "isLoggedIn", "keyId", "getKeyId", "name", "getName", "pref", "Landroid/content/SharedPreferences;", "getPref$app_debug", "()Landroid/content/SharedPreferences;", "setPref$app_debug", "(Landroid/content/SharedPreferences;)V", "prefsDate", "getPrefsDate", "SetDate", "", "date", "destroyLoginSession", "setIsExit", "setIsFirst", "setLogin", "id", "type", "Companion", "app_debug"})
public final class SessionManager {
    @org.jetbrains.annotations.NotNull()
    private android.content.SharedPreferences pref;
    @org.jetbrains.annotations.NotNull()
    private android.content.SharedPreferences.Editor editor;
    private int PRIVATE_MODE;
    @org.jetbrains.annotations.NotNull()
    private android.content.Context _context;
    private static final java.lang.String TAG = null;
    private static final java.lang.String PREF_NAME = "Instrument";
    private static final java.lang.String KEY_IS_LOGGED_IN = "isLoggedIn";
    private static final java.lang.String KEY_ID = "id";
    private static final java.lang.String KEY_NAME = "name";
    private static final java.lang.String KEY_EMAIL = "email";
    private static final java.lang.String UTYPE = "type";
    private static final java.lang.String KEY_IS_EXIT = "is_exit";
    private static final java.lang.String KEY_IS_FIRST = "is_first";
    private static final java.lang.String PREFS_DATE = "0000-00-00";
    public static final com.sunanda.attendance_kotlin.helper.SessionManager.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.SharedPreferences getPref$app_debug() {
        return null;
    }
    
    public final void setPref$app_debug(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.SharedPreferences.Editor getEditor$app_debug() {
        return null;
    }
    
    public final void setEditor$app_debug(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences.Editor p0) {
    }
    
    public final int getPRIVATE_MODE$app_debug() {
        return 0;
    }
    
    public final void setPRIVATE_MODE$app_debug(int p0) {
    }
    
    public final boolean isLoggedIn() {
        return false;
    }
    
    public final boolean isFirstTIme() {
        return false;
    }
    
    public final boolean isExit() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getEmail() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getKeyId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPrefsDate() {
        return null;
    }
    
    public final void setLogin(boolean isLoggedIn, @org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String type, @org.jetbrains.annotations.NotNull()
    java.lang.String date) {
    }
    
    public final void SetDate(@org.jetbrains.annotations.NotNull()
    java.lang.String date) {
    }
    
    public final void setIsExit(boolean isExit) {
    }
    
    public final void setIsFirst(boolean isExit) {
    }
    
    public final void destroyLoginSession() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context get_context$app_debug() {
        return null;
    }
    
    public final void set_context$app_debug(@org.jetbrains.annotations.NotNull()
    android.content.Context p0) {
    }
    
    @android.annotation.SuppressLint(value = {"CommitPrefEdits"})
    public SessionManager(@org.jetbrains.annotations.NotNull()
    android.content.Context _context) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \r*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/sunanda/attendance_kotlin/helper/SessionManager$Companion;", "", "()V", "KEY_EMAIL", "", "KEY_ID", "KEY_IS_EXIT", "KEY_IS_FIRST", "KEY_IS_LOGGED_IN", "KEY_NAME", "PREFS_DATE", "PREF_NAME", "TAG", "kotlin.jvm.PlatformType", "UTYPE", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}