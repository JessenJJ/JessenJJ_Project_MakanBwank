package com.example.makanbwank2.presentation.search_screen.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.makanbwank2.data.remote.FeaturedDashboardRemoteDataResource
import com.example.makanbwank2.data.remote.SearchDashboardRemoteDataResource
import com.example.makanbwank2.data.response_model.FeaturedDashboardResponseModel
import com.example.makanbwank2.data.response_model.SearchDashboardResponseModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

// @HiltViewModel: Ini adalah anotasi yang menandakan bahwa kelas HomeViewModel adalah ViewModel yang akan diinjeksikan oleh Hilt. Ketika Anda menggunakan @HiltViewModel,
// Anda tidak perlu lagi menyediakan ViewModelProvider.Factory
// karena Hilt secara otomatis akan menangani pembuatan instance ViewModel dan menyediakan dependencies yang diperlukan ke dalam konstruktor ViewModel.

// @Inject: Ini adalah anotasi yang menandai konstruktor kelas HomeViewModel. Hilt akan memastikan bahwa instance dari CurrentWeatherRemote akan disediakan dan disuntikkan ke dalam konstruktor HomeViewModel saat membuat instance ViewModel.
@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchDashboardRemoteDataResource: SearchDashboardRemoteDataResource,

) : ViewModel() {

    // setter
    private val _searchMenu = MutableLiveData<SearchDashboardResponseModel>()
    private val _searchMenuError = MutableLiveData<String>()

    // getter
    val searchMenu: LiveData<SearchDashboardResponseModel> get() = _searchMenu
    val searchMenuError: LiveData<String> get() = _searchMenuError


    fun getSearchMenu() = viewModelScope.launch(Dispatchers.IO) {
        searchDashboardRemoteDataResource.getSearchDashboard().let {
            if (it.isSuccessful) {
                _searchMenu.postValue(it.body())
            } else {

                _searchMenuError.postValue(it.message())
            }
        }
    }




}