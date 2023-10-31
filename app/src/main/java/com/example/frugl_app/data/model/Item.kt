package com.example.frugl_app.data.model

import android.os.Parcel
import android.os.Parcelable

data class Item(
    val name: String,
    var quantity: Int
): Parcelable{
    constructor(parcel: Parcel): this(
        parcel.readString()!!,
        parcel.readInt()
    )

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString("test")
        dest.writeInt(1)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR: Parcelable.Creator<Item>{
        override fun createFromParcel(source: Parcel): Item {
            return Item(source)
        }

        override fun newArray(size: Int): Array<Item?> {
            return arrayOfNulls(size)
        }
    }
}
