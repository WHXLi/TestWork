package com.example.testwork.framework.repository

import com.example.testwork.framework.entity.Film
import com.google.gson.annotations.Expose

data class MoviesResponse(
    @Expose val results: List<Film>)
