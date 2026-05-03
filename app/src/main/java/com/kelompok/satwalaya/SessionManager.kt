package com.kelompok.satwalaya

import android.content.Context
import android.content.SharedPreferences

class SessionManager(context: Context) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    companion object {
        private const val PREF_NAME = "SatwalayaSession"
        private const val KEY_IS_LOGIN = "isLogin"
        private const val KEY_USERNAME = "username"
        private const val KEY_EMAIL    = "email"
        private const val KEY_PHONE    = "phone"
    }

    fun saveLoginSession(username: String, email: String, phone: String) {
        prefs.edit().apply {
            putBoolean(KEY_IS_LOGIN, true)
            putString(KEY_USERNAME, username)
            putString(KEY_EMAIL, email)
            putString(KEY_PHONE, phone)
            apply()
        }
    }

    fun isLoggedIn(): Boolean = prefs.getBoolean(KEY_IS_LOGIN, false)

    fun getUsername(): String = prefs.getString(KEY_USERNAME, "-") ?: "-"

    fun getEmail(): String = prefs.getString(KEY_EMAIL, "-") ?: "-"

    fun getPhone(): String = prefs.getString(KEY_PHONE, "-") ?: "-"

    fun clearSession() {
        prefs.edit().clear().apply()
    }
}