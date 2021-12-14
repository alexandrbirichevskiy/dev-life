package com.alexbirichevskiy.devlife

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.alexbirichevskiy.devlife.databinding.ActivityMainBinding
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ViewPagerAdapter
    private lateinit var dotsIndicator: DotsIndicator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val hotItemFragment = ItemFragment()
        val latestItemFragment = ItemFragment()
        val favoriteItemFragment = FavoriteItemFragment()

        val retrofit = Retrofit().getRetrofit().create(ApiService::class.java)

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.bottom_view_latest -> {
                    val disposable =
                        retrofit.getDataModel("latest").subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread()).subscribe { repos, thr ->
                                adapter = ViewPagerAdapter(this, repos.result)
                                binding.viewPager.adapter = adapter
                                binding.dotsIndicator.setViewPager2(binding.viewPager)
                            }
                    true
                }
                R.id.bottom_view_hot -> {
                    val disposable =
                        retrofit.getDataModel("top").subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread()).subscribe { repos, thr ->
                                adapter = ViewPagerAdapter(this, repos.result)
                                binding.viewPager.adapter = adapter
                                binding.dotsIndicator.setViewPager2(binding.viewPager)
                            }
                    true
                }
                R.id.bottom_view_favorite -> {
                    true
                }

                else -> {
                    val disposable =
                        retrofit.getDataModel("top").subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread()).subscribe { repos, thr ->
                                adapter = ViewPagerAdapter(this, repos.result)
                                binding.viewPager.adapter = adapter
                                binding.dotsIndicator.setViewPager2(binding.viewPager)
                            }
                    true
                }
            }
        }
    }
}