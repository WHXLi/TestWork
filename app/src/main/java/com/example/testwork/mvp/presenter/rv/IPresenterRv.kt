package com.example.testwork.mvp.presenter.rv

interface IRvPresenter<V> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int

}