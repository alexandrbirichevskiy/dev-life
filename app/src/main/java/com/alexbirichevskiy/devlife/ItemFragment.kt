package com.alexbirichevskiy.devlife

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import com.alexbirichevskiy.devlife.databinding.FragmentItemBinding
import com.bumptech.glide.Glide

class ItemFragment : Fragment() {

    private var _binding: FragmentItemBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.authorTextView.text = arguments?.getString("123")
        binding.descriptionTextView.text = arguments?.getString("456")
        Glide.with(this).load(arguments?.getString("789")).into(binding.gifImageView)

        val drawRed = resources.getDrawable(R.drawable.ic_baseline_favorite_red_24)
        val drawBord = resources.getDrawable(R.drawable.ic_baseline_favorite_border_24)
        binding.favoriteImageView.setOnClickListener {
            if (it.background == drawRed) {
                it.background = drawBord
            } else {
                it.background = drawRed
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}