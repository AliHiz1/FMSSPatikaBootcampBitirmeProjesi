package com.example.fmsspatikabitirme.ui.x.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fmsspatikabitirme.R
import com.example.fmsspatikabitirme.databinding.FragmentHomeAllBinding
import com.example.fmsspatikabitirme.ui.x.home.adapter.HomeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeAllFragment : Fragment() {

    private lateinit var homeAllBinding: FragmentHomeAllBinding
    private val homeAdapter = HomeAdapter()
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        homeAllBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_home_all, container, false)
        return homeAllBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        homeAllBinding.recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        homeAllBinding.recyclerView.adapter = homeAdapter
        dataObserver()
    }

    private fun dataObserver() {
        homeViewModel.travelData.observe(viewLifecycleOwner) { data ->
            homeAdapter.setDataList(data)
        }


    }
}