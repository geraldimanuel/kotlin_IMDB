package com.example.kotlin_imdb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    private lateinit var loginBtn: Button
    private lateinit var nameInput: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginBtn = findViewById(R.id.login_button)
        nameInput = findViewById(R.id.name_input)


        loginBtn.setOnClickListener {
            if (nameInput.text.toString().isEmpty()) {
                Toast.makeText(this, "Name cannot be empty", Toast.LENGTH_SHORT).show()
            } else {

                // send name to profile fragment
//                val profileFragment = ProfileFragment()
//                val bundle = Bundle()
//                bundle.putString("name", nameInput.text.toString())
//                profileFragment.arguments = bundle
//
//                supportFragmentManager.beginTransaction()
//                    .replace(R.id.fragment_container, profileFragment)
//                    .commit()

                startActivity(Intent(this, Home::class.java)
                    .putExtra("name", nameInput.text.toString()))
            }
        }

    }

}