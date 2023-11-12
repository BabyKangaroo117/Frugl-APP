package com.example.frugl_app.ui.homepage

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.example.frugl_app.R
import com.example.frugl_app.ui.searchitem.SearchItem
import com.example.frugl_app.ui.user.UserAccount
import com.example.frugl_app.ui.list.CreateList

class Homepage : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        val bundle: Bundle? = intent.extras

        // Check if bundle is not null and contains "user_name" extra
        if (bundle != null && bundle.containsKey("user_name")) {
            val usnm = bundle.getString("user_name")

            val usernameDisplay: TextView = findViewById(R.id.showUsername)
            usernameDisplay.text = "Hi $usnm"
        } else {
            // Handle the case when "user_name" extra is not present
            // For example, you can set a default username or show an error message
            val usernameDisplay: TextView = findViewById(R.id.showUsername)
            usernameDisplay.text = "Hi Guest"
        }

        navigation()
    }


    private fun navigation(){

        val searchButton: ImageButton = findViewById(R.id.searchNav)
        val groceryListButton: ImageButton = findViewById(R.id.GroceryListNav)
        val accountButton: ImageButton = findViewById(R.id.accountNav)
        val mapButton: ImageButton = findViewById(R.id.mapNav)


        searchButton.setOnClickListener{
            val intent: Intent = Intent(this, SearchItem::class.java)
            startActivity(intent)
        }

        groceryListButton.setOnClickListener{
            val intent: Intent = Intent(this, CreateList::class.java)
            startActivity(intent)
        }

        mapButton.setOnClickListener{
            val intent: Intent = Intent(this, CreateList::class.java)
            startActivity(intent)
        }

        accountButton.setOnClickListener{
            val intent: Intent = Intent(this, UserAccount::class.java)
            startActivity(intent)
        }
    }
}