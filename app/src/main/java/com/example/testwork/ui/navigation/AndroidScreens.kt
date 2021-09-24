package com.example.testwork.ui.navigation

import com.example.testwork.mvp.navigation.IScreens
import com.example.testwork.ui.fragment.FragmentFilms
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens : IScreens {
    override fun filmsScreen() = FragmentScreen { FragmentFilms.instance() }
}