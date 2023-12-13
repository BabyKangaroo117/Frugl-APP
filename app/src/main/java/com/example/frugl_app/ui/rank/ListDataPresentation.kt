package com.example.frugl_app.ui.rank

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.frugl_app.R
import com.example.frugl_app.data.api.RetrofitClient
import com.example.frugl_app.data.model.Item

// view model and repository
import com.example.frugl_app.data.repository.ItemRepository
import com.example.frugl_app.ui.main.ItemViewModel



class ListDataPresentation : AppCompatActivity() {
    private val repository = ItemRepository(RetrofitClient.instance)
    private val viewModel: ItemViewModel = ItemViewModel(repository)

    //@RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_data_presentation)

        val receivedList: List<Item>? = intent.getParcelableArrayListExtra("itemList")
        var rankedStores: Pair<Pair<String, String>, Pair<String, String>>? = null
        Log.d("LOG_MESSAGE6", receivedList.toString())


        val wegmansPrice: Double = receivedList?.sumOf { it.wegmansUnitPrice * it.quantity } ?: 0.0
        val shopritePrice: Double = receivedList?.sumOf { it.shopriteUnitPrice * it.quantity } ?: 0.0

        Log.d("LOG_MESSAGE7", wegmansPrice.toString())

        // currency formatting
        val wegmansPair = Pair("Wegmans", "$" + String.format("%.2f", wegmansPrice))
        val shopritePair = Pair("Shoprite", "$" + String.format("%.2f", shopritePrice))

        if (wegmansPrice < shopritePrice) {
            rankedStores = Pair(wegmansPair, shopritePair)
        }

        else if (wegmansPrice == 0.0 || shopritePrice == 0.0) {
            rankedStores = (Pair(Pair("-", "-"), Pair("-", "-")))
        }

        else {
            rankedStores = (Pair(shopritePair, wegmansPair))
        }

        // rankedStores is a Pair<Pair<String, String>, Pair<String, String>>
        val (storeName1, totalPrice1) = rankedStores.first
        val (storeName2, totalPrice2) = rankedStores.second
        // Update UI elements with ranked store information
        val storeName1TextView: TextView = findViewById(R.id.storeName1)
        val totalPrice1TextView: TextView = findViewById(R.id.totalPrice1)
        val storeName2TextView: TextView = findViewById(R.id.storeName2)
        val totalPrice2TextView: TextView = findViewById(R.id.totalPrice2)
        storeName1TextView.text = storeName1
        totalPrice1TextView.text = totalPrice1
        storeName2TextView.text = storeName2
        totalPrice2TextView.text = totalPrice2
        Log.d("Debug", rankedStores.first.toString())

    }
}