package com.example.kotlin_imdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class Home : AppCompatActivity() {

    private lateinit var textGreeting: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        textGreeting = findViewById(R.id.greeting)

        val name = intent.getStringExtra("name")

        textGreeting.text = getString(R.string.greeting_string, name)
    }
}