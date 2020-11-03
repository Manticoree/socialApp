package com.app.socialapp.adapter.factory.topmovies

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.socialapp.R
import com.app.socialapp.adapter.TopMoviesTmdbAdapter
import com.app.socialapp.data.entities.ItemManyHolderTopMovies
import com.app.socialapp.data.entities.tmdb.ItemYear
import eu.davidea.flexibleadapter.FlexibleAdapter
import kotlinx.android.synthetic.main.item_list_top_movie_in_year.view.*
import kotlinx.android.synthetic.main.item_movies_tmdb_year_production.view.*


class TopMoviesHolderFactory {

    companion object {
        fun create(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            when (viewType) {
                ItemManyHolderTopMovies.ITEM_RECVIEW -> run {
                    val recView: View = LayoutInflater.from(parent.context).inflate(R.layout.item_list_top_movie_in_year, parent, false)
                    return ItemMovieHolder(recView)
                }
                ItemManyHolderTopMovies.YEAR_TEXT -> run {
                    return
                }
            }

        }
    }

    private class YearViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(itemYear: ItemManyHolderTopMovies) {
            val item: ItemYear = itemYear as ItemYear
            itemView.mtvYearProduction.text = item.year.toString()

        }
    }

    private class ItemMovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(listItemDb: List<TopMoviesTmdbAdapter>) {
            Log.i("topMoviesT: ", listItemDb.toString())
            showRecyclerView(
                    listItemDb,
                    itemView.rvListSource,
                    itemView.context
            )
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
    }


}