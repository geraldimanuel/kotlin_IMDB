package com.example.kotlin_imdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import com.bumptech.glide.Glide
import org.w3c.dom.Text

class DetailActivity : AppCompatActivity() {

    private lateinit var backButton: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // calling the action bar
        var actionBar = getSupportActionBar()

        // showing the back button in action bar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val title = intent.getStringExtra("title")

        val backdrop = intent.getStringExtra("backdrop")
        val overview = intent.getStringExtra("overview")
        val popularity = intent.getDoubleExtra("popularity", 0.0)
        val release_date = intent.getStringExtra("release_date")
        val vote_average = intent.getDoubleExtra("vote_average", 0.0)

        val overview_text = findViewById<TextView>(R.id.detail_overview)
        val popularity_text = findViewById<TextView>(R.id.detail_popularity)
        val date_text = findViewById<TextView>(R.id.detail_date)
        val vote_text = findViewById<TextView>(R.id.detail_vote)
        val title_text = findViewById<TextView>(R.id.detail_title)

        overview_text.text = overview
        popularity_text.text = "Popularity: ${popularity.toString()}"
        date_text.text = release_date
        vote_text.text = "Vote average: ${vote_average.toString()}"
        title_text.text = title

        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500${backdrop}")
            .centerCrop()
            .into(findViewById(R.id.backdrop))

        backButton = findViewById(R.id.back_btn)
        backButton.setOnClickListener {
            finish()
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onContextItemSelected(item)
    }
}