package com.example.makanbwank2.data.remote

import com.example.makanbwank2.data.response_model.BeefResponseModel
import retrofit2.Response

interface BeefDashboardRemoteDataResource {
    // suspend -> Ketika fungsi suspend dipanggil, ia dapat menjalankan proses asinkron tanpa memblok thread secara langsung
    suspend fun getBeefDashboard() : Response<BeefResponseModel>

}