package com.example.oiatelecoms

import android.app.Application
import com.example.oiatelecoms.data.AppContainer
import com.example.oiatelecoms.data.DefaultAppContainer

class OIATELECOMSApplication:Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}