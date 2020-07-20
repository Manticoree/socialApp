package com.app.socialapp.prefmanager

import android.content.Context
import android.content.SharedPreferences

class PreferencesManager(context: Context) {
    private val mSharedPreferences: SharedPreferences
    private val mEditor: SharedPreferences.Editor

    companion object {
        private const val PREF_NAME = "Social_app"
    }

    init {
        mSharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        mEditor = mSharedPreferences.edit()
    }
}