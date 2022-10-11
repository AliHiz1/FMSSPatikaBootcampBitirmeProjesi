package com.example.fmsspatikabitirme.domain.usecase

import com.example.fmsspatikabitirme.domain.repository.TravelAppRepository
import com.example.fmsspatikabitirme.model.GuideCategoryModel
import com.example.fmsspatikabitirme.model.TravelModel
import retrofit2.Call
import javax.inject.Inject

class TravelUsecase @Inject constructor(private val travelAppRepository: TravelAppRepository) {

    fun getAllData(): Call<TravelModel> {
        return travelAppRepository.getAllData()
    }
    fun getGuideData(): Call<GuideCategoryModel> {
        return travelAppRepository.getGuideData()
    }

}