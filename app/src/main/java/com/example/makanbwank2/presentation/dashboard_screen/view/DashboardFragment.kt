package com.example.makanbwank2.presentation.dashboard_screen.view
// SplashScreenActivity.kt
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.fragment.app.viewModels

import com.example.makanbwank2.base.BaseFragment
import com.example.makanbwank2.data.response_model.CategoriesDashboard
import com.example.makanbwank2.databinding.FragmentDashboardBinding
import com.example.makanbwank2.presentation.dashboard_screen.adapter.CategoriesAdapter
import com.example.makanbwank2.presentation.dashboard_screen.view_model.DashboardViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : BaseFragment<FragmentDashboardBinding>() {
    private val viewModel: DashboardViewModel by viewModels()

    private lateinit var categoriesAdapter: CategoriesAdapter
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDashboardBinding {
        return FragmentDashboardBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        viewModel.getCategoriesMenu()
        observeViewModel()
    }
    private fun observeViewModel() {
        viewModel.categoriesMenu.observe(viewLifecycleOwner) {
            setupViewMenu(it.data)
        }
    }

    private fun setupViewMenu(data: List<CategoriesDashboard>?) {
        categoriesAdapter = CategoriesAdapter(
            CategoriesData = data ?: listOf(),
            context = binding.root.context
        )

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

}
