package com.example.makanbwank2.presentation.dashboard_screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.makanbwank2.data.response_model.FeaturedDashboard
import com.example.makanbwank2.databinding.ItemFeaturedDashboardBinding


class FeaturedAdapter(

    private val featuredData:List<FeaturedDashboard>
) : RecyclerView.Adapter<FeaturedAdapter.DashboardViewHolder>() {

    inner class DashboardViewHolder(
        val binding: ItemFeaturedDashboardBinding

    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(mainModel: FeaturedDashboard) {
            binding.root.context?.let {
                Glide
                    .with(it)
                    .load(mainModel.strChineseThumb)
                    .centerCrop()
                    .into(binding.ivFeatured)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        return DashboardViewHolder(
            ItemFeaturedDashboardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = featuredData.size

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        holder.bind(featuredData[position])

    }
}