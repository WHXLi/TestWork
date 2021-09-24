package com.example.testwork.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface ViewFragmentFilms: MvpView {
    fun showMovies()
    fun initRv()
    fun updateRv()
}