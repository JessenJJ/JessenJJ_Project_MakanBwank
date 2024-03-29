package com.example.makanbwank2.presentation.dashboard_screen.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.makanbwank2.R
import com.example.makanbwank2.data.response_model.CategoriesDashboard


class CategoriesAdapter(private val context: Context, private val CategoriesData: List<CategoriesDashboard>) : BaseAdapter() {
    private var idCategory: TextView? = null
    private var strCategory: TextView? = null
    private var strCategoryThumb: ImageView? = null
    private var strCategoriesDescription: TextView? = null
    private var layoutInflater: LayoutInflater? = null

    override fun getCount(): Int {
        return CategoriesData.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var bindingView = convertView
        if (layoutInflater == null) {
            layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)
                    as LayoutInflater
        }
        if (bindingView == null) {
            bindingView = layoutInflater?.inflate(R.layout.item_categories_dashboard, null)
        }

        strCategoryThumb = bindingView?.findViewById(R.id.ivCategories)
        strCategory = bindingView?.findViewById(R.id.tvCategories)


        //ini fungsinya untuk mendapatkan data dari list berdasarkan position
        val resultMenu = CategoriesData[position]

        //melakukan sett pada masing2 component di layout
        //image?.setImageResource(resultMenu.image)
        strCategory?.text = resultMenu.strCategory


        return bindingView
    }

}