package com.alexbirichevskiy.devlife

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragment: FragmentActivity, private val items: List<Item>) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun createFragment(position: Int): Fragment {
        val fragment = ItemFragment()
        fragment.arguments = Bundle().apply {
            putString("123", items.get(position).author)
            putString("456", items.get(position).description)
            putString("789", items.get(position).gifURL)
        }
        return fragment
    }
}