package com.example.frugl_app.ui.list

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.frugl_app.data.model.Item

class CreateListViewModel : ViewModel() {
    private val _itemList = MutableLiveData<MutableList<Item>>()
    val itemList: LiveData<MutableList<Item>> get() = _itemList

    init {
        _itemList.value = mutableListOf()
    }

    fun addItem(itemName: String) {
        val list = _itemList.value ?: mutableListOf()
        val item = list.find { it.itemName == itemName }

        if (item == null) {
            list.add(Item(itemName, "", "", "", 1, 0, 0.0, 0.0, 0.0))
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

    fun addItemToGroceryList(itemName: String) {
        // You can add the logic to add the item to the grocery list here
        // For now, we'll just display a toast message
        // Replace this with your actual logic to update the grocery list

        Toast.makeText(null, "Added $itemName to grocery list", Toast.LENGTH_SHORT).show()
    }
}
