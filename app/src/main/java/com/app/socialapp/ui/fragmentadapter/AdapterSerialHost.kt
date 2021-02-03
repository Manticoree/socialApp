package com.app.socialapp.ui.fragmentadapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.app.socialapp.mvvm.serials.fragment.topserial.TopSerialFragment

class AdapterSerialHost(fm: FragmentManager, behaviour: Int) : FragmentPagerAdapter(fm, behaviour) {

    companion object {
        const val PAGE_COUNT = 1
        val tabTitles: Array<String> = arrayOf("Топ сериалов")
    }

    override fun getCount(): Int {
        return PAGE_COUNT
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                TopSerialFragment.newInstance(position)
            }
            else -> {
                TopSerialFragment.newInstance(position)
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return tabTitles[position]
    }
}