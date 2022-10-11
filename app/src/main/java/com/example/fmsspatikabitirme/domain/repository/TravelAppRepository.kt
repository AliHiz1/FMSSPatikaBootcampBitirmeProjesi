package com.example.fmsspatikabitirme.domain.repository

import com.example.fmsspatikabitirme.model.GuideCategoryModel
import retrofit2.Call
import com.example.fmsspatikabitirme.model.TravelModel

interface TravelAppRepository {
    fun getAllData(): Call<TravelModel>
    fun getGuideData(): Call<GuideCategoryModel>
}