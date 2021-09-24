package com.example.testwork.di.module

import com.example.testwork.App
import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler

@Module
class ModuleApp(private val app: App) {
    @Provides
    fun app() = app

    @Provides
    fun uiScheduler(): Scheduler = AndroidSchedulers.mainThread()
}