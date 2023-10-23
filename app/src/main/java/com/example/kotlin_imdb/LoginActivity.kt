package com.example.kotlin_imdb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {

    private lateinit var loginBtn: Button
    private lateinit var nameInput: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginBtn = findViewById(R.id.login_button)
        nameInput = findViewById(R.id.name_input)

        loginBtn.setOnClickListener {
            startActivity(Intent(this, Home::class.java)
                .putExtra("name", nameInput.text.toString()))

        }
    }

}