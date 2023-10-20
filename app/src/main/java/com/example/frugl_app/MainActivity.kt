package com.example.frugl_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // go to the login page
        login()

        // go to the sign up page
        signup()

        map()
    }

    private fun login(){
        val button: Button = findViewById(R.id.login)
        button.setOnClickListener {
            val intent: Intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }

    private fun signup(){
        val button: Button = findViewById(R.id.signup)
        button.setOnClickListener {
            val intent: Intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }
    }

    private fun map(){
        val button: Button = findViewById(R.id.map)
        button.setOnClickListener {
            val intent: Intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }
    }

}
