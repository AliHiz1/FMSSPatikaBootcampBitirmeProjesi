package com.example.fmsspatikabitirme.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TripPlanManager @Inject constructor() {
    private val _deeplinkTripName = MutableLiveData<String?>()
    val deeplinkTripName: LiveData<String?> = _deeplinkTripName

    private val _deeplinkTripLoc = MutableLiveData<String?>()
    val deeplinkTripLoc: LiveData<String?> = _deeplinkTripLoc

    fun setDeeplinkTripName(deeplink: String?){
        _deeplinkTripName.value = deeplink
    }

    fun getDeeplinkTripName(): String? {
        return  _deeplinkTripName.value
    }

    fun setDeeplinkTripLoc(deeplink: String?){
        _deeplinkTripName.value = deeplink
    }

    fun getDeeplinkTripLoc(): String? {
        return  _deeplinkTripName.value
    }



}