package com.example.kotlin_imdb

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.kotlin_imdb.api.MovieApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

lateinit var movieAdapter: MovieAdapter
class MovieList : Fragment() {

    private val TAG: String = "Fragment Movie List"


    override fun onStart() {
        super.onStart()
        setupRecyclerView()
        getDataFromApi()
    }

    private fun setupRecyclerView(){
        movieAdapter = MovieAdapter(arrayListOf(), object : MovieAdapter.OnAdapterListener {
            override fun onClick(movie: MainModel.Movie) {
                startActivity(
                    Intent(context,DetailActivity::class.java)
                        .putExtra("title", movie.title)
                        .putExtra("backdrop", movie.backdrop_path)
                        .putExtra("overview", movie.overview)
                        .putExtra("popularity", movie.popularity)
                        .putExtra("release_date", movie.release_date)
                        .putExtra("vote_average", movie.vote_average)
                )

            }

        })
        val recyclerView = view?.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView?.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = movieAdapter
        }

    }

    private fun getDataFromApi(){
        MovieApiService.endpoint.getPopularMovies("05c628b1143996bd5dbea98f4ab4e7a3")
            .enqueue(object: Callback<MainModel> {
                override fun onResponse(call: Call<MainModel>, response: Response<MainModel>) {
                    if(response.isSuccessful){
                        showData(response.body()!!)
                    }
                }

                override fun onFailure(call: Call<MainModel>, t: Throwable) {
                    printLog(t.toString())
                }

            })
    }

    private fun showData(data:MainModel){
        val results = data.results
        movieAdapter.setData(results)
    }

    private fun printLog(message:String){
        Log.d(TAG, message)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

}