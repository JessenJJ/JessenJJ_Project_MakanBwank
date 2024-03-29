package com.example.makanbwank2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.makanbwank2.databinding.ActivityHomeBinding
import com.example.makanbwank2.presentation.dashboard_screen.view.DashboardFragment
import com.example.makanbwank2.presentation.favorite_screen.view.FavoriteFragment
import com.example.makanbwank2.presentation.search_screen.view.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeNavigationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

//    private lateinit var confirmationDialogueUtils: ConfirmationDialogueUtils
//    private lateinit var sharePref: SharePrefHelper

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigationSearch -> {
                    replaceFragment(SearchFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigationHome -> {
                    replaceFragment(DashboardFragment())
                    return@OnNavigationItemSelectedListener true
                }

                R.id.navigationFavorite -> {
                    replaceFragment(FavoriteFragment())
                    return@OnNavigationItemSelectedListener true
                }

            }; false

        }


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        sharePref = SharePrefHelper(this)

//        confirmationDialogueUtils = ConfirmationDialogueUtils(this)

        binding.bottomNavigation.setOnNavigationItemSelectedListener(
            onNavigationItemSelectedListener
        )

        if (savedInstanceState == null) {
            binding.bottomNavigation.selectedItemId = R.id.navigationHome
        }

    }

//    private fun showConfirmation() {
//        val title = "Are you sure you want to quit?"
//        val icon = androidx.appcompat.R.drawable.abc_ic_menu_cut_mtrl_alpha
//
//        confirmationDialogueUtils.showConfirmationDialogue(
//            title = title, icon = icon,
//            onConfirm = {
//                sharePref.clearDataPref()
//                finish()
//            },
//            onCancel = {
//
//            }
//
//        )
//
//    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}
