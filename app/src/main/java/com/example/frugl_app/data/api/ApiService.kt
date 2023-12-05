package com.example.frugl_app.data.api

import com.example.frugl_app.data.model.Item
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("AreaItems")
    fun getAreaItems(): Call<List<Item>> //returns a list of items

    @GET("Items")
    fun getItems(): Call<List<Item>> //returns a list of items

}