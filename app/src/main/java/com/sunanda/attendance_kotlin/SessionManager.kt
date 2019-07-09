package com.sunanda.attendance_kotlin

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor

class SessionManager @SuppressLint("CommitPrefEdits")
constructor(internal var _context: Context) {

    // Shared Preferences
    internal var pref: SharedPreferences

    internal var editor: Editor

    // Shared pref mode
    internal var PRIVATE_MODE = 0

    val isLoggedIn: Boolean
        get() = pref.getBoolean(KEY_IS_LOGGED_IN, false)

    val isFirstTIme: Boolean
        get() = pref.getBoolean(KEY_IS_FIRST, false)

    val isExit: Boolean
        get() = pref.getBoolean(KEY_IS_EXIT, false)

    val name: String?
        get() = pref.getString(KEY_NAME, "name")

    val email: String?
        get() = pref.getString(KEY_EMAIL, "email")

    val keyId: String?
        get() = pref.getString(KEY_ID, "id")

    val prefsDate: String?
        get() = pref.getString(PREFS_DATE, "")


    init {
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        editor = pref.edit()
    }

    fun setLogin(isLoggedIn: Boolean, id: String, name: String, email: String, type: String, date: String) {

        editor.putBoolean(KEY_IS_LOGGED_IN, isLoggedIn)
        editor.putString(KEY_ID, id)
        editor.putString(KEY_NAME, name)
        editor.putString(KEY_EMAIL, email)
        editor.putString(UTYPE, type)
        editor.putString(PREFS_DATE, date)
        editor.commit()
    }

    fun SetDate(date: String) {
        editor.putString(PREFS_DATE, date)
        editor.commit()
    }

    fun setIsExit(isExit : Boolean){
        editor.putBoolean(KEY_IS_EXIT, isExit)
        editor.commit()
    }

    fun setIsFirst(isExit: Boolean) {
        editor.putBoolean(KEY_IS_FIRST, isExit)
        editor.commit()
    }

    fun destroyLoginSession() {
        editor.putBoolean(KEY_IS_LOGGED_IN, false)
        editor.clear()
        // commit changes
        editor.commit()
    }

    companion object {
        // LogCat tag
        private val TAG = SessionManager::class.java.simpleName

        // Shared preferences file name
        private val PREF_NAME = "Instrument"

        private val KEY_IS_LOGGED_IN = "isLoggedIn"
        private val KEY_ID = "id"
        private val KEY_NAME = "name"
        private val KEY_EMAIL = "email"
        private val UTYPE = "type"
        //KEY_IS_FIRST
        private val KEY_IS_EXIT = "is_exit"
        private val KEY_IS_FIRST = "is_first"
        private val PREFS_DATE = "0000-00-00"
    }
}