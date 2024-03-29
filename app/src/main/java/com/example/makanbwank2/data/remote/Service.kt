package com.example.makanbwank2.data.remote


import com.example.makanbwank2.data.response_model.CategoriesDashboardResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {
    // suspend -> Ketika fungsi suspend dipanggil, ia dapat menjalankan proses asinkron tanpa memblok thread secara langsung
    @GET("api/json/v1/1/categories.php")
    suspend fun getHomeMenu() : Response<CategoriesDashboardResponse>

//    @GET("api/json/v1/1/search.php")
//    suspend fun getDetail(@Query("s") query: String)
}