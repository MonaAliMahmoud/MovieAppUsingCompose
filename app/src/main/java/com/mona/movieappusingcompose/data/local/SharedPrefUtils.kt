package com.mona.movieappusingcompose.data.local

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class SharedPrefUtils @Inject constructor(context: Context) {

    private val pref: SharedPreferences =
        context.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE)


    private fun putString(key: String, value: String) {
        pref.edit().putString(key, value).apply()
    }

    private fun getString(key: String) = pref.getString(key, "")!!

    private fun putInt(key: String, value: Int) {
        pref.edit().putInt(key, value).apply()
    }

    private fun getInt(key: String) = pref.getInt(key, 0)

    private fun putBoolean(key: String, value: Boolean) {
        pref.edit().putBoolean(key, value).apply()
    }

    private fun getBoolean(key: String) = pref.getBoolean(key, false)

    fun getToken(): String {
        return getString(ACCESS_TOKEN)
    }

    fun saveToken(accessToken: String) {
        putString(ACCESS_TOKEN, accessToken)
    }

    companion object {
        const val PREF_FILE = "movie_app_using_compose"
        const val ACCESS_TOKEN = "accessToken"
    }
}