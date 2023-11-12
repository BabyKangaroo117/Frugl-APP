package com.example.frugl_app.ui.rank

import androidx.lifecycle.ViewModel
import com.example.frugl_app.data.model.Item
import com.example.frugl_app.data.model.Store

class ListDataPresentationViewModel: ViewModel() {
    //internal list of items
    private val _itemList = ArrayList<Item>()

    private val _stores = ArrayList<String>()
    private val _storeObjects = ArrayList<Store>()

    //gettable list of items (for external interfacing)
    val itemList: ArrayList<Item> get() = _itemList

    init {
        //setting up our mutable list
        _itemList.clear()
    }

    //this will take in the list of all users selected items
    //and separate the items into lists
    fun addItems(items: List<Item>){
        _itemList.addAll(items)
    }

    //pass in the name of stores here
    fun addStores(stores: List<String>){
        _stores.addAll(stores)
    }

    fun rankStores(): Pair<String, String>{

        val wegmansPrice: Double = itemList.sumOf { it.wegmansItem }
        val shopritePrice: Double = itemList.sumOf { it.shopriteItem }

        val rankedStores: Pair<String, String> =
            if (wegmansPrice < shopritePrice) {
                Pair("Wegmans", wegmansPrice.toString())
            } else {
                Pair("Shoprite", shopritePrice.toString())
            }

        return rankedStores
    }


}