package com.sunanda.attendance_kotlin.room

import android.arch.persistence.room.*


@Dao // Data Access Object
interface TaskDao {

    @get:Query("SELECT * FROM taskpojousingroom")
    val all: List<TaskPojoUsingRoom>

    @get:Query("SELECT count(*) FROM taskpojousingroom")
    val countData: Int

    @Insert
    fun insert(task: TaskPojoUsingRoom)

    @Delete
    fun delete(task: TaskPojoUsingRoom)

    @Update
    fun update(task: TaskPojoUsingRoom)
}
