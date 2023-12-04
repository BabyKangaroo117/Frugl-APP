package com.example.frugl_app.ui.list
import android.content.Intent
import android.database.MatrixCursor
import android.os.Bundle
import android.provider.BaseColumns
import android.widget.Button
import android.widget.CursorAdapter
import android.widget.SearchView
import android.widget.SimpleCursorAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.frugl_app.R
import com.example.frugl_app.data.model.Item
import com.example.frugl_app.ui.homepage.Homepage
import com.example.frugl_app.ui.rank.ListDataPresentation
import com.example.frugl_app.ui.searchitem.SearchItem
import com.example.frugl_app.ui.user.UserAccount


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

        // When Home button is clicked, go to Homepage
        val homeButton: Button = findViewById(R.id.CLbtnHomepage)
        homeButton.setOnClickListener {
            val intent: Intent = Intent(this, Homepage::class.java)
            startActivity(intent)
        }

        // When Search button is clicked, go to SearchItem
        val searchButton: Button = findViewById(R.id.CLbtnSearch)
        searchButton.setOnClickListener {
            val intent: Intent = Intent(this, SearchItem::class.java)
            startActivity(intent)
        }

        // When Account button is clicked, go to UserAccount
        val cartButton: Button = findViewById(R.id.CLbtnUserAccount)
        cartButton.setOnClickListener {
            val intent: Intent = Intent(this, UserAccount::class.java)
            startActivity(intent)
        }

//        // When Map button is clicked, go to Maps
//        val mapButton: Button = findViewById(R.id.CLbtnMaps)
//        mapButton.setOnClickListener {
//            val intent: Intent = Intent(this, Maps::class.java)
//            startActivity(intent)
//        }

        // When Go button is clicked, go to Rank
        val rankButton: Button = findViewById(R.id.RankPrices)
        rankButton.setOnClickListener {
            val intent: Intent = Intent(this, ListDataPresentation::class.java)

            // parcelize the shopping list that the user created
            val itemList: MutableList<Item>? = viewModel.itemList.value

            //Log.d("Debug", "itemList size: ${itemList?.size}")

            if (itemList != null){
                // parcelize the shopping list
                intent.putParcelableArrayListExtra("items", ArrayList(itemList))
                // start the Rank Activity
                startActivity(intent)
            }

            // shopping cart is empty
            else{
                // notify the user that they need to add some items to their list
                Toast.makeText(this, "Please add items to your shopping list", Toast.LENGTH_SHORT).show()
            }
        }
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