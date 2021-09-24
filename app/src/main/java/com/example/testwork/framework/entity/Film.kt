package com.example.testwork.framework.entity

import com.google.gson.annotations.Expose

data class Film(
    @Expose val displayTitle: String,
    @Expose val summary_short: String,
    @Expose val multimedia: FilmMedia
)
