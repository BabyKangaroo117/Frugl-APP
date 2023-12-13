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

    private val _cartList = MutableLiveData<MutableList<Item>?>()
    val cartList: MutableLiveData<MutableList<Item>?> get() = _cartList

    init {
        _cartList.value = mutableListOf()
    }

    fun addItem(item: Item) {
        val list = _cartList.value ?: mutableListOf()
        val foundItem = list.find { it.itemName == item.itemName }

        if (foundItem == null) {
            list.add(Item(itemName = item.itemName,
                genericName = item.genericName,
                shopriteItem = item.shopriteItem,
                wegmansItem = item.wegmansItem,
                itemUnits = item.itemUnits,
                quantity = 1,
                postalCode = item.postalCode,
                shopriteUnitPrice = item.shopriteUnitPrice,
                wegmansUnitPrice = item.wegmansUnitPrice,
                cheapestUnitPrice = item.cheapestUnitPrice,
                ))
        } else {
            foundItem.quantity++
        }

        _cartList.value = list
    }

    fun deleteItem(position: Int) {
        val list = _cartList.value ?: mutableListOf()
        if (position < list.size) {
            list.removeAt(position)
        }
        _cartList.value = list
    }

    fun fetchData() {
        if (!isDataLoaded) {
            repository.getAreaItems()
            repository.getItems()
            isDataLoaded = true
        }
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
}
