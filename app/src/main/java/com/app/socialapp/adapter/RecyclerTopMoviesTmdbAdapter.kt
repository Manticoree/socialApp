package com.app.socialapp.adapter

import android.content.Context
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.socialapp.R
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem
import eu.davidea.flexibleadapter.items.IFlexible
import eu.davidea.viewholders.FlexibleViewHolder
import kotlinx.android.synthetic.main.item_list_top_movie_in_year.view.*

class RecyclerTopMoviesTmdbAdapter(private val listItemDb: List<TopMoviesTmdbAdapter>) :
        AbstractFlexibleItem<RecyclerTopMoviesTmdbAdapter.RecyclerTopMoviesHolder>() {

    override fun bindViewHolder(
            adapter: FlexibleAdapter<IFlexible<RecyclerView.ViewHolder>>?,
            holder: RecyclerTopMoviesHolder,
            position: Int,
            payloads: MutableList<Any>?
    ) {
        holder.bind(listItemDb)
    }

    override fun equals(other: Any?): Boolean {
        return true
    }

    override fun createViewHolder(
            view: View,
            adapter: FlexibleAdapter<IFlexible<RecyclerView.ViewHolder>>
    ): RecyclerTopMoviesHolder = RecyclerTopMoviesHolder(view, adapter)

    override fun getLayoutRes(): Int = R.layout.item_list_top_movie_in_year

    inner class RecyclerTopMoviesHolder(
            private val view: View,
            adapter: FlexibleAdapter<out IFlexible<*>>
    ) :
            FlexibleViewHolder(view, adapter) {

        fun bind(listItemDb: List<TopMoviesTmdbAdapter>) {
            Log.i("topMoviesT: ", listItemDb.toString())
            showRecyclerView(
                    listItemDb,
                    itemView.rvListSource,
                    view.context
            )
        }
    }

    private fun showRecyclerView(
            initList: List<TopMoviesTmdbAdapter>,
            recView: RecyclerView,
            context: Context
    ) {
        recView.setHasFixedSize(true)
        val manager: RecyclerView.LayoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL,
                false
        )
        recView.layoutManager = manager
        val adapter: FlexibleAdapter<TopMoviesTmdbAdapter> = FlexibleAdapter(initList)
        recView.adapter = adapter
    }

    override fun hashCode(): Int {
        return listItemDb.hashCode()
    }

}