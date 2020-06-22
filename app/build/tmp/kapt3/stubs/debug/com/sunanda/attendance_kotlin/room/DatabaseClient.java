package com.sunanda.attendance_kotlin.room;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"Lcom/sunanda/attendance_kotlin/room/DatabaseClient;", "", "mCtx", "Landroid/content/Context;", "(Landroid/content/Context;)V", "appDatabase", "Lcom/sunanda/attendance_kotlin/room/AppDatabase;", "getAppDatabase", "()Lcom/sunanda/attendance_kotlin/room/AppDatabase;", "Companion", "app_debug"})
public final class DatabaseClient {
    @org.jetbrains.annotations.NotNull()
    private final com.sunanda.attendance_kotlin.room.AppDatabase appDatabase = null;
    @org.jetbrains.annotations.NotNull()
    @android.annotation.SuppressLint(value = {"StaticFieldLeak"})
    public static com.sunanda.attendance_kotlin.room.DatabaseClient mInstance;
    public static final com.sunanda.attendance_kotlin.room.DatabaseClient.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.sunanda.attendance_kotlin.room.AppDatabase getAppDatabase() {
        return null;
    }
    
    private DatabaseClient(android.content.Context mCtx) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bR\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/sunanda/attendance_kotlin/room/DatabaseClient$Companion;", "", "()V", "mInstance", "Lcom/sunanda/attendance_kotlin/room/DatabaseClient;", "getMInstance", "()Lcom/sunanda/attendance_kotlin/room/DatabaseClient;", "setMInstance", "(Lcom/sunanda/attendance_kotlin/room/DatabaseClient;)V", "getInstance", "mCtx", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.sunanda.attendance_kotlin.room.DatabaseClient getMInstance() {
            return null;
        }
        
        public final void setMInstance(@org.jetbrains.annotations.NotNull()
        com.sunanda.attendance_kotlin.room.DatabaseClient p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final synchronized com.sunanda.attendance_kotlin.room.DatabaseClient getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context mCtx) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}