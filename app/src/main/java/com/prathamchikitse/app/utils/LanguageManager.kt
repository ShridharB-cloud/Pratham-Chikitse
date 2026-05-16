package com.prathamchikitse.app.utils

import android.content.Context
import android.content.SharedPreferences

object LanguageManager {
    private const val PREFS_NAME = "PrathamPrefs"
    private const val KEY_IS_KANNADA = "is_kannada"

    fun isKannada(context: Context): Boolean {
        val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return prefs.getBoolean(KEY_IS_KANNADA, false) // Default English
    }

    fun setKannada(context: Context, isKannada: Boolean) {
        val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit().putBoolean(KEY_IS_KANNADA, isKannada).apply()
    }
}
