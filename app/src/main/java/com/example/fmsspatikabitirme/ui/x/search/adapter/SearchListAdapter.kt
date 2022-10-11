package com.example.fmsspatikabitirme.ui.x.search.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.fmsspatikabitirme.BR
import com.example.fmsspatikabitirme.R
import com.example.fmsspatikabitirme.databinding.RecyclerRowSearch1Binding
import com.example.fmsspatikabitirme.databinding.RecyclerRowSearch2Binding
import com.example.fmsspatikabitirme.model.TravelAppModel
import com.example.fmsspatikabitirme.model.TravelModel
import com.example.fmsspatikabitirme.ui.x.search.SearchFragmentDirections
import com.example.fmsspatikabitirme.ui.x.search.SearchListFragment
import com.example.fmsspatikabitirme.ui.x.search.SearchListFragmentDirections
import java.util.*
import kotlin.collections.ArrayList

class SearchListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var binding: ViewDataBinding
    private var travelModel =  TravelModel()
    private var searchArray = ArrayList<TravelAppModel>()

    class SearchListVievHolder(private val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root)
    {
            fun SearchListBind(travelAppModel: TravelAppModel){
                binding as RecyclerRowSearch2Binding
                binding.setVariable(BR.searchRow2, travelAppModel)
                binding.searchImgrow2.setOnClickListener { view ->
                    val action = SearchListFragmentDirections.actionSearchListFragmentToDetailsFragment(travelAppModel)
                    Navigation.findNavController(view).navigate(action)
                }
            }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.recycler_row_search_2,parent,false)
        return SearchListVievHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as SearchListVievHolder).SearchListBind(searchArray[position])
    }

    override fun getItemCount(): Int {
        return searchArray.size
    }

    private fun onSearchFilter(searchText : String){
        for(search in travelModel){
            when{
                search.description!!.lowercase(Locale.ROOT)
                    .contains(searchText) -> searchArray.add(search)
                search.category!!.lowercase(Locale.ROOT)
                    .contains(searchText) -> searchArray.add(search)
                search.city!!.lowercase(Locale.ROOT)
                    .contains(searchText) -> searchArray.add(search)
                search.country!!.lowercase(Locale.ROOT)
                    .contains(searchText) -> searchArray.add(search)
                search.title!!.lowercase(Locale.ROOT)
                    .contains(searchText) -> searchArray.add(search)
            }
        }
    }
    @SuppressLint("NotifyDataSetChanged")
    fun setSearchList(travelModel: TravelModel, searchText: String){
        this.searchArray.clear()
        this.travelModel = travelModel
        notifyDataSetChanged()
        onSearchFilter(searchText)
    }
}