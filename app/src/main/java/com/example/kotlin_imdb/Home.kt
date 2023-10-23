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
    private lateinit var logoutTextView: TextView

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

        // pass name to profile fragment
        val bundle = Bundle()
        bundle.putString("name", name)
        val profileFragment = ProfileFragment()
        profileFragment.arguments = bundle

        logoutTextView = findViewById(R.id.logout)

        logoutTextView.setOnClickListener() {
            logout()
        }
    }

    private fun logout() {
        finish()
    }



}