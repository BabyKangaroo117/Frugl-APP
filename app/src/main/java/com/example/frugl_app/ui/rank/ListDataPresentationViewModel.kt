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

     fun findCheapestStore(): String{
        //sum unit prices for wegmans
        //sum unit prices for giant
        //return cheapest

        return ""
    }

    private fun computeCartPriceForStore(Store: String): Double{
        //for each item
        //compute unit price * units in item * quantity of items
        //sum total price
        //return sum

        return 0.0
    }

}