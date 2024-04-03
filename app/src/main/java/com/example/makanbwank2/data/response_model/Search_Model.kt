package com.example.makanbwank2.data.response_model
import com.google.gson.annotations.SerializedName

data class SearchDashboardResponseModel (
    @SerializedName("categories")
    val search: List<SearchDashboard>
)


data class SearchDashboard (
    @SerializedName("idCategory")
    val idCategory : String?,
    @SerializedName("strCategory")
    val strCategory: String?,
    @SerializedName("strCategoryThumb")
    val strCategoryThumb: String?,
    @SerializedName("strCategoryDescription")
    val strCategoryDescription: String?
)