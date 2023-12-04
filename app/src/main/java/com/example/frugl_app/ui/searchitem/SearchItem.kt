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

    // Dummy data for items in the RecyclerView
    private val itemDetailsMap = mapOf(
        "Apple" to Triple("Fresh and juicy apple", "$1.99", "$0.50"),
        "Banana" to Triple("Ripe yellow banana", "$0.99", "$0.25"),
        "Cherry" to Triple("Sweet red cherry", "$2.49", "$0.75"),
        "Date" to Triple("Dried date", "$3.99", "$1.00"),
        "Fig" to Triple("Organic fig", "$2.79", "$0.70"),
        "Grape" to Triple("Seedless green grape", "$1.49", "$0.35"),
        "Kiwi" to Triple("Fuzzy kiwi", "$1.79", "$0.45"),
        "Lemon" to Triple("Sour yellow lemon", "$0.89", "$0.20"),
        "Mango" to Triple("Ripe mango", "$2.99", "$0.80"),
        "Orange" to Triple("Sweet orange", "$1.29", "$0.30"),
        "Papaya" to Triple("Tropical papaya", "$3.49", "$0.90"),
        "Peach" to Triple("Juicy peach", "$2.29", "$0.60"),
        "Pineapple" to Triple("Fresh pineapple", "$4.99", "$1.20"),
        "Plum" to Triple("Purple plum", "$1.69", "$0.40"),
        "Raspberry" to Triple("Red raspberry", "$2.89", "$0.70"),
        "Strawberry" to Triple("Sweet strawberry", "$2.19", "$0.50"),
        "Watermelon" to Triple("Juicy watermelon", "$5.99", "$1.50")
    )


    // List to store the suggestions
    private val suggestionsList = mutableListOf<String>()
    private lateinit var adapter: MyRecyclerViewAdapter
    private lateinit var recyclerView: RecyclerView // Add a reference to the RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_item)

        viewModel.itemsLiveData.observe(this) { items ->
            // Update UI with the list of items
            Log.d("LOG_MESSAGE", items.toString())
        }
        viewModel.fetchData()

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

