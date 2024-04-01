package com.example.makanbwank2.presentation.search_screen.view
// SplashScreenActivity.kt
import android.view.LayoutInflater
import android.view.ViewGroup
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

    private lateinit var SearchAdapter: SearchAdapter


    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSearchBinding {
        return FragmentSearchBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        viewModel.getSearchMenu()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.searchMenu.observe(viewLifecycleOwner) {
            setupViewMenu(it.search)
        }
    }

    private fun setupViewMenu(data: List<SearchDashboard>) {
//        Toast.makeText(requireContext(), data.toString(), Toast.LENGTH_SHORT).show()
        binding.componentSearchList.rcSearch.adapter = SearchAdapter(data)
        binding.componentSearchList.rcSearch.layoutManager = LinearLayoutManager(
            binding.root.context, LinearLayoutManager.VERTICAL, false
        )


//        binding.componentSearch.gvSearch.adapter = SearchAdapter
//        binding.componentSearch.gvSearch.onItemClickListener =
//            AdapterView.OnItemClickListener { _, _, position, _ ->
//                Toast.makeText(
//                    binding.root.context,
//                    data?.get(position)?.name_Search,
//                    Toast.LENGTH_SHORT
//                ).show()
//            }

//        binding.editText.addOntextChangeListener{
//            val keyword = binding.editText.text.toString()
//            viewModel.getHomeMenu(keyword)
//        }

    }

}
