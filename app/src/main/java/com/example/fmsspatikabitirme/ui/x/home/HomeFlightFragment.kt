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
import com.example.fmsspatikabitirme.databinding.FragmentHomeFlightBinding
import com.example.fmsspatikabitirme.ui.x.home.adapter.FlightAdapter
import com.example.fmsspatikabitirme.ui.x.home.adapter.HomeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFlightFragment : Fragment() {

    private lateinit var homeFlightBinding: FragmentHomeFlightBinding
    private val flightAdapter = FlightAdapter()
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        homeFlightBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_home_flight, container, false)
        return homeFlightBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        homeFlightBinding.recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        homeFlightBinding.recyclerView.adapter = flightAdapter
        dataObserver()
    }

    private fun dataObserver() {
        homeViewModel.travelData.observe(viewLifecycleOwner) { data ->
            flightAdapter.setFlightData(data)
        }

    }
}
