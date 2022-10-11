package com.example.fmsspatikabitirme.ui.x.trip

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.example.fmsspatikabitirme.R
import com.example.fmsspatikabitirme.core.TripPlanManager
import com.example.fmsspatikabitirme.databinding.FragmentAddTripBinding
import com.example.fmsspatikabitirme.databinding.FragmentTripBinding
import com.example.fmsspatikabitirme.databinding.RecyclerRowTripBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AddTripFragment : Fragment() {

    private lateinit var binding: FragmentAddTripBinding
    private lateinit var tripBinding: RecyclerRowTripBinding
    var addNameArray =  ArrayList<String>()
    var addLocArray =  ArrayList<String>()

    @Inject
    lateinit var deeplinkTrip: TripPlanManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAddTripBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ellipse4.setOnClickListener{
            val action = AddTripFragmentDirections.actionAddTripFragmentToTripFragment()
            findNavController().navigate(action)
            //addNewTrip()
            val tripLoc = deeplinkTrip.setDeeplinkTripLoc(binding.addTripDate.text.toString())
            val tripName = deeplinkTrip.setDeeplinkTripName(binding.addTripName.text.toString())
            addNameArray.add(tripName.toString())
            addLocArray.add(tripLoc.toString())

            deeplinkTrip.getDeeplinkTripName()?.let { Log.d("deeplinklog", it) }
        }




    }

    fun selectImageClicked(){

    }

    /*
    fun addNewTrip(){
        val insertedText1 = binding.addTripName.text.toString()
        tripBinding.tripText1.text = insertedText1
        val insertedText2 = binding.addTripDate.text.toString()
        tripBinding.tripText2.text = insertedText2

        val appContext = requireContext().applicationContext
        var prefs = appContext.getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        var editor = prefs.edit()
        editor.apply {
            putString("STRING_KEY",insertedText1)
            putString("STRING_KEY",insertedText2)
        }.apply()
    }

     */
}