package com.example.fmsspatikabitirme.ui.x.guide

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fmsspatikabitirme.R
import com.example.fmsspatikabitirme.databinding.FragmentGuideSearchBinding
import com.example.fmsspatikabitirme.databinding.FragmentSearchListBinding
import com.example.fmsspatikabitirme.model.TravelModel
import com.example.fmsspatikabitirme.ui.x.guide.adapter.GuideSearchAdapter
import com.example.fmsspatikabitirme.ui.x.search.SearchListFragmentArgs
import com.example.fmsspatikabitirme.ui.x.search.SearchViewModel
import com.example.fmsspatikabitirme.ui.x.search.adapter.SearchListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GuideSearchFragment : Fragment() {
    private lateinit var binding: FragmentGuideSearchBinding
    private val searchListAdapter = GuideSearchAdapter()
    private val searchViewModel: GuideViewModel by viewModels()
    private val travelModel : TravelModel = TravelModel()
    private val navArgs : GuideSearchFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_guide_search, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        setSearchList()
    }
    fun init() {
        binding.recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.adapter = searchListAdapter
    }

    private fun setSearchList(){
        searchViewModel.travelData.observe(viewLifecycleOwner){ search ->
            navArgs.let { searchText ->
                searchListAdapter.setSearchList(search, searchText.searchArgG)
            }
        }
    }

}