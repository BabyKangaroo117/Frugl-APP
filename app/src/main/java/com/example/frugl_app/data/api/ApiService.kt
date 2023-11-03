package com.example.frugl_app.data.api

import com.example.frugl_app.data.model.Item
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    //getting a list of items
    @GET("/getstuff")
    suspend fun getSpecificItems(@Query("itemId") itemId: String): Response<List<Item>> //returns a list of items

    suspend fun getStoreNames(): Response<List<String>> //returns a list of store names
}