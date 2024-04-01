package com.example.makanbwank2.data.response_model
import com.google.gson.annotations.SerializedName

data class FeaturedDashboardResponseModel (
    @SerializedName("meals")
    val featured: List<FeaturedDashboard>
)


data class FeaturedDashboard (
    @SerializedName("idMeal")
    val idChinese : String?,
    @SerializedName("strMeal")
    val strChinese: String?,
    @SerializedName("strMealThumb")
    val strChineseThumb: String?,
)