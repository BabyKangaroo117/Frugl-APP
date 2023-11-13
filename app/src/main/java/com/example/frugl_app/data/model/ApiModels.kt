package com.example.frugl_app.data.model
/**
 * Stores API response data (for conversion into out app objects (item, store, etc.)
 * */

data class ApiResponse(
    val items: List<ApiItem>
)

data class ApiItem(
    val name: String,
    val quantity: Int,
    val storePrices: HashMap<String, Double>
)