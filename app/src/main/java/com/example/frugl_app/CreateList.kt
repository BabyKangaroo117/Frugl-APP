package com.example.frugl_app

import android.database.MatrixCursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.BaseColumns
import android.util.Log
import android.widget.Toast
import android.widget.SearchView
import android.widget.CursorAdapter
import android.widget.SimpleCursorAdapter
import androidx.core.view.get

class CreateList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_list)

        displaySuggestions()
    }

    private fun addItem(item: String){
        Toast.makeText(this, "Adding " + item, Toast.LENGTH_LONG).show()
    }

    private fun displaySuggestions(){
        val searchView: SearchView = findViewById(R.id.search)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                // Handle search submit here if needed
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

    private fun updateSuggestions(searchView: SearchView, text: String){
        val items = arrayOf("apple", "apricot",  "banana", "chicken", "cherry")
        val suggestions = items.filter { it.startsWith(text) }
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
                addItem(selectedSuggestion.toString())

                return true
            }
        })
    }
}