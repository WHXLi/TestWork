package com.example.testwork.ui.activity

import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.testwork.App
import com.example.testwork.BackBtnListener
import com.example.testwork.R
import com.example.testwork.databinding.ActivityMainBinding
import com.example.testwork.mvp.presenter.PresenterActivityMain
import com.example.testwork.mvp.view.ViewActivityMain
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class ActivityMain : MvpAppCompatActivity(R.layout.activity_main), ViewActivityMain {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    private val binding: ActivityMainBinding by viewBinding()
    private val navigator = AppNavigator(this, R.id.container_fragment)
    private val presenter by moxyPresenter {
        PresenterActivityMain().apply {
            App.instance.appComponent.inject(this)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.instance.appComponent.inject(this)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if (it is BackBtnListener && it.backPressed()) return
        }
        presenter.backClick()
    }

    override fun showFragmentFilms() {
        presenter.displayFilmsFragment()
    }
}