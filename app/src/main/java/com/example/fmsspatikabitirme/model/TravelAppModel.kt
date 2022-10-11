package com.example.fmsspatikabitirme.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TravelAppModel(
    val category: String,
    val city: String,
    val country: String,
    val description: String,
    val id: String,
    val images: List<Image>,
    val isBookmark: Boolean,
    val title: String
): Parcelable