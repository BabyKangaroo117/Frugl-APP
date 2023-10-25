package com.example.frugl_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class SearchItem : AppCompatActivity() {

    private lateinit var searchView: SearchView
    private val predefinedItems = arrayOf(
        "Apple", "Banana", "Cherry", "Date", "Fig", "Grape",
        "Kiwi", "Lemon", "Mango", "Orange", "Papaya", "Peach", "Pineapple", "Plum", "Raspberry",
        "Strawberry", "Watermelon"
    )
    private val suggestionsList = mutableListOf<String>()
    private lateinit var adapter: MyRecyclerViewAdapter
    private lateinit var recyclerView: RecyclerView // Add a reference to the RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_item)

        searchView = findViewById(R.id.searchItemBar)
        recyclerView = findViewById(R.id.searchRV)

        // Initialize the RecyclerView and set its layout manager
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MyRecyclerViewAdapter(this, suggestionsList)
        recyclerView.adapter = adapter


        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    suggestionsList.clear()
                    for (item in predefinedItems) {
                        if (item.startsWith(newText, ignoreCase = true)) {
                            suggestionsList.add(item)
                        }
                    }
                    adapter.notifyDataSetChanged()
                }
                return false
            }
        })


    }
}

