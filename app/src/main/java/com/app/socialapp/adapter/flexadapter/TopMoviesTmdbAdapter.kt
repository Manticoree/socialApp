package com.app.socialapp.adapter.flexadapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.socialapp.adapter.TopMoviesBase
import com.app.socialapp.data.entities.tmdb.ItemMovie
import com.app.socialapp.databinding.ItemMoviesTmdbBinding

class TopMoviesTmdbAdapter :
        RecyclerView.Adapter<TopMoviesTmdbAdapter.MoviesHolder>(), TopMoviesBase {

    val data: MutableList<ItemMovie> = mutableListOf()

    fun addListItem(item: MutableList<ItemMovie>) {
        data.addAll(item)
        notifyDataSetChanged()
    }

    companion object {
        const val tmdbImageUrl = "https://image.tmdb.org/t/p/w500"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MoviesHolder, position: Int) {
        TODO("Not yet implemented")
    }

    inner class MoviesHolder(
            val binding: ItemMoviesTmdbBinding
    ) : RecyclerView.ViewHolder(binding.root)
    /*
             {

        fun bind(item: ItemMovie) {

            Glide.with(view)
                    .load(tmdbImageUrl + item.poster_path)
                    .error(view.context.getDrawable(R.drawable.ic_no_photography_24))
                    .into(itemView.sivMoviePoster)

            itemView.mtvTitleMovies.text = item.title
            itemView.mtvYear.text = item.release_date
            itemView.mtvLanguageMovies.text = item.original_language
        }

    }
*/
}