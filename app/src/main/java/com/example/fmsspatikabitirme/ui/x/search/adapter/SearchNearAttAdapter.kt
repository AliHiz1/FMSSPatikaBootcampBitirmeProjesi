package com.example.fmsspatikabitirme.ui.x.search.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.fmsspatikabitirme.R
import com.example.fmsspatikabitirme.BR
import com.example.fmsspatikabitirme.databinding.RecyclerRowSearch2Binding
import com.example.fmsspatikabitirme.model.TravelAppModel
import com.example.fmsspatikabitirme.model.TravelModel
import com.example.fmsspatikabitirme.ui.x.home.HomeFragmentDirections
import com.example.fmsspatikabitirme.ui.x.search.SearchFragmentDirections

class SearchNearAttAdapter : RecyclerView.Adapter<SearchNearAttAdapter.SearchNearAttViewHolder>() {

    private var travelModel: TravelModel = TravelModel()
    private lateinit var binding: RecyclerRowSearch2Binding

    @SuppressLint("NotifyDataSetChanged")
    fun setDataList(travelModel: TravelModel){
        this.travelModel = travelModel
        notifyDataSetChanged()
    }

    class SearchNearAttViewHolder(private val binding: RecyclerRowSearch2Binding):
        RecyclerView.ViewHolder(binding.root) {
            fun bind(travelAppModel: TravelAppModel) {
                binding as RecyclerRowSearch2Binding
                binding.searchRow2 = travelAppModel
                binding.executePendingBindings()
                binding.setVariable(BR.searchRow2, travelAppModel)
                binding.root.setOnClickListener() { view ->
                    val action = SearchFragmentDirections.actionSearchFragmentToDetailsFragment(travelAppModel)
                    Navigation.findNavController(view).navigate(action)
                }
            }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchNearAttViewHolder {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.recycler_row_search_2,
            parent, false
        )
        return SearchNearAttViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchNearAttViewHolder, position: Int) {
        holder.bind(travelModel[position])
    }

    override fun getItemCount() = travelModel.size
}