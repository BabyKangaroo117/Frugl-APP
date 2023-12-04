package com.example.frugl_app.ui.main


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.frugl_app.data.model.Item
import com.example.frugl_app.data.repository.ItemRepository

class ItemViewModel(private val repository: ItemRepository) : ViewModel() {
    private var isDataLoaded = false

    // Observe changes in the data using LiveData
    val itemsLiveData: MutableLiveData<List<Item>?> = repository.itemsLiveData

    fun fetchData() {
        if (!isDataLoaded) {
            repository.getAreaItems()
            isDataLoaded = true
        }
    }
}
