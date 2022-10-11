package com.example.fmsspatikabitirme.ui.x.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.fmsspatikabitirme.BR
import com.example.fmsspatikabitirme.R
import com.example.fmsspatikabitirme.databinding.RecyclerRowBinding
import com.example.fmsspatikabitirme.model.TravelAppModel
import com.example.fmsspatikabitirme.model.TravelModel
import com.example.fmsspatikabitirme.ui.x.home.HomeFragmentDirections

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    private var travelModel: TravelModel = TravelModel()
    private lateinit var binding: RecyclerRowBinding

    @SuppressLint("NotifyDataSetChanged")
    fun setDataList(travelModel: TravelModel) {
        this.travelModel = travelModel
        notifyDataSetChanged()
    }

    class HomeViewHolder(private val binding: RecyclerRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(travelAppModel: TravelAppModel) {
            binding.homeRow = travelAppModel
            binding.executePendingBindings()
            binding.setVariable(BR.homeRow, travelAppModel)

            binding.root.setOnClickListener() { view ->
                val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(travelAppModel)
                Navigation.findNavController(view).navigate(action)
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.recycler_row,
            parent, false
        )
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(travelModel[position])
    }

    override fun getItemCount() = travelModel.size



}
