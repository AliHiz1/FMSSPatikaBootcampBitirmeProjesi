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

class HotelAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var hotelBinding: ViewDataBinding
    private var travelModel = TravelModel()
    private val hotelArray = ArrayList<TravelAppModel>()

    @SuppressLint("NotifyDataSetChanged")
    private fun hotelCategory(){
        hotelArray.clear()
        for(hotel in travelModel){
            if (hotel.category == "hotel"){
                hotelArray.add(hotel)
                notifyDataSetChanged()
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setHotelData(travelModel: TravelModel){
        this.travelModel = travelModel
        //hotelArray.clear()
        notifyDataSetChanged()
        hotelCategory()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        hotelBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.recycler_row,parent,false)
        return HomeFragmentViewHolder(hotelBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as HomeFragmentViewHolder).homeRVBind(hotelArray[position])
    }

    override fun getItemCount() = hotelArray.size
}