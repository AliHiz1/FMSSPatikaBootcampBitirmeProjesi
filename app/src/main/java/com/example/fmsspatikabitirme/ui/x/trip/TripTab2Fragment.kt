package com.example.fmsspatikabitirme.ui.x.trip

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.fmsspatikabitirme.R
import com.example.fmsspatikabitirme.databinding.FragmentTripTab2Binding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TripTab2Fragment : Fragment() {
    private lateinit var tripTab2Binding: FragmentTripTab2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        tripTab2Binding = DataBindingUtil.inflate(inflater,R.layout.fragment_trip_tab2,container,false)
        return tripTab2Binding.root
    }


}