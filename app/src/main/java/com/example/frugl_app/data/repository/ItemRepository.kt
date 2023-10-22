package com.example.frugl_app.data.repository

import com.example.frugl_app.data.api.ApiService
import com.example.frugl_app.data.model.Item
import retrofit2.Response

/**
 * This is where our app will actually use ApiService and retrofit to make requests.
 *
 * ItemRepository is A general container for data coming in from external sources.
 * Data from DB's, Cache, Local Storage
 * or anywhere else will be sent here first before being distributed to their various destination
 * acitivities. This allows us to have a general way to interact with data from various sources.
 */

class ItemRepository(private val api: ApiService) {

    suspend fun getSpecificItems(itemId: String): Response<List<Item>> {
        return api.getSpecificItems(itemId)
    }
}