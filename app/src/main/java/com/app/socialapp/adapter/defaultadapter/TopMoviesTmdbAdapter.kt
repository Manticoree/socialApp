package com.app.socialapp.adapter.defaultadapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.app.socialapp.R
import com.app.socialapp.adapter.TopMoviesBase
import com.app.socialapp.databinding.ItemMoviesTmdbBinding
import com.app.socialapp.domain.entities.tmdb.ItemMovie
import com.app.socialapp.mvp.ui.host.fragment.movies.HostMoviesFragmentDirections

class TopMoviesTmdbAdapter :
        RecyclerView.Adapter<TopMoviesTmdbAdapter.MoviesHolder>(), TopMoviesBase {

    val data: MutableList<ItemMovie> = mutableListOf()

    fun addListItem(item: List<ItemMovie>) {
        data.forEach {
            Log.i("dataItem: ", it.toString())
        }

        if (data.isNullOrEmpty()) {
            data.addAll(item)
            notifyDataSetChanged()
        }
    }

    companion object {
        const val tmdbImageUrl = "https://image.tmdb.org/t/p/w500"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding =
                DataBindingUtil.inflate<ItemMoviesTmdbBinding>(
                        inflater,
                        R.layout.item_movies_tmdb,
                        parent,
                        false
                )
        return MoviesHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MoviesHolder, position: Int) {
        val item: ItemMovie = data[position]
        item.title?.let {
            Log.i("item ", it)
        }
        holder.binding.apply {
            itemMovie = item
            executePendingBindings()
            root.setOnClickListener {
                val action = HostMoviesFragmentDirections
                        .actionListmovieToMovie(item)
                it.findNavController().navigate(action)
            }
        }
    }

    inner class MoviesHolder(
            val binding: ItemMoviesTmdbBinding
    ) : RecyclerView.ViewHolder(binding.root)

}