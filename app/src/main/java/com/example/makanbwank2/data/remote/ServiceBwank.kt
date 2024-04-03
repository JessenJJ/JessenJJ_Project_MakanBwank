package com.example.makanbwank2.data.remote

import com.example.makanbwank2.data.response_model.BeefResponseModel
import com.example.makanbwank2.data.response_model.CategoriesDashboardResponseModel
import com.example.makanbwank2.data.response_model.FeaturedDashboardResponseModel
import com.example.makanbwank2.data.response_model.SearchDashboardResponseModel

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceBwank {
    // suspend -> Ketika fungsi suspend dipanggil, ia dapat menjalankan proses asinkron tanpa memblok thread secara langsung
    @GET("api/json/v1/1/categories.php")
    suspend fun getCategoriesMenu(): Response<CategoriesDashboardResponseModel>
    @GET("api/json/v1/1/filter.php?a=Chinese")
    suspend fun getFeaturedMenu(): Response<FeaturedDashboardResponseModel>

    @GET("api/json/v1/1/categories.php")
    suspend fun getSearchMenu(): Response<SearchDashboardResponseModel>

    @GET("/api/json/v1/1/search.php?s=Massaman")
    suspend fun getBeef() : Response<BeefResponseModel>
//    @GET("api/json/v1/1/search.php")
//    suspend fun getDetail(@Query("s") query: String)
}