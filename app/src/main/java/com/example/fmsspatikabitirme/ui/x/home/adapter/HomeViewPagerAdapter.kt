package com.example.fmsspatikabitirme.ui.x.home.adapter

import android.annotation.SuppressLint
import android.icu.text.CaseMap.Title
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter


class HomeViewPagerAdapter(manager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(manager, lifecycle) {
    private val mFragmentList = ArrayList<Fragment>()
    var mFragmentTitleList = ArrayList<String>()

    override fun getItemCount(): Int {
        return mFragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return mFragmentList[position]
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addFragment(fragment: Fragment, title: String) {
        this.mFragmentList.add(fragment)
        this.mFragmentTitleList.add(title)
        notifyDataSetChanged()
    }

}