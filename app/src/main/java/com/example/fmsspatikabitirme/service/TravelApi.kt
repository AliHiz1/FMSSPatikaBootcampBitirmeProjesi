package com.example.fmsspatikabitirme.service

import com.example.fmsspatikabitirme.model.GuideCategoryModel
import com.example.fmsspatikabitirme.model.TravelAppModel
import com.example.fmsspatikabitirme.model.TravelModel
import retrofit2.Call
import retrofit2.http.GET

interface TravelApi {

    @GET("AllTravelList")
    fun getAllData(): Call<TravelModel>

    @GET("GuideCategories")
    fun getGuideData(): Call<GuideCategoryModel>
}