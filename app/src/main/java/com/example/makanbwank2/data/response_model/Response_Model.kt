package com.example.makanbwank2.data.response_model

import android.media.Image
import com.google.gson.annotations.SerializedName

data class CategoriesDashboardResponse (
    @SerializedName("categories")
    val data: List<CategoriesDashboard>?
)


data class CategoriesDashboard (
    @SerializedName("idCategory")
    val idCategory: String?,
    @SerializedName("strCategory")
    val strCategory: String?,
    @SerializedName("strCategoryThumb")
    val strCategoryThumb: String?,
    @SerializedName("strCategoryDescription")
    val strCategoryDescription: String?
)