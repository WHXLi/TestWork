package com.example.testwork.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface ViewActivityMain : MvpView {
    @AddToEndSingle
    fun showFragmentFilms()
}