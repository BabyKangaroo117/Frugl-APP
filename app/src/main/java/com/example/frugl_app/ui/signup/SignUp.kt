package com.example.frugl_app.ui.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.frugl_app.R
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.example.frugl_app.ui.homepage.Homepage
import com.example.frugl_app.ui.user.UserAccount

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        signup()
    }

    private fun signup() {
        val firstName: TextInputEditText = findViewById(R.id.firstName)
        val lastName: TextInputEditText = findViewById(R.id.lastName)
        val userName: TextInputEditText = findViewById(R.id.newUsername)
        val newPassword: EditText = findViewById(R.id.newPassword)
        val confirmPassword: EditText = findViewById(R.id.confirmNewPassword)
        val email: EditText = findViewById(R.id.newEmailAddress)
        val streetAddress: TextInputEditText = findViewById(R.id.streetAddress)
        val city: TextInputEditText = findViewById(R.id.city)
        val state: TextInputEditText = findViewById(R.id.state)
        val zipcode: EditText = findViewById(R.id.zipcode)

        // On create account button click, check if passwords match and send street address, city, state, and zip to UserAccount
        val signupButton: Button = findViewById(R.id.createAccountButton)
        signupButton.setOnClickListener {
            val firstname: String = firstName.text.toString()
            val lastname: String = lastName.text.toString()
            val email: String = email.text.toString()
            val username: String = userName.text.toString()
            val address = "${streetAddress.text}, ${city.text}, ${state.text} - ${zipcode.text}"
            val fullName = "$firstname $lastname"

            if (newPassword.text.toString() == confirmPassword.text.toString()) {
                val intent: Intent = Intent(this, UserAccount::class.java)
                intent.putExtra("user_name", username)
                intent.putExtra("user_address", address)
                intent.putExtra("user_fullname", fullName)
                intent.putExtra("user_email", email)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Passwords Do Not Match", Toast.LENGTH_LONG).show()
            }
        }
    }
}
