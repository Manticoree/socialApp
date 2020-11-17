package com.app.socialapp.mvp.fragmentadapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.app.socialapp.mvp.ui.fragment.movie.ListMovieFragment
import com.app.socialapp.mvp.ui.fragment.mycategories.MyCategoriesFragment
import com.app.socialapp.mvvm.popularmovies.PopularMoviesFragment
import com.app.socialapp.mvvm.topmovies.TopMoviesFragment

class AdapterHost(fm: FragmentManager, behavior: Int) : FragmentPagerAdapter(fm, behavior) {

    companion object {
        const val PAGE_COUNT = 4
        val tabTitles: Array<String> = arrayOf("Мои Фильмы", "Мои подборки", "Топ фильмов", "Популярные фильмы")

    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                ListMovieFragment.newInstance(position)
            }
            1 -> {
                MyCategoriesFragment.newInstance(position)
            }
            2 -> {
                TopMoviesFragment.newInstance(position)
            }
            else -> {
                PopularMoviesFragment.newInstance(position)
            }
        }
    }

    override fun getCount(): Int {
        return PAGE_COUNT
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return tabTitles[position]
    }
}