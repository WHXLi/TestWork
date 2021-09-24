package com.example.testwork.framework.repository

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieReviewsApi {
    @GET("reviews/all.json")
    fun getAllMovies(
        @Query("api-key") apiKey: String
    ): Single<MoviesResponse>
}