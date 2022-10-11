package com.example.fmsspatikabitirme.ui.x.guide.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.fmsspatikabitirme.R
import com.example.fmsspatikabitirme.BR
import com.example.fmsspatikabitirme.databinding.RecyclerRowGuide2Binding
import com.example.fmsspatikabitirme.model.GuideCategoryModel
import com.example.fmsspatikabitirme.model.GuideCategoryModelItem
import com.example.fmsspatikabitirme.ui.x.home.HomeFragmentDirections

class GuideCategoriesAdapter : RecyclerView.Adapter<GuideCategoriesAdapter.GuideCategoriesViewHolder>() {

    private var guideCategoryModel: GuideCategoryModel = GuideCategoryModel()
    private lateinit var binding: RecyclerRowGuide2Binding


    @SuppressLint("NotifyDataSetChanged")
    fun setGuideDataList(guideCategoryModel: GuideCategoryModel){
        this.guideCategoryModel = guideCategoryModel
        notifyDataSetChanged()
    }

    class GuideCategoriesViewHolder(private val binding: RecyclerRowGuide2Binding):
    RecyclerView.ViewHolder(binding.root){
        fun bind(guideCategoryModelItem: GuideCategoryModelItem){
            binding as RecyclerRowGuide2Binding
            binding.guideRow2 = guideCategoryModelItem
            binding.executePendingBindings()
            binding.setVariable(BR.guideRow2, guideCategoryModelItem)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuideCategoriesViewHolder {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.recycler_row_guide_2,
            parent, false
        )
        return GuideCategoriesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GuideCategoriesViewHolder, position: Int) {
        holder.bind(guideCategoryModel[position])
    }

    override fun getItemCount() = guideCategoryModel.size

}