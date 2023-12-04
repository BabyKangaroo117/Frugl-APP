package com.example.frugl_app.data.model

import android.os.Parcelable

data class Item(
    var itemName: String,
    var genericName: String,
    val shopriteItem: String,
    val wegmansItem: String,
    var quantity: Int = 0,
    val postalCode: Int = 0,

    //unit prices
    val shopriteUnitPrice: Double = 0.0,
    val wegmansUnitPrice: Double = 0.0,
    var cheapestUnitPrice: Double

): Parcelable {
    constructor(parcel: android.os.Parcel) : this(
        parcel.readString()!!, // generic name for the item
        parcel.readString()!!, // item name
        parcel.readString()!!, // shoprite item name
        parcel.readString()!!, // wegmans item name
        parcel.readInt(),      //quantity
        parcel.readInt(),      //postalCode

        //unit prices
        parcel.readDouble(), // shoprite unit price
        parcel.readDouble(), // wegmans unit price
        parcel.readDouble() // cheapest unit price
    )

    override fun writeToParcel(parcel: android.os.Parcel, flags: Int) {
        parcel.writeString(itemName)
        parcel.writeString(genericName)
        parcel.writeString(shopriteItem)
        parcel.writeString(wegmansItem)
        parcel.writeInt(quantity)
        parcel.writeInt(postalCode)

        //unit prices
        parcel.writeDouble(shopriteUnitPrice)
        parcel.writeDouble(wegmansUnitPrice)
        parcel.writeDouble(cheapestUnitPrice)
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