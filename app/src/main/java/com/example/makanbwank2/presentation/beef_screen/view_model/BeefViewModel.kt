package com.example.makanbwank2.presentation.beef_screen.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.makanbwank2.data.remote.BeefDashboardRemoteDataResource
import com.example.makanbwank2.data.response_model.BeefResponseModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

// @HiltViewModel: Ini adalah anotasi yang menandakan bahwa kelas HomeViewModel adalah ViewModel yang akan diinjeksikan oleh Hilt. Ketika Anda menggunakan @HiltViewModel, Anda tidak perlu lagi menyediakan ViewModelProvider.Factory karena Hilt secara otomatis akan menangani pembuatan instance ViewModel dan menyediakan dependencies yang diperlukan ke dalam konstruktor ViewModel.

// @Inject: Ini adalah anotasi yang menandai konstruktor kelas HomeViewModel. Hilt akan memastikan bahwa instance dari CurrentWeatherRemote akan disediakan dan disuntikkan ke dalam konstruktor HomeViewModel saat membuat instance ViewModel.

@HiltViewModel
class BeefViewModel @Inject constructor(
    private val beefRemoteDatasource: BeefDashboardRemoteDataResource
): ViewModel() {

    // setter
    private val _beef= MutableLiveData<BeefResponseModel>()
    private val _beefError = MutableLiveData<String>()
    // getter
    val beef: LiveData<BeefResponseModel>
        get() = _beef


    val beefError: LiveData<String>
        get() = _beefError


    fun getBeef() = viewModelScope.launch(Dispatchers.IO){
        beefRemoteDatasource.getBeefDashboard().let {
            if (it.isSuccessful){
                _beef.postValue(it.body())
            } else{
                _beefError.postValue(it.message())
            }
        }
    }

}