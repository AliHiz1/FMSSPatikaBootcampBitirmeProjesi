package com.example.fmsspatikabitirme.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GuideCategoryModelItem(
    val icon: String,
    val id: String,
    val title: String
): Parcelable