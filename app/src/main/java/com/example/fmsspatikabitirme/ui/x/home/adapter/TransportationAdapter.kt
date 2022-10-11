package com.example.fmsspatikabitirme.ui.x.home.adapter

import android.annotation.SuppressLint
import android.provider.ContactsContract.Data
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.fmsspatikabitirme.R
import com.example.fmsspatikabitirme.model.TravelAppModel
import com.example.fmsspatikabitirme.model.TravelModel
import com.example.fmsspatikabitirme.ui.x.home.HomeFragmentViewHolder

class TransportationAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var transpotationBinding: ViewDataBinding
    private var travelModel = TravelModel()
    private val transportationArray = ArrayList<TravelAppModel>()

    @SuppressLint("NotifyDataSetChanged")
    private fun transportationCategory(){
        transportationArray.clear()
        for (transport in travelModel){
            if (transport.category == "transportation"){
                transportationArray.add(transport)
                notifyDataSetChanged()
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setTransportationData(travelModel: TravelModel){
        this.travelModel = travelModel
        //transportationArray.clear()
        notifyDataSetChanged()
        transportationCategory()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        transpotationBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.recycler_row,parent,false)
        return HomeFragmentViewHolder(transpotationBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as HomeFragmentViewHolder).homeRVBind(transportationArray[position])
    }

    override fun getItemCount() = transportationArray.size


}