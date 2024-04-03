
package com.example.makanbwank2.presentation.favorite_screen.view
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.makanbwank2.base.BaseFragment
import com.example.makanbwank2.databinding.FragmentFavoriteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>() {
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFavoriteBinding {
        return FragmentFavoriteBinding.inflate(inflater,container,false)
    }

    override fun setupView() {
        return
    }


}