package com.example.fmsspatikabitirme.ui.x.search

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
import com.example.fmsspatikabitirme.databinding.FragmentSearchBinding
import com.example.fmsspatikabitirme.ui.x.search.adapter.SearchNearAttAdapter
import com.example.fmsspatikabitirme.ui.x.search.adapter.SearchTopDesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private lateinit var searchBinding: FragmentSearchBinding
    private val searchTopDesAdapter = SearchTopDesAdapter()
    private val searchNearAttAdapter = SearchNearAttAdapter()
    private val searchViewModel: SearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        searchBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false)
        return searchBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        searchResults()
    }

    private fun init(){
        searchBinding.searchRecyclerView1.layoutManager =
            LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false)
        searchBinding.searchRecyclerView1.adapter = searchTopDesAdapter

        searchBinding.searchRecyclerView2.layoutManager =
            LinearLayoutManager(context,LinearLayoutManager.VERTICAL, false)
        searchBinding.searchRecyclerView2.adapter = searchNearAttAdapter
        dataObserver()
    }

    private fun dataObserver(){
        searchViewModel.travelData.observe(viewLifecycleOwner){ data ->
            searchTopDesAdapter.setDataList(data)
            searchNearAttAdapter.setDataList(data)
        }
    }

    private fun searchResults(){
        searchBinding.frame8.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                searchBinding.frame8.setOnEditorActionListener { v, actionId, event ->
                    if (actionId != EditorInfo.IME_ACTION_DONE){
                        val searchText = s.toString()
                        val action = SearchFragmentDirections.actionSearchFragmentToSearchListFragment(searchText)
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