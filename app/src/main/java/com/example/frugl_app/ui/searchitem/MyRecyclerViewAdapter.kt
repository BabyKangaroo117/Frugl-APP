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
    private val items: List<String>
) : RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productDescription: TextView = itemView.findViewById(R.id.productDescription)
        val fixedPrice: TextView = itemView.findViewById(R.id.fixedPrice)
        val unitPrice: TextView = itemView.findViewById(R.id.unitPrice)
        // Add more views if needed
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.activity_search_item_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        // Set data from your items list to the views in your layout
        holder.productDescription.text = item
        // Set other data to your other views as needed
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
