package com.example.frugl_app.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.frugl_app.data.model.Item
import com.example.frugl_app.data.repository.ItemRepository

class ItemViewModel(private val repository: ItemRepository) : ViewModel() {
    private var isDataLoaded = false

    // Observe changes in the data using LiveData
    var itemsLiveData: MutableLiveData<List<Item>> = repository.itemsLiveData
    var genericItemNames: MutableLiveData<List<Item>> = repository.genericItems

    var rankedStores: MutableLiveData<Pair<Pair<String, String>, Pair<String, String>>> = MutableLiveData()
    var shoppingCartList: List<Item>? = null

    fun setItemList(items: List<Item>){
        shoppingCartList = items
    }

    fun getItemList(): List<Item>? {
        return shoppingCartList
    }

    private val _itemList = MutableLiveData<MutableList<Item>?>()
    val itemList: MutableLiveData<MutableList<Item>?> get() = _itemList

    init {
        _itemList.value = mutableListOf()
    }

    fun addItem(itemName: String) {
        val list = _itemList.value ?: mutableListOf()
        val item = list.find { it.itemName == itemName }

        if (item == null) {
            list.add(Item(itemName, "", "", "", 1, 0, 2.0, 2.0, 0.0))
        } else {
            item.quantity++
        }

        _itemList.value = list
    }

    fun deleteItem(position: Int) {
        val list = _itemList.value ?: mutableListOf()
        if (position < list.size) {
            list.removeAt(position)
        }
        _itemList.value = list
    }

    fun fetchData() {
        if (!isDataLoaded) {
            repository.getAreaItems()
            repository.getItems()
            isDataLoaded = true
        }
    }

    fun setItemList(){
        val cartList = _itemList.value
        _itemList.postValue(cartList)
    }

    fun findCheapestPrice() {
        val itemList = itemsLiveData.value

        if (itemList != null) {
            for (item in itemList) {
                val minPrice = minOf(item.shopriteUnitPrice, item.wegmansUnitPrice)
                item.cheapestUnitPrice = minPrice

                if (minPrice == item.shopriteUnitPrice) {
                    item.itemName = item.shopriteItem
                } else {
                    item.itemName = item.wegmansItem
                }
            }

            // Notify observers that the data has changed
            itemsLiveData.postValue(itemList)
        }
    }

    fun findGenericItemNames(){
        val itemList = itemsLiveData.value
        val genList = genericItemNames.value

        if (itemList != null) {
            val zippedList = itemList.zip(genList!!)
            for (item in zippedList) {
                item.first.genericName = item.second.itemName
            }
            itemsLiveData.postValue(itemList)
        }
    }

    fun rankStores() {
        val wegmansPrice: Double = shoppingCartList?.sumOf { it.wegmansUnitPrice * it.quantity } ?: 0.0
        val shopritePrice: Double = shoppingCartList?.sumOf { it.shopriteUnitPrice * it.quantity } ?: 0.0

        val wegmansPair = Pair("Wegmans", wegmansPrice.toString())
        val shopritePair = Pair("Shoprite", shopritePrice.toString())

        if (wegmansPrice < shopritePrice) {
            rankedStores.postValue(Pair(wegmansPair, shopritePair))
        }

        else if (wegmansPrice == 0.0 || shopritePrice == 0.0) {
            rankedStores.postValue(Pair(Pair("-", "-"), Pair("-", "-")))
        }

        else {
            rankedStores.postValue(Pair(shopritePair, wegmansPair))
        }
    }

}
