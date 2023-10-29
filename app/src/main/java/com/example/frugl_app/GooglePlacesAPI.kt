package com.example.frugl_app

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GooglePlacesAPI {

    @GET("maps/api/place/nearbysearch/json")
    fun getNearbyPlaces(
        @Query("location") location: String,
        @Query("radius") radius: Int,
        @Query("type") type: String,
        //@Query("keyword") keyword: String,
        @Query("key") apiKey: String
    ): Call<PlacesResponse>
}
