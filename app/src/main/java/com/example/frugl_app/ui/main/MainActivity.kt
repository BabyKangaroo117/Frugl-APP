package com.example.frugl_app.ui.main

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.frugl_app.R
import com.example.frugl_app.data.api.RetrofitClient
import com.example.frugl_app.data.repository.ItemRepository
import com.example.frugl_app.ui.login.Login
import com.example.frugl_app.ui.signup.SignUp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // go to the login page
        login()

        // go to the sign up page
        signup()

        // get all items to test api call
        val itemRepository: ItemRepository = ItemRepository(RetrofitClient.instance)
        itemRepository.getItems()
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
}
