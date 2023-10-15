package com.example.frugl_app
import android.database.MatrixCursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.BaseColumns
import android.util.Log
import android.widget.SearchView
import android.widget.CursorAdapter
import android.widget.SimpleCursorAdapter
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CreateList : AppCompatActivity(), ItemListener {
    private lateinit var viewModel: CreateListViewModel
    private lateinit var itemAdapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_list)

        viewModel = ViewModelProvider(this).get(CreateListViewModel::class.java)

        val itemRv: RecyclerView = findViewById(R.id.itemRv)
        itemAdapter = ItemAdapter(mutableListOf(), this)
        itemRv.adapter = itemAdapter
        itemRv.layoutManager = LinearLayoutManager(this)

        viewModel.itemList.observe(this, Observer { items ->
            itemAdapter.updateItems(items)
        })

        createSearchBar()
    }

    override fun onItemAdd(itemName: String) {
        viewModel.addItem(itemName)
    }

    override fun onItemDelete(position: Int) {
        viewModel.deleteItem(position)
    }

    // shortcut method for displaying toast message
    private fun displayToastMessage(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    // create and update search bar
    private fun createSearchBar(){
        val searchView: SearchView = findViewById(R.id.search)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            // update suggestions based on the text change in search bar
            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    updateSuggestions(searchView, it)
                }
                return true
            }
        })
    }

    //update suggestions based on what the user typed in the search bar
    private fun updateSuggestions(searchView: SearchView, text: String){
        // array of suggested items
        val suggestedItems = arrayOf("apple", "apricot",  "banana", "chicken", "cheese")
        // filter items based on starting text
        val suggestions = suggestedItems.filter { it.startsWith(text) }
        val columns = arrayOf(BaseColumns._ID, "suggestion")
        val cursor = MatrixCursor(columns)

        suggestions.forEachIndexed { index, suggestion ->
            cursor.addRow(arrayOf(index, suggestion))
        }

        val from = arrayOf("suggestion")
        val to = intArrayOf(android.R.id.text1)
        val adapter: SimpleCursorAdapter = SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursor, from, to, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER)

        searchView.suggestionsAdapter = adapter

        searchView.setOnSuggestionListener(object : SearchView.OnSuggestionListener {
            override fun onSuggestionSelect(position: Int): Boolean {
                return true
            }
            override fun onSuggestionClick(position: Int): Boolean {
                // Retrieve the selected suggestion from your array
                val selectedSuggestion = suggestions[position]
                searchView.setQuery(selectedSuggestion, true) // The second parameter submits the query

                // add the item to the list when user clicks on the suggestion
                onItemAdd(selectedSuggestion)

                // clear the search bar
                searchView.setQuery("", false)

                return true
            }
        })
    }
}