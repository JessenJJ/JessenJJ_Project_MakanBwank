package com.example.makanbwank2.presentation.dashboard_screen.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.makanbwank2.data.remote.CategoriesDashboardRemoteDataResource
import com.example.makanbwank2.data.remote.FeaturedDashboardRemoteDataResource
import com.example.makanbwank2.data.response_model.CategoriesDashboardResponseModel
import com.example.makanbwank2.data.response_model.FeaturedDashboardResponseModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

// @HiltViewModel: Ini adalah anotasi yang menandakan bahwa kelas HomeViewModel adalah ViewModel yang akan diinjeksikan oleh Hilt. Ketika Anda menggunakan @HiltViewModel,
// Anda tidak perlu lagi menyediakan ViewModelProvider.Factory
// karena Hilt secara otomatis akan menangani pembuatan instance ViewModel dan menyediakan dependencies yang diperlukan ke dalam konstruktor ViewModel.

// @Inject: Ini adalah anotasi yang menandai konstruktor kelas HomeViewModel. Hilt akan memastikan bahwa instance dari CurrentWeatherRemote akan disediakan dan disuntikkan ke dalam konstruktor HomeViewModel saat membuat instance ViewModel.
@HiltViewModel
class FeaturedViewModel @Inject constructor(

    private val featuredDashboardRemoteDataResource: FeaturedDashboardRemoteDataResource
) : ViewModel() {

    // setter for featured
    private val _featuredMenu = MutableLiveData<FeaturedDashboardResponseModel>()
    private val _featuredMenuError = MutableLiveData<String>()

    // getter for featured
    val featuredMenu: LiveData<FeaturedDashboardResponseModel> get() = _featuredMenu
    val featuredMenuError: LiveData<String> get() = _featuredMenuError


    fun getFeaturedMenu() = viewModelScope.launch(Dispatchers.IO) {
        featuredDashboardRemoteDataResource.getFeaturedDashboard().let {
            if (it.isSuccessful) {
                _featuredMenu.postValue(it.body())
            } else {

                _featuredMenuError.postValue(it.message())
            }
        }
    }


}