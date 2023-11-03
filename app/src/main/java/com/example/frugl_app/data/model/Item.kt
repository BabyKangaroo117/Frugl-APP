package com.example.frugl_app.data.model

import android.os.Parcel
import android.os.Parcelable

data class Item(
    val name: String,
    var quantity: Int,
    var unitPrices: HashMap<String, Double> = HashMap()

): Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readInt(),
        hashMapFromParcel(parcel)
    )

    // Function to write the HashMap to Parcel
    private fun writeHashMapToParcel(map: HashMap<String, Double>, parcel: Parcel) {
        parcel.writeInt(map.size)
        for ((key, value) in map) {
            parcel.writeString(key)
            parcel.writeDouble(value)
        }
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeInt(quantity)
        writeHashMapToParcel(unitPrices, dest)
    }

    //this will implement the behaviors for the list of items
    //companion is similar to a static member in java...
    companion object{
        // Function to read the HashMap from Parcel
        private fun hashMapFromParcel(parcel: Parcel): HashMap<String, Double> {
            val mapSize = parcel.readInt()
            val map = HashMap<String, Double>(mapSize)
            repeat(mapSize) {
                val key = parcel.readString()!!
                val value = parcel.readDouble()
                map[key] = value
            }
            return map
        }

        fun describeContents(): Int {
            return 0
        }

        @JvmField //for some reason we expose this property directly to the jvm
        val CREATOR: Parcelable.Creator<Item> = object : Parcelable.Creator<Item> {
            override fun createFromParcel(source: Parcel): Item {
                return Item(source)  //we can return nothing if we get nothing
            }

            override fun newArray(size: Int): Array<Item?> {
                return arrayOfNulls(size)
            }

            //serializing a list of items...putting them into parcel list for new activity
            fun createItemList(parcel: Parcel): List<Item> {
                val size = parcel.readInt()
                val list = mutableListOf<Item>()

                //from 0 to size...
                for (i in 0 until size) {
                    list.add(createFromParcel(parcel))
                }

                return list
            }
        }
    }


}

