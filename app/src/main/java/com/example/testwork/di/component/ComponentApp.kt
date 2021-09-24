package com.example.testwork.di.component

import com.example.testwork.di.module.ModuleApi
import com.example.testwork.di.module.ModuleApp
import com.example.testwork.di.module.ModuleCicerone
import com.example.testwork.di.module.ModuleFilms
import com.example.testwork.mvp.presenter.PresenterActivityMain
import com.example.testwork.mvp.presenter.PresenterFragmentFilms
import com.example.testwork.ui.activity.ActivityMain
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        ModuleApp::class,
        ModuleCicerone::class,
        ModuleFilms::class,
        ModuleApi::class
    ]
)
interface ComponentApp {
    fun inject(activityMain: ActivityMain)
    fun inject(activityMainPresenter: PresenterActivityMain)
    fun inject(fragmentFilmsPresenter: PresenterFragmentFilms)
}