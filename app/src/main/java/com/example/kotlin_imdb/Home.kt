package com.example.kotlin_imdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.kotlin_imdb.api.MovieApiService
import com.google.android.material.tabs.TabLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Home : AppCompatActivity() {

    private val TAG: String = "Home"
    private lateinit var textGreeting: TextView

    lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // greetings handler
        textGreeting = findViewById(R.id.greeting)
        val name = intent.getStringExtra("name")
        textGreeting.text = getString(R.string.greeting_string, name)

        // fragments handler
        val viewPager: ViewPager = findViewById<ViewPager>(R.id.viewPager)
        val tabLayout: TabLayout = findViewById<TabLayout>(R.id.tabLayout)

        val fragmentAdapter = FragmentAdapter(supportFragmentManager)
        fragmentAdapter.addFragment(MovieList(), "Home")
        fragmentAdapter.addFragment(ProfileFragment(), "Profile")

        viewPager.adapter = fragmentAdapter
        tabLayout.setupWithViewPager(viewPager)

    }

//    override fun onStart() {
//        super.onStart()
//        setupRecyclerView()
//        getDataFromApi()
//    }
//    private fun setupRecyclerView(){
//        movieAdapter = MovieAdapter(arrayListOf())
//        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
//        recyclerView.apply {
//            layoutManager = LinearLayoutManager(context)
//            adapter = movieAdapter
//        }
//
//    }
//    private fun getDataFromApi(){
//        MovieApiService.endpoint.getPopularMovies("05c628b1143996bd5dbea98f4ab4e7a3")
//            .enqueue(object: Callback<MainModel>{
//                override fun onResponse(call: Call<MainModel>, response: Response<MainModel>) {
//                    if(response.isSuccessful){
//                        val result = response.body()
//                        showData(response.body()!!)
//                    }
//                }
//
//                override fun onFailure(call: Call<MainModel>, t: Throwable) {
//                    printLog(t.toString())
//                }
//
//            })
//    }

//    private fun printLog(message:String){
//        Log.d(TAG, message)
//    }
//
//    private fun showData(data:MainModel){
//        val results = data.results
//        movieAdapter.setData(results)
//    }
}