package com.example.makanbwank2.presentation.search_screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.example.makanbwank2.data.response_model.SearchDashboard

import com.example.makanbwank2.databinding.ItemListSearchBinding


class SearchAdapter(

    private val searchData:List<SearchDashboard>
) : RecyclerView.Adapter<SearchAdapter.DashboardViewHolder>() {

    inner class DashboardViewHolder(
        val binding: ItemListSearchBinding

    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(mainModel: SearchDashboard) {
            binding.root.context?.let {
                Glide
                    .with(it)
                    .load(mainModel.strCategoryThumb)
                    .centerCrop()
                    .into(binding.ivSearchFoodImage)
            }
            binding.tvSearchFoodName.text = mainModel.strCategory

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        return DashboardViewHolder(
            ItemListSearchBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = searchData.size

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        holder.bind(searchData[position])

    }
}