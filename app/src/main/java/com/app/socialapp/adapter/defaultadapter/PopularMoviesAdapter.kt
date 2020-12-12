package com.app.socialapp.adapter.defaultadapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.app.socialapp.R
import com.app.socialapp.databinding.ItemPopularMoviesTmdbBinding
import com.app.socialapp.domain.entities.tmdb.ItemMovie

class PopularMoviesAdapter : RecyclerView.Adapter<PopularMoviesAdapter.PopularMoviesHolder>() {

    val data: MutableList<ItemMovie> = mutableListOf()

    fun addListItem(item: List<ItemMovie>) {
        if (data.isNullOrEmpty()) {
            data.addAll(item)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMoviesHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemPopularMoviesTmdbBinding>(
                inflater,
                R.layout.item_popular_movies_tmdb,
                parent,
                false
        )
        return PopularMoviesHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: PopularMoviesHolder, position: Int) {
        val item: ItemMovie = data[position]
        Log.i("item ", item.title)
        holder.binding.apply {
            itemMovie = item
            executePendingBindings()
        }
    }

    inner class PopularMoviesHolder(
            val binding: ItemPopularMoviesTmdbBinding
    ) : RecyclerView.ViewHolder(binding.root)

}