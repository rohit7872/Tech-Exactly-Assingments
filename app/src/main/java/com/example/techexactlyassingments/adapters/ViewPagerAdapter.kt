package com.example.techexactlyassingments.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.techexactlyassingments.views.fragments.ApplicationsListFragment
import com.example.techexactlyassingments.views.fragments.SettingsFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ApplicationsListFragment()
            1 -> SettingsFragment()
            else -> throw IllegalStateException("Unexpected position $position")
        }
    }
}
