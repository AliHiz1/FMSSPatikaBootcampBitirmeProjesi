package com.example.fmsspatikabitirme.ui.x.details

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.fragment.navArgs
import com.example.fmsspatikabitirme.R
import com.example.fmsspatikabitirme.databinding.FragmentDetailsBinding
import com.example.fmsspatikabitirme.model.TravelModel

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private val navArgs: DetailsFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_details,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setNavArgs()
    }

    private fun setNavArgs(){
        navArgs.let {
            binding.detailRow = it.detailArg
        }
    }


}