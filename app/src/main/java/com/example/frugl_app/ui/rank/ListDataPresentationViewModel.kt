package com.example.frugl_app.ui.rank

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.frugl_app.data.model.Item

class ListDataPresentationViewModel: ViewModel() {
    //internal list of items
    private val _itemList = MutableLiveData<MutableList<Item>>()

    //gettable list of items (for external interfacing)
    val itemList: LiveData<MutableList<Item>> get() = _itemList

    init {
        //setting up our mutable list
        _itemList.value = mutableListOf()
    }
}