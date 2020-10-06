package com.app.socialapp.mvp.fragmentadapter

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.app.socialapp.mvp.ui.moviefragment.MovieViewFragment

class AdapterSocial(fm: FragmentManager, behavior: Int) : FragmentPagerAdapter(fm, behavior) {
    companion object {
        const val PAGE_COUNT = 1;
        val tabTitles: Array<String> = arrayOf("Фильмы")
    }


    override fun getItem(position: Int): Fragment {
        Log.i("LifecycleFragmentShowM", "loadInstance")
        return MovieViewFragment.newInstance(position)
    }

    override fun getCount(): Int {
        return PAGE_COUNT
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return tabTitles[position]
    }
}