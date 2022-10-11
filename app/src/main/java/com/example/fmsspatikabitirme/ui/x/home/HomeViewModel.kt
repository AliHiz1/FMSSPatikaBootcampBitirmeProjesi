package com.example.fmsspatikabitirme.ui.x.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fmsspatikabitirme.domain.repository.TravelAppRepository
import com.example.fmsspatikabitirme.domain.usecase.TravelUsecase
import com.example.fmsspatikabitirme.model.Image
import com.example.fmsspatikabitirme.model.TravelAppModel
import com.example.fmsspatikabitirme.model.TravelModel
import com.example.fmsspatikabitirme.service.TravelApi
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Response
import retrofit2.Call
import retrofit2.Callback
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val travelUsecase: TravelUsecase) : ViewModel() {

    private var _travelAppModelData = MutableLiveData<TravelModel>()
    val travelData: LiveData<TravelModel>
        get() = _travelAppModelData

    init {
        getAllData()
    }
    /*
     fun getAdapter(): HomeAdapter{
        return homeAdapter
    }

    fun setAdapterData(data: MutableList<Image>){
        travelAppModelData.setDataList(data)
    }

    fun getTravelAppModelDataObserver(): MutableLiveData<List<TravelAppModel>?> {
        return travelAppModelData
    }
     */


    fun getAllData() {
        travelUsecase.getAllData().enqueue(object : Callback<TravelModel> {
            override fun onResponse(call: Call<TravelModel>, response: Response<TravelModel>) {
                _travelAppModelData.value = response.body()
            }

            override fun onFailure(call: Call<TravelModel>, t: Throwable) {
                println("Warning")
            }


        })

    }
}