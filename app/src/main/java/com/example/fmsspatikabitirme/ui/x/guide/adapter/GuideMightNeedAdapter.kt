package com.example.fmsspatikabitirme.ui.x.guide.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.fmsspatikabitirme.R
import com.example.fmsspatikabitirme.BR
import com.example.fmsspatikabitirme.databinding.RecyclerRowGuide1Binding
import com.example.fmsspatikabitirme.model.TravelAppModel
import com.example.fmsspatikabitirme.model.TravelModel
import com.example.fmsspatikabitirme.ui.x.guide.GuideFragmentDirections
import com.example.fmsspatikabitirme.ui.x.home.HomeFragmentDirections

class GuideMightNeedAdapter : RecyclerView.Adapter<GuideMightNeedAdapter.GuideMightNeedViewHolder>() {

    private var travelModel: TravelModel = TravelModel()
    private lateinit var binding: RecyclerRowGuide1Binding
    private val mightNeedArray = ArrayList<TravelAppModel>()

    private fun mightNeedCategory(){
        for(mightNeedArrays in travelModel){
            if (mightNeedArrays.category == "mightneed"){
                mightNeedArray.add(mightNeedArrays)
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setDataList(travelModel: TravelModel){
        this.travelModel = travelModel
        notifyDataSetChanged()
        mightNeedCategory()
    }

    class GuideMightNeedViewHolder(private val binding: RecyclerRowGuide1Binding):
    RecyclerView.ViewHolder(binding.root){
        fun bind(travelAppModel: TravelAppModel){
                binding.guideRow1 = travelAppModel
                binding.executePendingBindings()
                binding.setVariable(BR.guideRow1, travelAppModel)
            binding.root.setOnClickListener() { view ->
                val action = GuideFragmentDirections.actionGuideFragmentToDetailsFragment(travelAppModel)
                Navigation.findNavController(view).navigate(action)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuideMightNeedViewHolder {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.recycler_row_guide_1,
            parent, false
        )
        return GuideMightNeedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GuideMightNeedViewHolder, position: Int) {
        holder.bind(mightNeedArray[position])
    }

    override fun getItemCount() = mightNeedArray.size
}
