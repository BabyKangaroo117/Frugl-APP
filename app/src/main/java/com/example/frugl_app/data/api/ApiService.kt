package com.example.frugl_app.data.api

import com.example.frugl_app.data.model.ApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    //getting a list of all items
    @GET("/api/Items")
    suspend fun getItems(): Response<ApiResponse> //returns a list of items

    suspend fun getStoreNames(): Response<List<String>> //returns a list of store names

}