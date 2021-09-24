package com.example.testwork.mvp.presenter

import com.example.testwork.mvp.navigation.IScreens
import com.example.testwork.mvp.view.ViewActivityMain
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import javax.inject.Inject

class PresenterActivityMain : MvpPresenter<ViewActivityMain>() {
    @Inject
    lateinit var router: Router
    @Inject
    lateinit var screens: IScreens

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showFragmentFilms()
    }

    fun displayFilmsFragment(){
        router.replaceScreen(screens.filmsScreen())
    }

    fun backClick(){
        router.exit()
    }
}