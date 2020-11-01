package com.seuiggi.retrofittest.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.seuiggi.retrofittest.fragment.ExtendedListFragment
import com.seuiggi.retrofittest.fragment.LegacyListFragment
import com.seuiggi.retrofittest.fragment.MainListFragment

class ViewPager2Adapter(fm: FragmentManager, lc: Lifecycle) : FragmentStateAdapter(fm, lc) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> MainListFragment()
            1 -> ExtendedListFragment()
            2 -> LegacyListFragment()
            else -> Fragment()
        }
    }

}