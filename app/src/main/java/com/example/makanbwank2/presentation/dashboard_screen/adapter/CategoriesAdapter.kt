package com.example.makanbwank2.presentation.dashboard_screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.makanbwank2.data.response_model.CategoriesDashboard
import com.example.makanbwank2.databinding.ItemCategoriesDashboardBinding


class CategoriesAdapter(

    private val categoriesData: List<CategoriesDashboard>,
    private val itemClickListener: OnBeefCategoriesClickListener
) : RecyclerView.Adapter<CategoriesAdapter.DashboardViewHolder>() {

    inner class DashboardViewHolder(
        val binding: ItemCategoriesDashboardBinding

    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(mainModel: CategoriesDashboard) {
            binding.root.context?.let {
                Glide
                    .with(it)
                    .load(mainModel.strCategoryThumb)
                    .centerCrop()
                    .into(binding.ivCategories)
            }
            binding.tvCategories.text = mainModel.strCategory
            binding.tvDescription.text = mainModel.strCategoryDescription

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        return DashboardViewHolder(
            ItemCategoriesDashboardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = categoriesData.size

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        val currentItem = categoriesData[position]
        holder.bind(categoriesData[position])

        holder.bind(currentItem)

        holder.itemView.setOnClickListener{
            itemClickListener.onItemClick(currentItem)
        }




    }
    interface OnBeefCategoriesClickListener{
        fun onItemClick(categories: CategoriesDashboard)
    }

}