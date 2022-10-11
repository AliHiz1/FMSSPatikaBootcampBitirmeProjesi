package com.example.fmsspatikabitirme.ui.x.trip.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.fmsspatikabitirme.BR
import com.example.fmsspatikabitirme.R
import com.example.fmsspatikabitirme.databinding.RecyclerRowTripBinding
import com.example.fmsspatikabitirme.model.TripAppModel
import com.example.fmsspatikabitirme.model.TripModel
import com.example.fmsspatikabitirme.ui.x.home.HomeFragmentDirections
import com.example.fmsspatikabitirme.ui.x.trip.AddTripFragment
import com.example.fmsspatikabitirme.ui.x.trip.TripFragmentDirections

class TripAdapter : RecyclerView.Adapter<TripAdapter.TripViewHolder>() {
    private var tripModel: TripModel = TripModel()
    private lateinit var binding: RecyclerRowTripBinding
    private lateinit var addTripFragment: AddTripFragment


    @SuppressLint("NotifyDataSetChanged")
    fun setDataList(tripModel: TripModel){
        this.tripModel = tripModel
        notifyDataSetChanged()
    }

    class TripViewHolder(private val binding: RecyclerRowTripBinding):
    RecyclerView.ViewHolder(binding.root){
        fun bind(tripAppModel: TripAppModel){
            binding.tripRow1 = tripAppModel
            binding.executePendingBindings()
            binding.setVariable(BR.tripRow1, tripAppModel)


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TripViewHolder {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.recycler_row_trip,
            parent, false
        )

        return TripViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TripViewHolder, position: Int) {
        holder.bind(tripModel[position])
    }

    override fun getItemCount() = tripModel.size
}