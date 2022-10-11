package com.example.fmsspatikabitirme.ui.x.guide

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fmsspatikabitirme.R
import com.example.fmsspatikabitirme.databinding.FragmentGuideBinding
import com.example.fmsspatikabitirme.ui.x.guide.adapter.GuideCategoriesAdapter
import com.example.fmsspatikabitirme.ui.x.guide.adapter.GuideMightNeedAdapter
import com.example.fmsspatikabitirme.ui.x.guide.adapter.GuideTopPickAdapter
import com.example.fmsspatikabitirme.ui.x.search.SearchFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GuideFragment : Fragment() {

    private lateinit var guideBinding: FragmentGuideBinding
    private val guideMightNeedAdapter = GuideMightNeedAdapter()
    private val guideCategoriesAdapter = GuideCategoriesAdapter()
    private val guideTopPickAdapter = GuideTopPickAdapter()
    private val guideViewModel: GuideViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        guideBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_guide,container,false)
        return guideBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        searchResults()
    }

    private fun init(){
        guideBinding.guideRecyclerView1.layoutManager =
            LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        guideBinding.guideRecyclerView1.adapter = guideMightNeedAdapter

        guideBinding.guideRecyclerView2.layoutManager =
            LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        guideBinding.guideRecyclerView2.adapter = guideCategoriesAdapter

        guideBinding.guideRecyclerView3.layoutManager =
            LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        guideBinding.guideRecyclerView3.adapter = guideTopPickAdapter
        dataObserver()
    }
    private fun dataObserver(){
        guideViewModel.travelData.observe(viewLifecycleOwner){ data ->
            guideMightNeedAdapter.setDataList(data)
        }
        guideViewModel.travelData.observe(viewLifecycleOwner) { data ->
            guideTopPickAdapter.setDataList(data)
        }
        guideViewModel.guideData.observe(viewLifecycleOwner){ data ->
            guideCategoriesAdapter.setGuideDataList(data)
        }
    }

    private fun searchResults(){
        guideBinding.searchBar.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                guideBinding.searchBar.setOnEditorActionListener { v, actionId, event ->
                    if (actionId != EditorInfo.IME_ACTION_DONE){
                        val searchText = s.toString()
                        val action = GuideFragmentDirections.actionGuideFragmentToGuideSearchFragment(searchText)
                        findNavController().navigate(action)
                        //println("alii" + searchText)
                        true
                    }else{
                        false
                    }
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })
    }

}