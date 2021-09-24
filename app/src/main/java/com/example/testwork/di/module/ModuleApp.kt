package com.example.testwork.di.module

import com.example.testwork.App
import dagger.Module
import dagger.Provides

@Module
class ModuleApp(private val app: App) {
    @Provides
    fun app() = app
}