package com.example.fmsspatikabitirme.ui.x.guide.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.fmsspatikabitirme.BR
import androidx.recyclerview.widget.RecyclerView
import com.example.fmsspatikabitirme.R
import com.example.fmsspatikabitirme.databinding.RecyclerRowGuide2Binding
import com.example.fmsspatikabitirme.databinding.RecyclerRowGuide3Binding
import com.example.fmsspatikabitirme.model.GuideCategoryModel
import com.example.fmsspatikabitirme.model.TravelAppModel
import com.example.fmsspatikabitirme.model.TravelModel
import com.example.fmsspatikabitirme.ui.x.guide.GuideFragment
import com.example.fmsspatikabitirme.ui.x.guide.GuideFragmentDirections
import com.example.fmsspatikabitirme.ui.x.home.HomeFragmentDirections

class GuideTopPickAdapter : RecyclerView.Adapter<GuideTopPickAdapter.GuideTopPickViewHolder>() {

    private var travelModel: TravelModel = TravelModel()
    private lateinit var binding: RecyclerRowGuide3Binding
    private val topPickArray = ArrayList<TravelAppModel>()

    private fun topPickCategory(){
        for(topPickArrays in travelModel){
            if (topPickArrays.category == "toppick"){
                topPickArray.add(topPickArrays)
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setDataList(travelModel: TravelModel){
        this.travelModel = travelModel
        notifyDataSetChanged()
        topPickCategory()
    }


    class GuideTopPickViewHolder(private val binding: RecyclerRowGuide3Binding):
    RecyclerView.ViewHolder(binding.root){
        fun bind(travelAppModel: TravelAppModel){
                binding.guideRow3 = travelAppModel
                binding.executePendingBindings()
                binding.setVariable(BR.guideRow3, travelAppModel)
            binding.root.setOnClickListener() { view ->
                val action = GuideFragmentDirections.actionGuideFragmentToDetailsFragment(travelAppModel)
                Navigation.findNavController(view).navigate(action)
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuideTopPickViewHolder {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.recycler_row_guide_3,
            parent, false
        )
        return GuideTopPickViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GuideTopPickViewHolder, position: Int) {
        holder.bind(topPickArray[position])
    }

    override fun getItemCount() = topPickArray.size

}