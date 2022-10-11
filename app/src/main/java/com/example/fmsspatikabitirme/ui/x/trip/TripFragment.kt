package com.example.fmsspatikabitirme.ui.x.trip

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.example.fmsspatikabitirme.databinding.FragmentTripBinding
import com.example.fmsspatikabitirme.ui.x.trip.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TripFragment : Fragment() {
    private lateinit var binding: FragmentTripBinding
    private lateinit var tabLayout: TabLayout
    private lateinit var firstViewPager: ViewPager
    private lateinit var addTripFragment: AddTripFragment


    companion object {
        fun newInstance(): TripFragment {
            val fragmentTrip = TripFragment()
            val args = Bundle()
            fragmentTrip.arguments = args
            return fragmentTrip
        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentTripBinding.inflate(layoutInflater)
        firstViewPager = binding.viewpager1

        tabLayout = binding.tabLayout
        tabLayout.setupWithViewPager(firstViewPager)

        setupViewPager(firstViewPager)
        return binding.root
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(childFragmentManager)
        adapter.addFragment(TripTab1Fragment(), "Trips")
        adapter.addFragment(TripTab2Fragment(), "Bookmarks")
        viewPager.adapter = adapter
    }

    @SuppressLint("CommitPrefEdits")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ellipse4.setOnClickListener{
            val action = TripFragmentDirections.actionTripFragmentToAddTripFragment()
            findNavController().navigate(action)
        }

    }

    /*
    fun setupViewPager(viewPager: ViewPager){
        val viewPager = binding.viewpager1
        val tabLayout = binding.tabLayout
        tabLayout.addTab(tabLayout.newTab().setText("Trips"))
        tabLayout.addTab(tabLayout.newTab().setText("Bookmarks"))

        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        val adapter = ViewPagerAdapter(this,supportFragmentManager,
            tabLayout.tabCount)
        viewPager.adapter = adapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }

     */





}