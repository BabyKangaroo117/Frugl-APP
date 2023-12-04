package com.example.frugl_app.ui.rank

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.frugl_app.R
import com.example.frugl_app.data.model.Item

class ListDataPresentation : AppCompatActivity() {
    private lateinit var _itemList: ArrayList<Item>
    private lateinit var viewModel: ListDataPresentationViewModel

    //@RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_data_presentation)

        //getting the list of items the user selected
        //for some reason this was deprecated so we will supress this issue
        @Suppress("Deprecation")
        _itemList = intent.getParcelableArrayListExtra<Item>("items")!! //means this will be a non-null call
        viewModel.addItems(_itemList)

        //Did this activity recieve the intent correctly from CreateList?
        Log.d("Debug", "_itemList size: ${_itemList.size}")

        //we will then send the items to the ListDataPresentationViewModel
        //data will be subdivided into lists corresponding to the prices for shoprite and wegmans
        //these lists will be sent to the recyclerviews for their given store

        //storeName
        //totalPrice

        val storeName1: TextView = findViewById(R.id.storeName1)
        val totalPrice1: TextView = findViewById(R.id.totalPrice1)

        val storeName2: TextView = findViewById(R.id.storeName2)
        val totalPrice2: TextView = findViewById(R.id.totalPrice2)

        //get the list of stores ranked in order by price
        val rankedStores = viewModel.rankStores()

        // first pair(storeName, price)
        storeName1.text = rankedStores.first.first
        totalPrice1.text = rankedStores.first.second

// second pair(storeName, price)
        storeName2.text = rankedStores.second.first
        totalPrice2.text = rankedStores.second.second

    }
}