package com.example.testwork.mvp.presenter

import com.example.testwork.BuildConfig
import com.example.testwork.framework.entity.Film
import com.example.testwork.framework.repository.MovieReviewsApi
import com.example.testwork.mvp.presenter.rv.IPresenterListFilms
import com.example.testwork.mvp.view.ViewFragmentFilms
import com.example.testwork.mvp.view.rv.IViewItemFilms
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class PresenterFragmentFilms : PresenterBaseMvp<ViewFragmentFilms>() {
    class PresenterListFilms : IPresenterListFilms {
        val films = mutableListOf<Film>()
        override var itemClickListener: ((IViewItemFilms) -> Unit)? = null

        override fun bindView(view: IViewItemFilms) {
            val film = films[view.pos]
            view.setFilm(film)
        }

        override fun getCount(): Int = films.size
    }

    @Inject
    lateinit var api: MovieReviewsApi

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var uiScheduler: Scheduler

    val presenterListFilms = PresenterListFilms()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.initRv()
        viewState.showMovies()
        presenterListFilms.itemClickListener = {
            //Обработка нажатия
        }
    }

    fun loadMovies() {
        api.getAllMovies(BuildConfig.API_KEY)
            .observeOn(uiScheduler)
            .subscribeOn(Schedulers.io())
            .subscribe({ call ->
                presenterListFilms.films.addAll(call.results)
                viewState.updateRv()
            }, {
                it.printStackTrace()
            }).disposeOnDestroy()
    }

    fun backClick(): Boolean {
        router.exit()
        return true
    }
}