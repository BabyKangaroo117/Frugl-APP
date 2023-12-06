package com.example.frugl_app.ui.list
import android.content.Intent
import android.database.MatrixCursor
import android.os.Bundle
import android.provider.BaseColumns
import android.util.Log
import android.widget.Button
import android.widget.CursorAdapter
import android.widget.SearchView
import android.widget.SimpleCursorAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.frugl_app.R
import com.example.frugl_app.data.api.RetrofitClient
import com.example.frugl_app.data.model.Item
import com.example.frugl_app.data.repository.ItemRepository
import com.example.frugl_app.ui.homepage.Homepage
import com.example.frugl_app.ui.main.ItemViewModel
import com.example.frugl_app.ui.rank.ListDataPresentation
import com.example.frugl_app.ui.searchitem.SearchItem
import com.example.frugl_app.ui.user.UserAccount

class CreateList : AppCompatActivity(), ItemListener {
    private val repository = ItemRepository(RetrofitClient.instance)
    private val viewModel: ItemViewModel = ItemViewModel(repository)
    //private lateinit var viewModel: CreateListViewModel
    private lateinit var itemAdapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_list)

        viewModel.fetchData()
        viewModel.itemsLiveData.observe(this) {
            // Update UI with the list of items
            viewModel.findCheapestPrice()
            viewModel.findGenericItemNames()
            Log.d("LOG_MESSAGE2", it.toString())
        }

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

        val goButton: Button = findViewById(R.id.RankPrices)
        goButton.setOnClickListener {

            val itemList1 = viewModel.itemsLiveData.value
            val itemList2 = viewModel.itemList.value
            val itemList3 = mutableListOf<Item>()

            // Iterate through itemList1 and populate itemList3 with combined data
            if (itemList1 != null) {
                for (item1 in itemList1) {
                    // Find the corresponding item in itemList2 based on itemName
                    val matchingItem = itemList2?.find { it.itemName == item1.genericName }
                    Log.d("LOG_MESSAGE5", matchingItem.toString())

                    // If a matching item is found, combine data from both items and add to itemList3
                    matchingItem?.let {
                        val combinedItem = Item(
                            itemName = item1.genericName,
                            genericName = item1.genericName,
                            shopriteItem = item1.shopriteItem,
                            wegmansItem = item1.wegmansItem,
                            quantity = it.quantity,
                            shopriteUnitPrice = item1.shopriteUnitPrice,
                            wegmansUnitPrice = item1.wegmansUnitPrice,
                            postalCode = item1.postalCode,
                            cheapestUnitPrice = item1.cheapestUnitPrice
                        )
                        itemList3.add(combinedItem)
                    }
                }
            }

            Log.d("LOG_MESSAGE3", itemList2.toString())
            Log.d("LOG_MESSAGE4", itemList3.toString())


            val intent = Intent(this, ListDataPresentation::class.java)
            intent.putParcelableArrayListExtra("itemList", ArrayList(itemList3))
            startActivity(intent)
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
        lateinit var suggestedItems: List<String>
        viewModel.genericItemNames.observe(this, Observer { items ->
            // Update UI with the list of items
            //Log.d("LOG_MESSAGE1", items.toString())
            suggestedItems = items.map { it.itemName }
        })

        // filter items based on starting text
        val suggestions = suggestedItems?.filter { it.contains(text, ignoreCase = true) }
        //Log.d("LOG_MESSAGE3", suggestions.toString())
        val columns = arrayOf(BaseColumns._ID, "suggestion")
        val cursor = MatrixCursor(columns)

        if (suggestions != null) {
            suggestions.forEachIndexed { index, suggestion ->
                cursor.addRow(arrayOf(index, suggestion))
            }
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
                val selectedSuggestion = suggestions?.get(position)
                searchView.setQuery(selectedSuggestion, true) // The second parameter submits the query

                // add the item to the list when user clicks on the suggestion
                if (selectedSuggestion != null) {
                    onItemAdd(selectedSuggestion)
                }

                // clear the search bar
                searchView.setQuery("", false)

                return true
            }
        })
    }
}