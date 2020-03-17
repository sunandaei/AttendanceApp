package com.sunanda.attendance_kotlin.database;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0001\"B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJV\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bJ\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J \u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u001e\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010!\u001a\u00020\b\u00a8\u0006#"}, d2 = {"Lcom/sunanda/attendance_kotlin/database/DatabaseHandler;", "Landroid/database/sqlite/SQLiteOpenHelper;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "deleteData", "", "id", "", "getData", "Ljava/util/ArrayList;", "Lcom/sunanda/attendance_kotlin/model/NewTaskPojo;", "insertData", "", "user_id", "address", "task", "lat", "lon", "type", "date_from", "date_to", "imageName", "time", "onCreate", "db", "Landroid/database/sqlite/SQLiteDatabase;", "onUpgrade", "oldVersion", "", "newVersion", "updateRecord", "str", "uid", "Companion", "app_debug"})
public final class DatabaseHandler extends android.database.sqlite.SQLiteOpenHelper {
    private static final java.lang.String TAG = "DatabaseHandler:";
    private static final int DATABASE_VERSION = 1;
    private static final java.lang.String DATABASE_NAME = "ATTENDANCE.db";
    private static final java.lang.String TABLE_ATTENDANCE = "attendance";
    private static final java.lang.String _ID = "_id";
    private static final java.lang.String USERID = "user_id";
    private static final java.lang.String ADDRESS = "address";
    private static final java.lang.String TASK = "task";
    private static final java.lang.String LAT = "lat";
    private static final java.lang.String LON = "lon";
    private static final java.lang.String TYPE = "type";
    private static final java.lang.String DATEFROM = "date_from";
    private static final java.lang.String DATETO = "date_to";
    private static final java.lang.String IMAGE = "imageName";
    private static final java.lang.String TIME = "time";
    public static final com.sunanda.attendance_kotlin.database.DatabaseHandler.Companion Companion = null;
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.NotNull()
    android.database.sqlite.SQLiteDatabase db) {
    }
    
    @java.lang.Override()
    public void onUpgrade(@org.jetbrains.annotations.NotNull()
    android.database.sqlite.SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    
    public final void deleteData(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
    }
    
    public final boolean insertData(@org.jetbrains.annotations.NotNull()
    java.lang.String user_id, @org.jetbrains.annotations.NotNull()
    java.lang.String address, @org.jetbrains.annotations.NotNull()
    java.lang.String task, @org.jetbrains.annotations.NotNull()
    java.lang.String lat, @org.jetbrains.annotations.NotNull()
    java.lang.String lon, @org.jetbrains.annotations.NotNull()
    java.lang.String type, @org.jetbrains.annotations.NotNull()
    java.lang.String date_from, @org.jetbrains.annotations.NotNull()
    java.lang.String date_to, @org.jetbrains.annotations.NotNull()
    java.lang.String imageName, @org.jetbrains.annotations.NotNull()
    java.lang.String time) {
        return false;
    }
    
    public final void updateRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String str, @org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String uid) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.sunanda.attendance_kotlin.model.NewTaskPojo> getData() {
        return null;
    }
    
    public DatabaseHandler(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null, null, null, 0);
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/sunanda/attendance_kotlin/database/DatabaseHandler$Companion;", "", "()V", "ADDRESS", "", "DATABASE_NAME", "DATABASE_VERSION", "", "DATEFROM", "DATETO", "IMAGE", "LAT", "LON", "TABLE_ATTENDANCE", "TAG", "TASK", "TIME", "TYPE", "USERID", "_ID", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}