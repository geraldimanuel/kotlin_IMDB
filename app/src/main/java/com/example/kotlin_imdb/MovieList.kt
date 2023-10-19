package com.example.kotlin_imdb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MovieList.newInstance] factory method to
 * create an instance of this fragment.
 */
class MovieList : Fragment() {

    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
    }

    private val MovieApiService by lazy{
        retrofit.create(com.example.kotlin_imdb.api.MovieApiService::class.java)
    }

   private val apiResponseView by lazy{
        view?.findViewById<TextView>(R.id.api_response)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getMovieResponse()
    }

    private fun getMovieResponse(){

        val call = MovieApiService.getPopularMovies("05c628b1143996bd5dbea98f4ab4e7a3")

        call.enqueue(object: retrofit2.Callback<String>{
            override fun onResponse(call: retrofit2.Call<String>, response: retrofit2.Response<String>) {
                apiResponseView?.text = response.body()
            }

            override fun onFailure(call: retrofit2.Call<String>, t: Throwable) {
                apiResponseView?.text = t.message
            }

        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

}