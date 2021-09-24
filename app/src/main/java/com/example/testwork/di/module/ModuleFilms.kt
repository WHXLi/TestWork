package com.example.testwork.di.module

import com.example.testwork.mvp.presenter.PresenterFragmentFilms
import dagger.Module
import dagger.Provides

@Module
class ModuleFilms {
    val presenter = PresenterFragmentFilms()
    @Provides
    fun presenter() = presenter

}