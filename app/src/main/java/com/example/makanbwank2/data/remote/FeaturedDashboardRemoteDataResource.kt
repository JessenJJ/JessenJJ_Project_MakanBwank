package com.example.makanbwank2.data.remote



import com.example.makanbwank2.data.response_model.FeaturedDashboardResponseModel
import retrofit2.Response

interface FeaturedDashboardRemoteDataResource {
    // suspend -> Ketika fungsi suspend dipanggil, ia dapat menjalankan proses asinkron tanpa memblok thread secara langsung
    suspend fun getFeaturedDashboard() : Response<FeaturedDashboardResponseModel>

}