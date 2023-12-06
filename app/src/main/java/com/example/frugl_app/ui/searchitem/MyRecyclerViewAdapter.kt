package com.example.frugl_app.ui.searchitem

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.frugl_app.R
import com.example.frugl_app.data.model.Item
import com.example.frugl_app.ui.main.ItemViewModel

class MyRecyclerViewAdapter(
    private val context: Context,
    private val items: List<String>,
    private val itemDetailsMap: MutableLiveData<List<Item>>,
    private val viewModel: ItemViewModel
    // private val itemDetailsMap: MutableMap<String, Triple<String, String, String>>
) : RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder>() {

    private var detailsList: List<Item> = emptyList()

//    init {
//        // Observe changes in itemDetailsMap and update detailsList accordingly
//        itemDetailsMap.observe(context as LifecycleOwner, Observer { items ->
//            detailsList = items
//            notifyDataSetChanged() // Notify adapter that the data set has changed
//        })
//    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemName: TextView = itemView.findViewById(R.id.productName)
        val productDescription: TextView = itemView.findViewById(R.id.productDescription)
        val fixedPrice: TextView = itemView.findViewById(R.id.fixedPrice)
        val unitPrice: TextView = itemView.findViewById(R.id.unitPrice)
        val addToGroceryListButton: Button = itemView.findViewById(R.id.addToGroceryList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.activity_search_item_view, parent, false)
        val viewHolder = ViewHolder(view)

        viewHolder.addToGroceryListButton.setOnClickListener {
            val position = viewHolder.adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                // Get the selected item name
                val itemName = items[position]

                // TODO: Implement logic to send the item to the CreateList activity
                // For now, let's just print a message to verify the click event
                Log.d("AddToList", "Clicked: $itemName")

                // Get the item details from the LiveData
                val currentItem = itemDetailsMap.value?.find { it.itemName == itemName }

                // Check if the item is not null before adding to the list
                currentItem?.let {
                    // Call the ViewModel method to add the item
                    viewModel.addItems(it)
                    Log.d("AddedItemsList", viewModel.addedItems.value.toString())
                }
            }
        }

        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemName = items[position]

        // Observe changes in itemDetailsMap
        itemDetailsMap.observe(context as LifecycleOwner, Observer { items ->
            val currentItem = items.find { it.itemName == itemName }

            // Check if the item is not null before accessing its properties
            currentItem?.let {
                // Set the values to the corresponding TextViews
                holder.itemName.text = it.genericName ?: "Name not available"
                holder.productDescription.text = it.itemName ?: "Description not available"
                holder.fixedPrice.text = "$ ${it.shopriteUnitPrice.toString()}/ Unit" ?: "Fixed Price not available"
                holder.unitPrice.text = "$ ${it.wegmansUnitPrice.toString()}/ Unit" ?: "Unit Price not available"

                // Set a click listener for the addToGroceryListButton
                holder.addToGroceryListButton.setOnClickListener {
                    itemClickListener?.onItemClick(itemName)
                }
            }
        })
    }

    override fun getItemCount(): Int {
        return items.size
    }

    interface OnItemClickListener {
        fun onItemClick(itemName: String)
    }

    private var itemClickListener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.itemClickListener = listener
    }

}
