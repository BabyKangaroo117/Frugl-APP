package com.example.frugl_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Homepage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        navigation()
    }


    private fun navigation(){

        val searchButton: Button = findViewById(R.id.searchNav)
        val groceryListButton: Button = findViewById(R.id.GroceryListNav)
        val accountButton: Button = findViewById(R.id.accountNav)

        searchButton.setOnClickListener{
            val intent: Intent = Intent(this, SearchItem::class.java)
            startActivity(intent)
        }

        groceryListButton.setOnClickListener{
            val intent: Intent = Intent(this, CreateList::class.java)
            startActivity(intent)
        }

        accountButton.setOnClickListener{
            val intent: Intent = Intent(this, UserAccount::class.java)
            startActivity(intent)
        }
    }
}