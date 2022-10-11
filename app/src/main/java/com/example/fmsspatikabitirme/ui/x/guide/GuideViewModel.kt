package com.example.fmsspatikabitirme.ui.x.guide

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fmsspatikabitirme.domain.usecase.TravelUsecase
import com.example.fmsspatikabitirme.model.GuideCategoryModel
import com.example.fmsspatikabitirme.model.TravelModel
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class GuideViewModel @Inject constructor(private val travelUsecase: TravelUsecase): ViewModel(){

    private var _travelAppModelData = MutableLiveData<TravelModel>()
    private var _guideCategoryModelData = MutableLiveData<GuideCategoryModel>()
    val travelData: LiveData<TravelModel>
        get() = _travelAppModelData
    val guideData: LiveData<GuideCategoryModel>
        get() = _guideCategoryModelData

    init {
        getAllData()
        getGuideData()
    }


    fun getAllData(){
        travelUsecase.getAllData().enqueue(object : Callback<TravelModel>{
            override fun onResponse(call: Call<TravelModel>, response: Response<TravelModel>) {
                _travelAppModelData.value = response.body()
            }

            override fun onFailure(call: Call<TravelModel>, t: Throwable) {
                println("Warning")
            }

        })
    }
    fun getGuideData(){
        travelUsecase.getGuideData().enqueue(object : Callback<GuideCategoryModel>{
            override fun onResponse(call: Call<GuideCategoryModel>, response: Response<GuideCategoryModel>) {
                _guideCategoryModelData.value = response.body()
            }

            override fun onFailure(call: Call<GuideCategoryModel>, t: Throwable) {
                println("Warning")
            }


        })
    }
}