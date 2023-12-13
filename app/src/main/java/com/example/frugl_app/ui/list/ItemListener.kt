package com.example.frugl_app.ui.list

import com.example.frugl_app.data.model.Item

// interface for performing actions related item lists
interface ItemListener {
    fun onItemAdd(item: Item)
    fun onItemDelete(position: Int)
}