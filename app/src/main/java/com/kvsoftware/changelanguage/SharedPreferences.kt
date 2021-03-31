package com.kvsoftware.changelanguage

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

class SharedPreferences(context: Context) {

    companion object {
        private const val PREF_LANGUAGE = "pref_language"
    }

    private val preferences: SharedPreferences =
        PreferenceManager.getDefaultSharedPreferences(context.applicationContext)

    var language: String? = null
        get() {
            return preferences.getString(PREF_LANGUAGE, null)
        }
        set(value) {
            field = value
            preferences.edit().putString(PREF_LANGUAGE, value).apply()
        }

}