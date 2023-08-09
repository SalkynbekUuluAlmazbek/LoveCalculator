package com.geeks.lovecalculator.data.local

import android.content.Context
import android.content.Context.MODE_PRIVATE

class Pref(private val context: Context) {

    private val pref by lazy {
        context.getSharedPreferences(PREF_NAME, MODE_PRIVATE)
    }

    fun isOnBoardSeen(): Boolean {
        return pref.getBoolean(SEEN_KEY, false)
    }

    fun saveOnBoardSeen() {
        pref.edit().putBoolean(SEEN_KEY, true).apply()
    }

    companion object {
        const val PREF_NAME = "calc_name"
        const val SEEN_KEY = "onboard_seen"
    }
}