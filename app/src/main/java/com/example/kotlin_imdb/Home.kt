package com.example.kotlin_imdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout


class Home : AppCompatActivity() {

    private val TAG: String = "Home"
    private lateinit var textGreeting: TextView
    private lateinit var logoutTextView: TextView

    lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setSupportActionBar(findViewById(R.id.toolbar))

        // fragments handler
        val viewPager: ViewPager = findViewById<ViewPager>(R.id.viewPager)
        val tabLayout: TabLayout = findViewById<TabLayout>(R.id.tabLayout)

        val fragmentAdapter = FragmentAdapter(supportFragmentManager)
        fragmentAdapter.addFragment(MovieList(), "Home")
        fragmentAdapter.addFragment(ProfileFragment(), "Profile")

        viewPager.adapter = fragmentAdapter
        tabLayout.setupWithViewPager(viewPager)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)

        val name = intent.getStringExtra("name")

        val greetingMenuItem = menu.findItem(R.id.greeting_menu)
        greetingMenuItem.title = getString(R.string.greeting_string, name)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.logout_menu -> {
                logout()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun logout() {
        // finish home activity
        finish()
    }



}