package com.example.fmsspatikabitirme.ui.x.trip

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fmsspatikabitirme.R
import com.example.fmsspatikabitirme.databinding.FragmentTripTab1Binding
import com.example.fmsspatikabitirme.ui.x.trip.adapter.TripAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TripTab1Fragment : Fragment() {

    private lateinit var tripTab1Binding: FragmentTripTab1Binding
    private val tripAdapter = TripAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        tripTab1Binding = DataBindingUtil.inflate(inflater,R.layout.fragment_trip_tab1,container,false)
        return tripTab1Binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init(){
        tripTab1Binding.triprecyclerview1.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        tripTab1Binding.triprecyclerview1.adapter = tripAdapter
    }

}
