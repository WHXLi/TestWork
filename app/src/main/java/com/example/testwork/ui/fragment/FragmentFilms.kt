package com.example.testwork.ui.fragment

import android.annotation.SuppressLint
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.testwork.App
import com.example.testwork.BackBtnListener
import com.example.testwork.R
import com.example.testwork.databinding.FragmentFilmsBinding
import com.example.testwork.mvp.presenter.PresenterFragmentFilms
import com.example.testwork.mvp.view.ViewFragmentFilms
import com.example.testwork.ui.rv_adapter.AdapterFilms
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class FragmentFilms : MvpAppCompatFragment(R.layout.fragment_films), ViewFragmentFilms,
    BackBtnListener {
    private val binding: FragmentFilmsBinding by viewBinding()
    private var adapter: AdapterFilms? = null
    private val presenter by moxyPresenter {
        PresenterFragmentFilms().apply {
            App.instance.appComponent.inject(this)
        }
    }

    companion object {
        fun instance() = FragmentFilms()
    }

    override fun showMovies() {
        presenter.loadMovies()
    }

    override fun initRv() {
        binding.listFilms.layoutManager = LinearLayoutManager(context)
        adapter = AdapterFilms(presenter.presenterListFilms)
        binding.listFilms.adapter = adapter
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun updateRv() {
        adapter?.notifyDataSetChanged()
    }

    override fun backPressed(): Boolean = presenter.backClick()
}