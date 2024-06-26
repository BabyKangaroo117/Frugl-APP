package com.example.frugl_app.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.frugl_app.R
import com.google.android.material.textfield.TextInputEditText
import com.example.frugl_app.ui.homepage.Homepage

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login()
    }

    private fun login(){
        val username:TextInputEditText = findViewById(R.id.username)
        val password: EditText = findViewById(R.id.password)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            if (username.text.toString() == "username" && password.text.toString() == "password"){
                val intent: Intent = Intent(this, Homepage::class.java)
                intent.putExtra("user_name", username.text.toString())
                startActivity(intent)
            }
            else Toast.makeText(this, "Wrong Password", Toast.LENGTH_LONG).show()
        }
    }
}