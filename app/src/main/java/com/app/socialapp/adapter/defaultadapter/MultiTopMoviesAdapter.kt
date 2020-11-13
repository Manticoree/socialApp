package com.app.socialapp.adapter.defaultadapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.socialapp.adapter.defaultadapter.topmovies.TopMoviesHolderFactory
import com.app.socialapp.data.entities.ItemManyHolderTopMovies
import com.app.socialapp.data.entities.tmdb.ItemTopMovies
import com.app.socialapp.data.entities.tmdb.ItemYear

class MultiTopMoviesAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val data: MutableList<ItemManyHolderTopMovies> = mutableListOf()

    fun addMoviesList(moviesList: List<ItemManyHolderTopMovies>) {
        if (data.isNullOrEmpty()) {
            data.addAll(moviesList)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : RecyclerView.ViewHolder {
        return TopMoviesHolderFactory.create(parent, viewType)
    }

    override fun getItemCount(): Int = data.size

    override fun getItemViewType(position: Int): Int = data[position].getItemViewType()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val item = data[position]
        when (getItemViewType(position)) {
            ItemManyHolderTopMovies.ITEM_RECVIEW -> run {
                val recItem: TopMoviesHolderFactory.ItemMovieHolder = holder as TopMoviesHolderFactory.ItemMovieHolder
                recItem.binding.apply {
                    listMovie = item as ItemTopMovies
                    adapterMovies = TopMoviesTmdbAdapter()
                    executePendingBindings()
                }
            }
            ItemManyHolderTopMovies.YEAR_TEXT -> run {
                val yearHolder: TopMoviesHolderFactory.YearViewHolder = holder as TopMoviesHolderFactory.YearViewHolder
                yearHolder.binding.apply {
                    year = item as ItemYear
                    executePendingBindings()
                }
            }
        }
    }

}