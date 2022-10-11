package com.example.fmsspatikabitirme.ui.x.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.fmsspatikabitirme.R
import com.example.fmsspatikabitirme.model.TravelAppModel
import com.example.fmsspatikabitirme.model.TravelModel
import com.example.fmsspatikabitirme.ui.x.home.HomeFragmentViewHolder

class FlightAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var flightBinding : ViewDataBinding
    private var travelModel = TravelModel()
    private val flightArray = ArrayList<TravelAppModel>()

    @SuppressLint("NotifyDataSetChanged")
    private fun flightCategory(){

        flightArray.clear()
        for (flight in travelModel){
            if (flight.category == "flight"){
                flightArray.add(flight)
                notifyDataSetChanged()

            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setFlightData(travelModel: TravelModel){
        this.travelModel = travelModel
        //flightArray.clear()
        notifyDataSetChanged()
        flightCategory()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        flightBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.recycler_row, parent, false)
        return HomeFragmentViewHolder(flightBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as HomeFragmentViewHolder).homeRVBind(flightArray[position])
    }

    override fun getItemCount(): Int {
        return flightArray.size
    }
}