package com.example.frugl_app.data.model

import android.os.Parcelable

data class Item(
    val itemName: String,
    val itemUnits: String,
    var quantity: Int,
    val postalCode: Int,

    //unit prices
    val shopriteItem: Double,
    val wegmansItem: Double

): Parcelable {
    constructor(parcel: android.os.Parcel) : this(
        parcel.readString()!!, //itemName
        parcel.readString()!!, //itemUnits
        parcel.readInt(),      //quantity
        parcel.readInt(),      //postalCode

        //unit prices
        parcel.readDouble(),
        parcel.readDouble()
    ) {
    }

    override fun writeToParcel(parcel: android.os.Parcel, flags: Int) {
        parcel.writeString(itemName)
        parcel.writeString(itemUnits)
        parcel.writeInt(quantity)
        parcel.writeInt(postalCode)

        //unit prices
        parcel.writeDouble(shopriteItem)
        parcel.writeDouble(wegmansItem)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : android.os.Parcelable.Creator<Item> {
        override fun createFromParcel(parcel: android.os.Parcel): Item {
            return Item(parcel)
        }

        override fun newArray(size: Int): Array<Item?> {
            return arrayOfNulls(size)
        }
    }
}