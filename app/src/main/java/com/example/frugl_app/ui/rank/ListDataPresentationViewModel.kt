package com.example.frugl_app.ui.rank

import androidx.lifecycle.ViewModel
import com.example.frugl_app.data.model.Item

class ListDataPresentationViewModel: ViewModel() {
    //internal list of items
    private val _itemList: MutableList<Item> = mutableListOf()
    //gettable list of items (for external interfacing)
    val itemList: MutableList<Item> get() = _itemList

    init {
        //setting up our mutable list
        _itemList.clear()
    }

    //this will take in the list of all users selected items
    //and separate the items into lists
    fun addItems(items: List<Item>){
        _itemList.addAll(items)
    }

}