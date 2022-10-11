package com.example.fmsspatikabitirme.ui.x.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fmsspatikabitirme.domain.usecase.TravelUsecase
import com.example.fmsspatikabitirme.model.TravelModel
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject
import javax.security.auth.callback.Callback

@HiltViewModel
class DetailsViewModel @Inject constructor(private val travelUsecase: TravelUsecase): ViewModel() {

    private var _travelAppModelData = MutableLiveData<TravelModel>()
    val travelData: LiveData<TravelModel>
        get() = _travelAppModelData

    init {
        getDetailData()
    }

    fun getDetailData() {
        travelUsecase.getAllData().enqueue(object : retrofit2.Callback<TravelModel> {
            override fun onResponse(call: Call<TravelModel>, response: Response<TravelModel>) {
                _travelAppModelData.value = response.body()
            }

            override fun onFailure(call: Call<TravelModel>, t: Throwable) {
                println("Warning")
            }

        })
    }
}