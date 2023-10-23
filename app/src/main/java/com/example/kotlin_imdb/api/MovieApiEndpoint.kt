package com.example.kotlin_imdb.api


import com.example.kotlin_imdb.MainModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiEndpoint {
    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key")
        apiKey: String
    ): Call<MainModel>
}