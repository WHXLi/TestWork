package com.example.testwork.ui.fragment

import com.example.testwork.R
import moxy.MvpAppCompatFragment

class FragmentFilms : MvpAppCompatFragment(R.layout.fragment_films) {
    companion object {
        fun instance() = FragmentFilms()
    }
}