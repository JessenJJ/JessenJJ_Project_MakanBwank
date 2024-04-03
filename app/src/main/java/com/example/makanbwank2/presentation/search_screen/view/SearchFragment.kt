package com.example.makanbwank2.presentation.search_screen.view
// SplashScreenActivity.kt
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.makanbwank2.R
import com.example.makanbwank2.base.BaseFragment
import com.example.makanbwank2.data.response_model.SearchDashboard
import com.example.makanbwank2.databinding.FragmentDashboardBinding
import com.example.makanbwank2.databinding.FragmentSearchBinding
import com.example.makanbwank2.presentation.dashboard_screen.view_model.DashboardViewModel
import com.example.makanbwank2.presentation.search_screen.adapter.SearchAdapter
import com.example.makanbwank2.presentation.search_screen.view_model.SearchViewModel
import com.example.makanbwank2.utils.HorizontalItemDecoration
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding>() {
    private val viewModel: SearchViewModel by viewModels()

    private lateinit var searchAdapter: SearchAdapter


    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSearchBinding {
        return FragmentSearchBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        viewModel.getSearchMenu()
        observeViewModel()
        setupSearchBar() // New line to initialize search bar
    }

    private fun observeViewModel() {
        viewModel.searchMenu.observe(viewLifecycleOwner) {
            setupViewMenu(it.search)
        }
    }

    private fun setupViewMenu(data: List<SearchDashboard>) {
        searchAdapter = SearchAdapter(data)
//        Toast.makeText(requireContext(), data.toString(), Toast.LENGTH_SHORT).show()
        binding.componentSearchList.rcSearch.adapter = SearchAdapter(data)
        binding.componentSearchList.rcSearch.layoutManager = LinearLayoutManager(
            binding.root.context, LinearLayoutManager.VERTICAL, false
        )

//        binding.cvSearchContainer.addOntextChangeListener{
//            val keyword = binding.etSearchInput.text.toString()
//            viewModel.getHomeMenu(keyword)
//        }


//        binding.componentSearch.gvSearch.adapter = SearchAdapter
//        binding.componentSearch.gvSearch.onItemClickListener =
//            AdapterView.OnItemClickListener { _, _, position, _ ->
//                Toast.makeText(
//                    binding.root.context,
//                    data?.get(position)?.name_Search,
//                    Toast.LENGTH_SHORT
//                ).show()
//            }



    }
    private fun setupSearchBar() {
        val searchBar = binding.componentSearchBar.cvSearchContainer // Assuming search bar reference
        searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    searchAdapter.filterData(newText.trim()) // Filter data on text change
                }
                return true
            }
        })
    }

}
