package com.example.frugl_app.ui.rank

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.frugl_app.R
import com.example.frugl_app.data.model.Store
import com.example.frugl_app.ui.list.ItemListener

class StoreAdapter(var items: List<Store>, private val itemListener: ItemListener): RecyclerView.Adapter<StoreAdapter.StoreViewHolder>(){

    inner class StoreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_list_data_presentation, parent, false)
        return StoreViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: StoreViewHolder, position: Int) {
        val store: TextView = holder.itemView.findViewById(R.id.storeName)
        val totalPrice: TextView = holder.itemView.findViewById(R.id.totalPrice)
        holder.itemView.apply {
            store.text = items[position].storeName
            totalPrice.text = items[position].totalPrice.toString()
        }

    }
}