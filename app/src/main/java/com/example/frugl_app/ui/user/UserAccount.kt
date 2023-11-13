package com.example.frugl_app.ui.user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.frugl_app.R
import com.example.frugl_app.ui.homepage.Homepage
import com.example.frugl_app.ui.list.CreateList
import com.example.frugl_app.ui.searchitem.SearchItem

class UserAccount : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_account)
        // If the user signs up, the user's address, email, and full name are displayed on the UserAccount page.
        // If the user is logging in a default value will be shown for the address, email, and full name.
        val bundle: Bundle? = intent.extras
        var address = bundle?.getString("user_address")
        var email = bundle?.getString("user_email")
        var user_fullname = bundle?.getString("user_fullname")

        // Check for null values and set default values if necessary
        if (address == null || email == null || user_fullname == null) {
            // Set default values or handle as needed
            address = "1600 Woodland Rd, Abington, PA 19001"
            email = "username@email.com"
            user_fullname = "Default User Full Name"
        }

        val userAddressDisplay: TextView = findViewById(R.id.userAddress)
        userAddressDisplay.text = ("$address")
        val userEmailDisplay: TextView = findViewById(R.id.userEmail)
        userEmailDisplay.text = ("$email")
        val userFullNameDisplay: TextView = findViewById(R.id.fullName)
        userFullNameDisplay.text = ("$user_fullname")

        // When Home button is clicked, go to Homepage
        val homeButton: Button = findViewById(R.id.UAbtnHomepage)
        homeButton.setOnClickListener {
            val intent: Intent = Intent(this, Homepage::class.java)
            startActivity(intent)
        }
        // When Search button is clicked, go to SearchItem
        val searchButton: Button = findViewById(R.id.UAbtnSearch)
        searchButton.setOnClickListener {
            val intent: Intent = Intent(this, SearchItem::class.java)
            startActivity(intent)
        }
        // When Cart button is clicked, go to CreateList
        val cartButton: Button = findViewById(R.id.UAbtnGroceryList)
        cartButton.setOnClickListener {
            val intent: Intent = Intent(this, CreateList::class.java)
            startActivity(intent)
        }

//        // When Map button is clicked, go to Map
//        val mapButton: Button = findViewById(R.id.UAbtnMaps)
//        mapButton.setOnClickListener {
//            val intent: Intent = Intent(this, Map::class.java)
//            startActivity(intent)
//        }

    }
}