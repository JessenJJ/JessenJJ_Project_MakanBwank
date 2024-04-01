package com.example.makanbwank2.data.remote

import com.example.makanbwank2.data.response_model.SearchDashboardResponseModel
import retrofit2.Response
import javax.inject.Inject

// @Inject -> digunakan untuk menandai konstruktor atau properti yang akan diinjeksi nilainya oleh Dagger (atau framework dependency injection lainnya) saat membuat instance dari kelas yang bersangkutan
class SearchDashboardRemoteDataResourceImpl @Inject constructor(private val serviceSearch: ServiceBwank)


    : SearchDashboardRemoteDataResource {

    // suspend -> Ketika fungsi suspend dipanggil, ia dapat menjalankan proses asinkron tanpa memblok thread secara langsung
    override suspend fun getSearchDashboard(): Response<SearchDashboardResponseModel> {
        return serviceSearch.getSearchMenu()
    }
}