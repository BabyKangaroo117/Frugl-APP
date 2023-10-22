package com.example.frugl_app.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// instance of retrofit for interacting with the api
object RetrofitClient {
    private const val BASE_URL = "https://CHANGETHISTOOURAPIENDPOINTPLZ" //holds the general entry point

    /*
        everything inside the lazy{} block is compiled only when it is called and the result of that first
        and single compilation is what's used. So if we initialize vals in a lazy block, they wont actually
        be initialized until AFTER the first access...note that we can reassign lazy vals
     */
    val instance: ApiService by lazy { //uses an instance of our ApiService to make network Requests

        //creating an instance of retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()) //giving retrofit a GSON converter (kotlins JSON converter) to use
            .build()

        //we give retrofit a list of possible network requests we can make via our ApiService Interface
        retrofit.create(ApiService::class.java)
    }
}