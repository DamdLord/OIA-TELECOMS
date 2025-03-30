package com.example.oiatelecoms.data

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

object DataStoreHelper {
    private val Context.dataStore by preferencesDataStore("app_prefs")

    private val FIRST_LAUNCH = booleanPreferencesKey("first_launch")

    suspend fun setFirstLaunch(context: Context, isFirstTime: Boolean) {
        context.dataStore.edit { prefs ->
            prefs[FIRST_LAUNCH] = isFirstTime
        }
    }

    suspend fun isFirstLaunch(context: Context): Boolean {
        val prefs = context.dataStore.data.first()
        return prefs[FIRST_LAUNCH] ?: true
    }
}