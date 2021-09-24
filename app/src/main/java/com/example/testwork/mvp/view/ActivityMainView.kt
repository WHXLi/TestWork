package com.example.testwork.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface ActivityMainView : MvpView {
    @AddToEndSingle
    fun showFragmentFilms()
}