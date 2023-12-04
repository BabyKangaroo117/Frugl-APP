package com.example.frugl_app.ui.searchitem

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.frugl_app.R

class MyRecyclerViewAdapter(
    private val context: Context,
    private val items: List<String>,
    private val itemDetailsMap: MutableMap<String, Triple<String, String, String>>
) : RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemName: TextView = itemView.findViewById(R.id.productName)
        val productDescription: TextView = itemView.findViewById(R.id.productDescription)
        val fixedPrice: TextView = itemView.findViewById(R.id.fixedPrice)
        val unitPrice: TextView = itemView.findViewById(R.id.unitPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.activity_search_item_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemName = items[position]
        val details = itemDetailsMap[itemName]

        holder.itemName.text = itemName
        holder.productDescription.text = details?.first ?: "Description not available"
        holder.fixedPrice.text = details?.second ?: "Price not available"
        holder.unitPrice.text = details?.third ?: "Unit Price not available"
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
