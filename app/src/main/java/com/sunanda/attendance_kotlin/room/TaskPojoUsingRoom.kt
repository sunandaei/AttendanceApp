package com.sunanda.attendance_kotlin.room

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable

@Entity
class TaskPojoUsingRoom : Serializable {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    @ColumnInfo(name = "user_id")
    var user_id: String? = null

    @ColumnInfo(name = "address")
    var address: String? = null

    @ColumnInfo(name = "task")
    var tasks: String? = null

    @ColumnInfo(name = "lat")
    var lat: String? = null

    @ColumnInfo(name = "lon")
    var lon: String? = null

    @ColumnInfo(name = "type")
    var type: String? = null

    @ColumnInfo(name = "date_from")
    var date_from: String? = null

    @ColumnInfo(name = "date_to")
    var date_to: String? = null

    @ColumnInfo(name = "time")
    var time: String? = null
}