package com.example.frugl_app.ui.searchitem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.SearchView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.frugl_app.R
import com.example.frugl_app.data.api.RetrofitClient
import com.example.frugl_app.data.model.Item
import com.example.frugl_app.data.repository.ItemRepository
import com.example.frugl_app.ui.homepage.Homepage
import com.example.frugl_app.ui.list.CreateList
import com.example.frugl_app.ui.main.ItemViewModel
import com.example.frugl_app.ui.user.UserAccount

/**
 * This is the SearchItem activity. It is the page that allows the user to search for items.
 *
 */
class SearchItem : AppCompatActivity(), MyRecyclerViewAdapter.OnItemClickListener {
    private val repository = ItemRepository(RetrofitClient.instance)
    private val viewModel: ItemViewModel = ItemViewModel(repository)
    private lateinit var searchView: SearchView


    private var itemDetailsMap: MutableLiveData<List<Item>> = viewModel.itemsLiveData


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
            viewModel.findGenericItemNames()
            //Log.d("LOG_MESSAGE", it.toString())
        }


        searchView = findViewById(R.id.searchItemBar)
        recyclerView = findViewById(R.id.searchRV)

        // Initialize the RecyclerView and set its layout manager
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MyRecyclerViewAdapter(this, suggestionsList, itemDetailsMap, viewModel)
        recyclerView.adapter = adapter

        // Set the click listener for the "Add to List" button
        adapter.setOnItemClickListener(this)


        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                suggestionsList.clear()
                if (!newText.isNullOrEmpty()) {
                    for ((item,detail) in itemDetailsMap.value!!) {
                        if (item.contains(newText, ignoreCase = true)) {
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

    // Implement the onItemClick method of the OnItemClickListener interface
    override fun onItemClick(itemName: String) {
        // Implement the logic to send the item to the CreateList activity
        // For now, let's just print a message to verify the click event
        Log.d("AddToList", "Clicked: $itemName")

        // Add clicked item to the list
        viewModel.addItems(itemDetailsMap.value!!.find { it.itemName == itemName }!!)


    }
}

