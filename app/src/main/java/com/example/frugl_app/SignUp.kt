package com.example.frugl_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        signup()
    }

    private fun signup() {
        val firstName: TextInputEditText = findViewById(R.id.firstName)
        val lastName: TextInputEditText = findViewById(R.id.lastName)
        val username: TextInputEditText = findViewById(R.id.newUsername)
        val newPassword: EditText = findViewById(R.id.newPassword)
        val confirmPassword: EditText = findViewById(R.id.confirmNewPassword)

        val signupButton: Button = findViewById(R.id.create)
        signupButton.setOnClickListener {
            if (newPassword.text.toString() == confirmPassword.text.toString()) {
                val intent: Intent = Intent(this, Homepage::class.java)
                startActivity(intent)
            } else Toast.makeText(this, "Passwords Do Not Match", Toast.LENGTH_LONG).show()
        }
    }

}