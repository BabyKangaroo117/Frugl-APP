package com.example.frugl_app.data.model

//this will represent the price of the shopping cart
//at a particular store
data class Store(
    var storeName: String,
    val totalPrice: Double = 0.0,
)
