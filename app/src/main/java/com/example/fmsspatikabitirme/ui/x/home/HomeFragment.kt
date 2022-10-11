package com.example.fmsspatikabitirme.ui.x.home

import android.annotation.SuppressLint
import android.content.ClipData.Item
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.fmsspatikabitirme.MainActivity
import com.example.fmsspatikabitirme.R
import com.example.fmsspatikabitirme.databinding.FragmentHomeBinding
import com.example.fmsspatikabitirme.model.TravelModel
import com.example.fmsspatikabitirme.ui.x.details.DetailsFragment
import com.example.fmsspatikabitirme.ui.x.details.DetailsViewModel
import com.example.fmsspatikabitirme.ui.x.home.adapter.*
import com.example.fmsspatikabitirme.ui.x.trip.TripFragment
import com.example.fmsspatikabitirme.ui.x.trip.TripTab1Fragment
import com.example.fmsspatikabitirme.ui.x.trip.TripTab2Fragment
import com.example.fmsspatikabitirme.ui.x.trip.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlin.coroutines.Continuation

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var homeBinding: FragmentHomeBinding
    private var concatAdapter = ConcatAdapter()
    private val homeAdapter = HomeAdapter()
    private val flightAdapter = FlightAdapter()
    private val hotelAdapter = HotelAdapter()
    private lateinit var homeViewPagerAdapter: HomeViewPagerAdapter
    private val transportationAdapter = TransportationAdapter()
    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var viewPagerAdapter: HomeViewPagerAdapter
    private lateinit var tabLayout: TabLayout
    private lateinit var homeViewPager: ViewPager2
    private val titleArray = ArrayList<String>()

    companion object {
        fun newInstance(): HomeFragment {
            val fragmentHome = HomeFragment()
            val args = Bundle()
            fragmentHome.arguments = args
            return fragmentHome
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
        homeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        return homeBinding.root
    }

    private fun init(){
        homeViewPager = homeBinding.viewpager2
    }

    private fun setupViewPager() {
        homeViewPagerAdapter = HomeViewPagerAdapter(childFragmentManager, lifecycle)
        homeViewPagerAdapter.addFragment(HomeAllFragment(), "All")
        homeViewPagerAdapter.addFragment(HomeFlightFragment(),"Flight")
        homeViewPagerAdapter.addFragment(HomeHotelFragment(),"Hotel")
        homeViewPagerAdapter.addFragment(HomeTransportationsFragment(),"Transportation")

        homeViewPager.adapter = homeViewPagerAdapter
        homeBinding.viewpager2.isUserInputEnabled = false

        tabLayout = homeBinding.tabLayout

        TabLayoutMediator(homeBinding.tabLayout, homeViewPager){ tab, position ->
            tab.text = homeViewPagerAdapter.mFragmentTitleList[position]
        }.attach()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        setupViewPager()
        //init()
        /*
        homeBinding.dealAdBan.findViewById<View>(R.id.deal_ads).setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment()
            Navigation.findNavController(it).navigate(action)
        }

         */

    }

    /*
    private fun init(){
        homeBinding.dealAdBan.layoutManager =
            LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        homeBinding.dealAdBan.adapter = homeAdapter


        dataObserver()
        concatAdapter()
        flightObserver()
        hotelObserver()
        transportationObserver()

        homeBinding.bannerButt1a.setOnClickListener {
            Toast.makeText(context,"You just clicked the Flight Button",Toast.LENGTH_SHORT).show()
        }
        homeBinding.bannerButt2a.setOnClickListener {
            Toast.makeText(context,"You just clicked the Hotels Button",Toast.LENGTH_SHORT).show()
        }
        homeBinding.bannerButt3a.setOnClickListener {
            Toast.makeText(context,"You just clicked the Cars Button",Toast.LENGTH_SHORT).show()
        }
        homeBinding.bannerButt4a.setOnClickListener {
            Toast.makeText(context,"You just clicked the Taxi Button",Toast.LENGTH_SHORT  ).show()
        }
    }

    @SuppressLint("NotifyDataSetChanged", "Range")
    private fun dataObserver(){
        homeViewModel.travelData.observe(viewLifecycleOwner){  data ->
            homeAdapter.setDataList(data)
            homeBinding.button.setOnClickListener{
                concatAdapter.addAdapter(homeAdapter)
                concatAdapter.removeAdapter(transportationAdapter)
                concatAdapter.removeAdapter(hotelAdapter)
                concatAdapter.removeAdapter(flightAdapter)
                concatAdapter.notifyDataSetChanged()
                val allTxt = homeBinding.all
                allTxt.setTextColor(Color.parseColor("#FF4760"))
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun flightObserver(){
        homeBinding.button2.setOnClickListener {
            homeViewModel.travelData.observe(viewLifecycleOwner){ flight ->
                flightAdapter.setFlightData(flight)
                concatAdapter.addAdapter(flightAdapter)
                concatAdapter.removeAdapter(transportationAdapter)
                concatAdapter.removeAdapter(hotelAdapter)
                concatAdapter.removeAdapter(homeAdapter)
                concatAdapter.notifyDataSetChanged()
                val flightTxt = homeBinding.flights
                flightTxt.setTextColor(Color.parseColor("#FF4760"))

            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun hotelObserver(){
        homeBinding.button3.setOnClickListener {
            homeViewModel.travelData.observe(viewLifecycleOwner){ hotel ->
                hotelAdapter.setHotelData(hotel)
                concatAdapter.addAdapter(hotelAdapter)
                concatAdapter.removeAdapter(transportationAdapter)
                concatAdapter.removeAdapter(flightAdapter)
                concatAdapter.removeAdapter(homeAdapter)
                concatAdapter.notifyDataSetChanged()
                val hotelTxt = homeBinding.hotels
                hotelTxt.setTextColor(Color.parseColor("#FF4760"))

            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun transportationObserver(){
        homeBinding.button4.setOnClickListener {
            homeViewModel.travelData.observe(viewLifecycleOwner){ transport ->
                transportationAdapter.setTransportationData(transport)
                concatAdapter.addAdapter(transportationAdapter)
                concatAdapter.removeAdapter(hotelAdapter)
                concatAdapter.removeAdapter(flightAdapter)
                concatAdapter.removeAdapter(homeAdapter)
                concatAdapter.notifyDataSetChanged()
                val transportationsTxt = homeBinding.transport
                transportationsTxt.setTextColor(Color.parseColor("#FF4760"))

            }
        }
    }

    private fun concatAdapter(){
        concatAdapter = ConcatAdapter(
            homeAdapter
        )
        homeBinding.dealAdBan.adapter = concatAdapter
    }

    private fun showDetails(travelModel: TravelModel){
    }

     */


}