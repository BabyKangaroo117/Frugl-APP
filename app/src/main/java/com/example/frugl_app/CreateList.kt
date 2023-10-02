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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CreateList : AppCompatActivity(), ItemListener {
    private var itemList = mutableListOf<Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_list)

        // main function that handles searching items and creating list
        createSearchBar()

        // initialize view, adapter and layout
        val itemRv: RecyclerView = findViewById(R.id.itemRv)
        val itemAdapter = ItemAdapter(itemList, this)
        itemRv.adapter = itemAdapter
        itemRv.layoutManager = LinearLayoutManager(this)
    }

    // function for adding items to the list
    override fun onItemAdd(itemName: String) {
        val itemRv: RecyclerView = findViewById(R.id.itemRv)
        val itemAdapter = itemRv.adapter

        val item: Item? = itemList.find { it.name == itemName }
        if (item == null) {
            itemList.add(Item(itemName, 1))
            itemAdapter?.notifyItemInserted(itemList.size-1)
            displayToastMessage("new item added")
        }
        else {
            item.quantity++
            val position: Int = itemList.indexOf(item)
            itemAdapter?.notifyItemChanged(position)
            displayToastMessage("item updated")
        }
    }

    override fun onItemDelete(position: Int) {
        val itemRv: RecyclerView = findViewById(R.id.itemRv)
        itemList.removeAt(position)
        itemRv.adapter?.notifyItemRemoved(position)
        displayToastMessage("item is deleted")
    }

    private fun displayToastMessage(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun createSearchBar(){
        val searchView: SearchView = findViewById(R.id.search)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

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
        val suggestedItems = arrayOf("apple", "apricot",  "banana", "chicken", "cheese")
        val suggestions = suggestedItems.filter { it.startsWith(text) }
        val columns = arrayOf(BaseColumns._ID, "suggestion")
        val cursor = MatrixCursor(columns)

        suggestions.forEachIndexed { index, suggestion ->
            cursor.addRow(arrayOf(index, suggestion))
        }

        val from = arrayOf("suggestion")
        val to = intArrayOf(android.R.id.text1)
        val adapter: SimpleCursorAdapter = SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursor, from, to, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER)

        searchView?.suggestionsAdapter = adapter

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