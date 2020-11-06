package com.app.socialapp.adapter.defaultadapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.socialapp.adapter.defaultadapter.topmovies.TopMoviesHolderFactory
import com.app.socialapp.data.entities.ItemManyHolderTopMovies

class MultiTopMoviesAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val data: MutableList<ItemManyHolderTopMovies> = mutableListOf()

    fun addMoviesList(moviesList: List<ItemManyHolderTopMovies>) {
        data.addAll(moviesList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : RecyclerView.ViewHolder = TopMoviesHolderFactory.create(parent, viewType)

    override fun getItemCount(): Int = data.size

    override fun getItemViewType(position: Int): Int = data[position].getItemViewType()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) = data[position].onBindViewHolder(holder)

}