package com.example.frugl_app.ui.rank

import android.os.Bundle
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

        //we will then send the items to the ListDataPresentationViewModel
        //data will be subdivided into lists corresponding to the prices for shoprite and wegmans
        //these lists will be sent to the recyclerviews for their given store

        //storeName
        //totalPrice

        val storeName: TextView = findViewById(R.id.storeName)
    }
}