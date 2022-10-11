package com.example.fmsspatikabitirme.ui.x.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fmsspatikabitirme.R
import com.example.fmsspatikabitirme.databinding.FragmentSearchListBinding
import com.example.fmsspatikabitirme.model.TravelModel
import com.example.fmsspatikabitirme.ui.x.search.adapter.SearchListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchListFragment : Fragment() {

    private lateinit var binding: FragmentSearchListBinding
    private val searchListAdapter = SearchListAdapter()
    private val searchViewModel: SearchViewModel by viewModels()
    private val travelModel : TravelModel = TravelModel()
    private val navArgs : SearchListFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_search_list, container, false)
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
                searchListAdapter.setSearchList(search, searchText.argSearch)
            }
        }
    }

}