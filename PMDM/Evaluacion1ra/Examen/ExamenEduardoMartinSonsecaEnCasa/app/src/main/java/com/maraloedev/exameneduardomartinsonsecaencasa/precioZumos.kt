package com.maraloedev.exameneduardomartinsonsecaencasa

import android.os.Parcel
import android.os.Parcelable

data class precioZumos(val nombre:String, val precio:Int) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readInt()
    ) {
    }

    override fun toString(): String {
        return "$nombre - $precio €"
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(p0: Parcel, p1: Int) {
        TODO("Not yet implemented")
    }

    companion object CREATOR : Parcelable.Creator<precioZumos> {
        override fun createFromParcel(parcel: Parcel): precioZumos {
            return precioZumos(parcel)
        }

        override fun newArray(size: Int): Array<precioZumos?> {
            return arrayOfNulls(size)
        }
    }
}