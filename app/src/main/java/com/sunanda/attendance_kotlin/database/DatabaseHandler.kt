package com.sunanda.attendance_kotlin.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.sunanda.attendance_kotlin.model.NewTaskPojo
import java.util.*

class DatabaseHandler(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        try {

            val CREATE_TABLE_TABLE_ATTENDANCE = ("CREATE TABLE " + TABLE_ATTENDANCE + "("
                    + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + USERID + " TEXT, "
                    + ADDRESS + " TEXT, "
                    + TASK + " TEXT, "
                    + LAT + " TEXT, "
                    + LON + " TEXT, "
                    + TYPE + " TEXT, "
                    + DATEFROM + " TEXT, "
                    + DATETO + " TEXT, "
                    + IMAGE + " TEXT, "
                    + TIME + " TEXT" + ")")
            db.execSQL(CREATE_TABLE_TABLE_ATTENDANCE)

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        try {
            if (oldVersion < DATABASE_VERSION) {
                db.execSQL("DROP TABLE IF EXISTS $TABLE_ATTENDANCE")
                onCreate(db)
            }
        } catch (e: Exception) {
            Log.e(TAG, " onUpgrade:- ", e)
        }
    }

    fun deleteData(id: String) {
        val db = this.writableDatabase
        try {
            val strAQL = "DELETE from attendance where _id='$id'"
            db.execSQL(strAQL)
        } catch (e: Exception) {
            Log.e(TAG, " deleteTest:- ", e)
        }
    }

    fun insertData(
            user_id: String,
            address: String,
            task: String,
            lat: String,
            lon: String,
            type: String,
            date_from: String,
            date_to: String,
            imageName: String,
            time: String
    ): Boolean {

        var flag = false
        try {
            val db = this.writableDatabase
            val strSQL = ("insert into attendance " +
                    "(user_id, address, task, lat, lon, type, date_from, date_to, imageName, time)" +
                    "values('" + user_id + "','" + address + "','" + task + "','" + lat + "','" + lon + "','" + type
                    + "','" + date_from + "','" + date_to + "','" + imageName + "','" + time + "');")
            Log.d("TAG!", strSQL);
            db.execSQL(strSQL)
            db.close()
            flag = true
        } catch (e: Exception) {
            Log.e(TAG, "Add_DATA:- ", e)
        }
        return flag
    }


    fun getData(): ArrayList<NewTaskPojo> {
        val db = this.readableDatabase
        val arrayList = ArrayList<NewTaskPojo>()
        try {
            val rsql = "SELECT * FROM attendance ORDER BY _id DESC"
            val cursor = db.rawQuery(rsql, null)
            if (cursor.moveToFirst()) {
                do {
                    val data = NewTaskPojo()
                    val _id = cursor.getInt(cursor.getColumnIndex("_id"))
                    val user_id = cursor.getString(cursor.getColumnIndex("user_id"))
                    val address = cursor.getString(cursor.getColumnIndex("address"))
                    val task = cursor.getString(cursor.getColumnIndex("task"))
                    val lat = cursor.getString(cursor.getColumnIndex("lat"))
                    val lon = cursor.getString(cursor.getColumnIndex("lon"))
                    val type = cursor.getString(cursor.getColumnIndex("type"))
                    val date_from = cursor.getString(cursor.getColumnIndex("date_from"))
                    val date_to = cursor.getString(cursor.getColumnIndex("date_to"))
                    val imageName = cursor.getString(cursor.getColumnIndex("imageName"))
                    val time = cursor.getString(cursor.getColumnIndex("time"))

                    data._id = _id.toString()
                    data.user_id = user_id
                    data.address = address
                    data.task = task
                    data.lat = lat
                    data.lon = lon
                    data.type = type
                    data.date_from = date_from
                    data.date_to = date_to
                    data.imageName = imageName
                    data.time = time

                    arrayList.add(data)
                } while (cursor.moveToNext())
            }
            cursor.close()
            db.close()
        } catch (e: Exception) {
            db.close()
            Log.e(TAG, "DATA:- ", e)
        }
        return arrayList
    }

    companion object {

        private val TAG = "DatabaseHandler:"
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "ATTENDANCE.db"

        //ANNUAL Table
        private val TABLE_ATTENDANCE = "attendance"
        // columns
        private val _ID = "_id"
        private val USERID = "user_id"
        private val ADDRESS = "address"
        private val TASK = "task"
        private val LAT = "lat"
        private val LON = "lon"
        private val TYPE = "type"
        private val DATEFROM = "date_from"
        private val DATETO = "date_to"
        private val IMAGE = "imageName"
        private val TIME = "time"
    }
}