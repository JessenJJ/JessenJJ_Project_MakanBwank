package com.example.makanbwank2.presentation.dashboard_screen.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.makanbwank2.base.BaseFragment
import com.example.makanbwank2.data.response_model.CategoriesDashboard
import com.example.makanbwank2.data.response_model.FeaturedDashboard
import com.example.makanbwank2.databinding.FragmentDashboardBinding
import com.example.makanbwank2.presentation.dashboard_screen.adapter.CategoriesAdapter
import com.example.makanbwank2.presentation.dashboard_screen.adapter.FeaturedAdapter
import com.example.makanbwank2.presentation.dashboard_screen.view_model.DashboardViewModel
import com.example.makanbwank2.presentation.dashboard_screen.view_model.FeaturedViewModel
import dagger.hilt.android.AndroidEntryPoint

// SplashScreenActivity.kt


@AndroidEntryPoint
class DashboardFragment : BaseFragment<FragmentDashboardBinding>() {
    private val viewModel: DashboardViewModel by viewModels()
    private val viewModel2: FeaturedViewModel by viewModels()


    private lateinit var categoriesAdapter: CategoriesAdapter
    private lateinit var featuredAdapter: FeaturedAdapter
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDashboardBinding {
        return FragmentDashboardBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        viewModel.getCategoriesMenu()
        viewModel2.getFeaturedMenu()
        observeViewModel1()
        observeViewModel2()
    }

    private fun observeViewModel1() {
        viewModel.categoriesMenu.observe(viewLifecycleOwner) {
            setupCategoriesViewMenu(it.categories)
        }

    }
    private fun observeViewModel2() {
        viewModel2.featuredMenu.observe(viewLifecycleOwner) {
            setupFeaturedViewMenu(it.featured)
        }
    }



    private fun setupCategoriesViewMenu(data: List<CategoriesDashboard>) {
//        Toast.makeText(requireContext(), data.toString(), Toast.LENGTH_SHORT).show()
        binding.componentCategories.gvCategories.adapter = CategoriesAdapter(data)

//        binding.componentCategories.gvCategories.adapter = CategoriesAdapter
//        binding.componentCategories.gvCategories.onItemClickListener =
//            AdapterView.OnItemClickListener { _, _, position, _ ->
//                Toast.makeText(
//                    binding.root.context,
//                    data?.get(position)?.name_Categories,
//                    Toast.LENGTH_SHORT
//                ).show()
//            }

//        binding.editText.addOntextChangeListener{
//            val keyword = binding.editText.text.toString()
//            viewModel.getHomeMenu(keyword)
//        }

    }
    private fun setupFeaturedViewMenu(data2: List<FeaturedDashboard>) {
        binding.componentFeatured.rvFeaturedRecycle.adapter = FeaturedAdapter(data2)
    }

}
