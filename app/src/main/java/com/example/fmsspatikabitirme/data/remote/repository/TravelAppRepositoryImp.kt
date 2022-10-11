package com.example.fmsspatikabitirme.data.remote.repository

import com.example.fmsspatikabitirme.domain.repository.TravelAppRepository
import com.example.fmsspatikabitirme.model.GuideCategoryModel
import com.example.fmsspatikabitirme.model.TravelModel
import com.example.fmsspatikabitirme.service.TravelApi
import retrofit2.Call

class TravelAppRepositoryImp(private val api: TravelApi): TravelAppRepository {
    override fun getAllData(): Call<TravelModel> {
        return api.getAllData()
    }

    override fun getGuideData(): Call<GuideCategoryModel> {
        return api.getGuideData()
    }
}