package com.app.socialapp.mvp.fragmentadapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.app.socialapp.mvp.ui.fragment.movie.ListMovieFragment
import com.app.socialapp.mvp.ui.fragment.mycategories.MyCategoriesFragment

class AdapterHost(fm: FragmentManager, behavior: Int) : FragmentPagerAdapter(fm, behavior) {
    companion object {
        const val PAGE_COUNT = 2
        val tabTitles: Array<String> = arrayOf("Фильмы", "Мои подборки")

    }


    override fun getItem(position: Int): Fragment {
        return if (position == 0) {
            ListMovieFragment.newInstance(position)
        } else {
            MyCategoriesFragment.newInstance(position)
        }
    }

    override fun getCount(): Int {
        return PAGE_COUNT
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return tabTitles[position]
    }
}