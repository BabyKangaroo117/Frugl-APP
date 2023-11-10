package com.example.frugl_app.data.repository

import com.example.frugl_app.data.api.ApiService
import com.example.frugl_app.data.model.ApiItem
import com.example.frugl_app.data.model.Item


/**
 * This is where our app will actually use ApiService and retrofit to make requests.
 *
 * ItemRepository is A general container for data coming in from external sources.
 * Data from DB's, Cache, Local Storage
 * or anywhere else will be sent here first before being distributed to their various destination
 * activities. This allows us to have a general way to interact with data from various sources.
 */

class ItemRepository(private val api: ApiService) {

    //grabs a list of items from the api, stores them in an ApiItem() object, then converts
    //them into the item() object
    suspend fun getAllItemsFromApi(): List<Item> {
        // Make the API call
        val response = api.getItems()

        if (response.isSuccessful) {
            val apiResponse = response.body()

            if (apiResponse != null) {
                // Convert ApiResponse to list of Items
                val itemList = apiResponse.items.map { apiItem: ApiItem ->
                    Item(
                        name = apiItem.name,
                        quantity = apiItem.quantity,
                        unitPrices = apiItem.storePrices
                    )
                }

                return itemList // Return the list of items
            }
        }

        // Return an empty list in case of an error or no items received
        return emptyList()
    }
}
