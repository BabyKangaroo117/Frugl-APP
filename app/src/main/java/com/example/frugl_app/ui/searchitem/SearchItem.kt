package com.example.frugl_app.ui.searchitem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.frugl_app.R
import com.example.frugl_app.data.api.RetrofitClient
import com.example.frugl_app.data.repository.ItemRepository
import com.example.frugl_app.ui.homepage.Homepage
import com.example.frugl_app.ui.list.CreateList
import com.example.frugl_app.ui.main.ItemViewModel
import com.example.frugl_app.ui.user.UserAccount


class SearchItem : AppCompatActivity() {
    private val repository = ItemRepository(RetrofitClient.instance)
    private val viewModel: ItemViewModel = ItemViewModel(repository)
    private lateinit var searchView: SearchView
    // Dummy data for the RecyclerView
    private val predefinedItems = arrayOf(
        "Apple", "Banana", "Cherry", "Date", "Fig", "Grape",
        "Kiwi", "Lemon", "Mango", "Orange", "Papaya", "Peach", "Pineapple", "Plum", "Raspberry",
        "Strawberry", "Watermelon"
    )

    private var itemDetailsMap: MutableMap<String, Triple<String, String, String>> = mutableMapOf()


    // List to store the suggestions
    private val suggestionsList = mutableListOf<String>()
    private lateinit var adapter: MyRecyclerViewAdapter
    private lateinit var recyclerView: RecyclerView // Add a reference to the RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_item)

        viewModel.fetchData()
        viewModel.itemsLiveData.observe(this) {
            // Update UI with the list of items
            viewModel.findCheapestPrice()
            //Log.d("LOG_MESSAGE", it.toString())
        }

        viewModel.itemsLiveData.observe(this) { items ->
            for (item in items) {
                itemDetailsMap[item.itemName] = Triple(item.itemName, item.cheapestUnitPrice.toString(), "")
            }

        }

        searchView = findViewById(R.id.searchItemBar)
        recyclerView = findViewById(R.id.searchRV)

        // Initialize the RecyclerView and set its layout manager
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MyRecyclerViewAdapter(this, suggestionsList, itemDetailsMap)
        recyclerView.adapter = adapter


        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                suggestionsList.clear()
                if (!newText.isNullOrEmpty()) {
                    for ((item,detail) in itemDetailsMap) {
                        if (item.startsWith(newText, ignoreCase = true)) {
                            suggestionsList.add(item)
                        }
                    }
                }
                adapter.notifyDataSetChanged()
                return false
            }
        })

        // When Home button is clicked, go to Homepage
        val homeButton: Button = findViewById(R.id.SIbtnHomepage)
        homeButton.setOnClickListener {
            val intent: Intent = Intent(this, Homepage::class.java)
            startActivity(intent)
        }
        // When Account button is clicked, go to UserAccount
        val searchButton: Button = findViewById(R.id.SIbtnUserAccount)
        searchButton.setOnClickListener {
            val intent: Intent = Intent(this, UserAccount::class.java)
            startActivity(intent)
        }
        // When Cart button is clicked, go to CreateList
        val cartButton: Button = findViewById(R.id.SIbtnGroceryList)
        cartButton.setOnClickListener {
            val intent: Intent = Intent(this, CreateList::class.java)
            startActivity(intent)
        }

//        // When Map button is clicked, go to Map
//        val mapButton: Button = findViewById(R.id.SIbtnMaps)
//        mapButton.setOnClickListener {
//            val intent: Intent = Intent(this, Maps::class.java)
//            startActivity(intent)
//        }


    }
}

