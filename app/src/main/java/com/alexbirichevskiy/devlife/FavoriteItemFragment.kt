package com.alexbirichevskiy.devlife

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alexbirichevskiy.devlife.databinding.FragmentFavoriteItemBinding
import com.alexbirichevskiy.devlife.databinding.FragmentItemBinding

class FavoriteItemFragment : Fragment() {

    private var _binding: FragmentFavoriteItemBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoriteItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}