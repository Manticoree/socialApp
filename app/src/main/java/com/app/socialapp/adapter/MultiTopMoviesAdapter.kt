package com.app.socialapp.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.socialapp.adapter.factory.topmovies.TopMoviesHolderFactory
import com.app.socialapp.data.entities.ItemManyHolderTopMovies

class MultiTopMoviesAdapter(val data: List<ItemManyHolderTopMovies>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = TopMoviesHolderFactory.crea

    override fun getItemCount(): Int = data.size

    override fun getItemViewType(position: Int): Int = data[position].getItemViewType()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) = data.get(position).onBindViewHolder(holder)

}