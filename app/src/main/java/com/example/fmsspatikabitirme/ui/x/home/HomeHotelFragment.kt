package com.example.fmsspatikabitirme.ui.x.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fmsspatikabitirme.R
import com.example.fmsspatikabitirme.databinding.FragmentHomeHotelBinding
import com.example.fmsspatikabitirme.ui.x.home.adapter.HotelAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeHotelFragment : Fragment() {
    private lateinit var homeHotelBinding: FragmentHomeHotelBinding
    private val hotelAdapter = HotelAdapter()
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        homeHotelBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_home_hotel, container, false)
        return homeHotelBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        homeHotelBinding.recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        homeHotelBinding.recyclerView.adapter = hotelAdapter
        dataObserver()
    }

    private fun dataObserver() {
        homeViewModel.travelData.observe(viewLifecycleOwner) { data ->
            hotelAdapter.setHotelData(data)
        }
    }
}