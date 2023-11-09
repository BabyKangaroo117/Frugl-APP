package com.example.frugl_app.data.api

import com.example.frugl_app.data.model.Item
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    //getting a list of items
//    @GET("ENDPOINTGOESHEREPLZ")
//    suspend fun getSpecificItems(@Query("itemId") itemId: String): Response<List<Item>> //returns a list of items

    @GET("AreaItems")
    fun getAreaItems(): Call<List<Item>> //returns a list of items

    @GET("Items")
    fun getItems(): Call<List<Item>> //returns a list of items

}