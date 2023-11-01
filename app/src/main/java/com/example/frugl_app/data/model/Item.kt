package com.example.frugl_app.data.model

import android.os.Parcel
import android.os.Parcelable

data class Item(
    val name: String,
    var quantity: Int,

    //default until we update the rest of the code
    var unitPriceShoprite: Double=0.00,
    var unitPriceWegmans: Double=0.00
): Parcelable{
    constructor(parcel: Parcel): this(
        parcel.readString()!!, //not null string
        parcel.readInt(),
        parcel.readDouble(),
        parcel.readDouble()
    )

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString("test")
        dest.writeInt(1)
    }

    override fun describeContents(): Int {
        return 0
    }

    //this will implement the behaviors for the list of items
    //companion is similiar to a static member in java...
    companion object{
        @JvmField //for some reason we expose this property directly to the jvm
        val CREATOR: Parcelable.Creator<Item> = object : Parcelable.Creator<Item> {
            override fun createFromParcel(source: Parcel): Item {
                return Item(source)  //if we can return nothing if we get nothing
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

