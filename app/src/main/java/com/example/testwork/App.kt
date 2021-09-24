package com.example.testwork

import android.app.Application
import com.example.testwork.di.component.ComponentApp
import com.example.testwork.di.component.DaggerComponentApp
import com.example.testwork.di.module.ModuleApp

class App : Application() {
    companion object {
        lateinit var instance: App
    }

    lateinit var appComponent: ComponentApp

    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = DaggerComponentApp.builder()
            .moduleApp(ModuleApp(this))
            .build()
    }


}