package com.example.fmsspatikabitirme.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
class TripAppModel(
    @ColumnInfo(name = "name")
    val tripName: String,

    @ColumnInfo(name = "tripDate")
    val tripDate: String,

    @ColumnInfo(name = "image")
    val tripImage: ByteArray?
) {
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0
}
