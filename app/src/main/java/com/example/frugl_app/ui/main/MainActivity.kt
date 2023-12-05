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
    private val repository = ItemRepository(RetrofitClient.instance)
    private val viewModel: ItemViewModel = ItemViewModel(repository)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // go to the login page
        login()

        // go to the sign up page
        signup()

//        viewModel.itemsLiveData.observe(this) { items ->
//            // Update UI with the list of items
//            Log.d("LOG_MESSAGE", items.toString())
//        }

        viewModel.fetchData()
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
