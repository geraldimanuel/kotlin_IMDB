package com.example.kotlin_imdb
data class MainModel (
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int) {
    data class Movie(
        val adult: Boolean,
        val backdrop_path: String,
        val genreIds: List<Int>,
        val id: Int,
        val originalLanguage: String,
        val originalTitle: String,
        val overview: String,
        val popularity: Double,
        val poster_path: String,
        val release_date: String,
        val title: String,
        val video: Boolean,
        val vote_average: Double,
        val voteCount: Int
    )
}
