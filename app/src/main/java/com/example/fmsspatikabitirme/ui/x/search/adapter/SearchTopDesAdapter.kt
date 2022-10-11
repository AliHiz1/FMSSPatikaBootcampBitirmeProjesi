package com.example.fmsspatikabitirme.ui.x.search.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.fmsspatikabitirme.BR
import com.example.fmsspatikabitirme.R
import com.example.fmsspatikabitirme.databinding.RecyclerRowSearch1Binding
import com.example.fmsspatikabitirme.model.TravelAppModel
import com.example.fmsspatikabitirme.model.TravelModel
import com.example.fmsspatikabitirme.ui.x.home.HomeFragmentDirections
import com.example.fmsspatikabitirme.ui.x.search.SearchFragmentDirections

class SearchTopDesAdapter : RecyclerView.Adapter<SearchTopDesAdapter.SearchTopDesViewHolder>() {

    private var travelModel: TravelModel = TravelModel()
    private lateinit var binding: RecyclerRowSearch1Binding

    @SuppressLint("NotifyDataSetChanged")
    fun setDataList(travelModel: TravelModel) {
        this.travelModel = travelModel
        notifyDataSetChanged()
    }

    class SearchTopDesViewHolder(private val binding: RecyclerRowSearch1Binding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(travelAppModel: TravelAppModel) {
            binding as RecyclerRowSearch1Binding
            binding.searchRow1 = travelAppModel
            binding.executePendingBindings()
            binding.setVariable(BR.searchRow1, travelAppModel)
            binding.root.setOnClickListener() { view ->
                val action = SearchFragmentDirections.actionSearchFragmentToDetailsFragment(travelAppModel)
                Navigation.findNavController(view).navigate(action)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchTopDesViewHolder {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.recycler_row_search_1,
            parent, false
        )
        return SearchTopDesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchTopDesViewHolder, position: Int) {
        holder.bind(travelModel[position])
    }

    override fun getItemCount() = travelModel.size
}
