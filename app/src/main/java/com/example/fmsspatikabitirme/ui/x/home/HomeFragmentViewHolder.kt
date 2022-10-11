package com.example.fmsspatikabitirme.ui.x.home

import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.fmsspatikabitirme.databinding.RecyclerRowBinding
import com.example.fmsspatikabitirme.model.TravelAppModel

class HomeFragmentViewHolder(private val recyclerRow : ViewDataBinding): RecyclerView.ViewHolder(recyclerRow.root) {

    fun homeRVBind(travelAppModel: TravelAppModel){
        recyclerRow as RecyclerRowBinding
        recyclerRow.setVariable(BR.homeRow, travelAppModel)

        recyclerRow.root.setOnClickListener() { view ->
            val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(travelAppModel)
            Navigation.findNavController(view).navigate(action)

        }
    }
}