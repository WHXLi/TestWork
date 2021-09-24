package com.example.testwork.di.component

import com.example.testwork.di.module.ModuleApp
import com.example.testwork.di.module.ModuleCicerone
import com.example.testwork.mvp.presenter.ActivityMainPresenter
import com.example.testwork.ui.activity.ActivityMain
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        ModuleApp::class,
        ModuleCicerone::class
    ]
)
interface ComponentApp {
    fun inject(activityMain: ActivityMain)
    fun inject(activityMainPresenter: ActivityMainPresenter)
}