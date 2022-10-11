package com.example.fmsspatikabitirme.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Image(
    //val altText: Any,
    val height: Int,
    val url: String,
    val width: Int
): Parcelable