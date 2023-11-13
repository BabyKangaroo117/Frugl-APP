package com.example.frugl_app.data.model

import android.os.Parcelable
import android.os.Parcel
import android.os.Parcelable.Creator

//this will represent the price of the shopping cart
//at a particular store
data class Store(
    var storeName: String,
    val totalPrice: Double = 0.0
): Parcelable {

    constructor(parcel: Parcel): this(
        parcel.readString()!!,
        parcel.readDouble()
    )

    override fun writeToParcel(dest: Parcel, p1: Int) {
        dest.writeString(storeName)
        dest.writeDouble(totalPrice)
    }
    override fun describeContents(): Int {
        return 0
    }

    @JvmField //expose to jvm idk why
    val CREATOR: Parcelable.Creator<Store> = object : Parcelable.Creator<Store> {
        override fun createFromParcel(source: Parcel): Store{
            return Store(source)
        }

        override fun newArray(size: Int): Array<Store?> {
            return arrayOfNulls(size)
        }


    }

}
