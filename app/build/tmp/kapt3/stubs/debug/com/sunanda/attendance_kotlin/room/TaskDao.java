package com.sunanda.attendance_kotlin.room;

import java.lang.System;

@android.arch.persistence.room.Dao()
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\'J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\'J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\'R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038gX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8gX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/sunanda/attendance_kotlin/room/TaskDao;", "", "all", "", "Lcom/sunanda/attendance_kotlin/room/TaskPojoUsingRoom;", "getAll", "()Ljava/util/List;", "countData", "", "getCountData", "()I", "delete", "", "task", "insert", "update", "app_debug"})
public abstract interface TaskDao {
    
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.Query(value = "SELECT * FROM taskpojousingroom")
    public abstract java.util.List<com.sunanda.attendance_kotlin.room.TaskPojoUsingRoom> getAll();
    
    @android.arch.persistence.room.Query(value = "SELECT count(*) FROM taskpojousingroom")
    public abstract int getCountData();
    
    @android.arch.persistence.room.Insert()
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    com.sunanda.attendance_kotlin.room.TaskPojoUsingRoom task);
    
    @android.arch.persistence.room.Delete()
    public abstract void delete(@org.jetbrains.annotations.NotNull()
    com.sunanda.attendance_kotlin.room.TaskPojoUsingRoom task);
    
    @android.arch.persistence.room.Update()
    public abstract void update(@org.jetbrains.annotations.NotNull()
    com.sunanda.attendance_kotlin.room.TaskPojoUsingRoom task);
}