package com.example.frugl_app.ui.main


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.frugl_app.data.model.Item
import com.example.frugl_app.data.repository.ItemRepository

class ItemViewModel(private val repository: ItemRepository) : ViewModel() {
    private var isDataLoaded = false

    // Observe changes in the data using LiveData
    var itemsLiveData: MutableLiveData<List<Item>> = repository.itemsLiveData
    var genericItemNames: MutableLiveData<List<Item>> = repository.genericItems

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
