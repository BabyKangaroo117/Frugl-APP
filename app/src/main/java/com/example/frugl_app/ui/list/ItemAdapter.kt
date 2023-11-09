package com.example.frugl_app.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.frugl_app.R
import com.example.frugl_app.data.model.Item

// adapter class for passing data item list and recycler view
class ItemAdapter(var items: List<Item>, private val itemListener: ItemListener): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    // class for each item view in recycler view
    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_list_view, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    // binding recycler view items to item class and methods
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item: TextView = holder.itemView.findViewById(R.id.itemName)
        val quantity: TextView = holder.itemView.findViewById(R.id.itemQuantity)
        holder.itemView.apply {
            item.text = items[position].itemName
            quantity.text = items[position].quantity.toString()
        }
        holder.itemView.findViewById<Button>(R.id.itemDeleteButton).setOnClickListener {
            // Notify the main activity or whoever is listening about the deletion
            itemListener.onItemDelete(position)
        }
    }

    // notify the adapter if items are updated (added or removed)
    fun updateItems(items: MutableList<Item>?) {
        if (items != null) {
            this.items = items
            notifyDataSetChanged()
        }
    }
}

// interface for performing actions related item lists
interface ItemListener {
    fun onItemAdd(itemName: String)
    fun onItemDelete(position: Int)
}
