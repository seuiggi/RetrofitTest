package com.seuiggi.retrofittest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.google.android.material.tabs.TabLayoutMediator
import com.seuiggi.retrofittest.adapter.ViewPager2Adapter
import com.seuiggi.retrofittest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }
    private val viewModel: DataViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.apply {
            mainViewPager2.adapter = ViewPager2Adapter(supportFragmentManager, lifecycle)
            mainViewPager2.setPageTransformer(ZoomOutPageTransformer())
            TabLayoutMediator(mainTabLayout, mainViewPager2) { tab, position ->
                when(position) {
                    0 -> tab.text = "Main"
                    1 -> tab.text = "Extended"
                    2 -> tab.text = "Legacy"
                }
            }.attach()
        }
    }
}