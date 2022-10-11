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
import com.example.fmsspatikabitirme.databinding.FragmentHomeTransportationsBinding
import com.example.fmsspatikabitirme.ui.x.home.adapter.HomeAdapter
import com.example.fmsspatikabitirme.ui.x.home.adapter.TransportationAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeTransportationsFragment : Fragment() {
    private lateinit var homeTransportationsBinding: FragmentHomeTransportationsBinding
    private val transportationAdapter = TransportationAdapter()
    private val homeViewModel: HomeViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        homeTransportationsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_home_transportations, container, false)
        return homeTransportationsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }
    private fun init() {
        homeTransportationsBinding.recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        homeTransportationsBinding.recyclerView.adapter = transportationAdapter
        dataObserver()
    }

    private fun dataObserver() {
        homeViewModel.travelData.observe(viewLifecycleOwner) { data ->
            transportationAdapter.setTransportationData(data)
        }

    }
}