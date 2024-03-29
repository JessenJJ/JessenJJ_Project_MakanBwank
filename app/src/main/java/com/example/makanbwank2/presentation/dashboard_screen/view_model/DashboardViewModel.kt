package com.example.makanbwank2.presentation.dashboard_screen.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.makanbwank2.data.remote.CategoriesDashboardRemoteDataResource
import com.example.makanbwank2.data.response_model.CategoriesDashboardResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

// @HiltViewModel: Ini adalah anotasi yang menandakan bahwa kelas HomeViewModel adalah ViewModel yang akan diinjeksikan oleh Hilt. Ketika Anda menggunakan @HiltViewModel,
// Anda tidak perlu lagi menyediakan ViewModelProvider.Factory
// karena Hilt secara otomatis akan menangani pembuatan instance ViewModel dan menyediakan dependencies yang diperlukan ke dalam konstruktor ViewModel.

// @Inject: Ini adalah anotasi yang menandai konstruktor kelas HomeViewModel. Hilt akan memastikan bahwa instance dari CurrentWeatherRemote akan disediakan dan disuntikkan ke dalam konstruktor HomeViewModel saat membuat instance ViewModel.
@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val categoriesDashboardRemoteDataResource: CategoriesDashboardRemoteDataResource
) : ViewModel() {

    // setter
    private val _categoriesMenu = MutableLiveData<CategoriesDashboardResponse>()
    private val _categoriesMenuError = MutableLiveData<String>()

    // getter
    val categoriesMenu: LiveData<CategoriesDashboardResponse>get() = _categoriesMenu
    val categoriesMenuError: LiveData<String>get() = _categoriesMenuError


    fun getCategoriesMenu() = viewModelScope.launch (Dispatchers.IO) {
        categoriesDashboardRemoteDataResource.getCategoriesDashboard().let{
            if(it.isSuccessful){
                _categoriesMenu.postValue(it.body())
            }else{

                _categoriesMenuError.postValue(it.message())
            }
        }
    }


}