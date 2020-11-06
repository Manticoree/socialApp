package com.app.socialapp.adapter.defaultadapter.topmovies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.app.socialapp.R
import com.app.socialapp.data.entities.ItemManyHolderTopMovies
import com.app.socialapp.databinding.ItemListTopMovieInYearBinding
import com.app.socialapp.databinding.ItemMoviesTmdbYearProductionBinding


class TopMoviesHolderFactory {

    companion object {
        fun create(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            when (viewType) {
                ItemManyHolderTopMovies.ITEM_RECVIEW -> run {
                    /*
                    val recView: View = LayoutInflater
                            .from(parent.context)
                            .inflate(R.layout.item_list_top_movie_in_year, parent, false)
                    return ItemMovieHolder(recView)
                     */
                    val inflater = LayoutInflater.from(parent.context)
                    val binding =
                            DataBindingUtil.inflate<ItemListTopMovieInYearBinding>(
                                    inflater,
                                    R.layout.item_list_top_movie_in_year,
                                    parent,
                                    false
                            )
                    return ItemMovieHolder(binding)
                }
                ItemManyHolderTopMovies.YEAR_TEXT -> run {
                    val inflater = LayoutInflater.from(parent.context)
                    val binding =
                            DataBindingUtil.inflate<ItemMoviesTmdbYearProductionBinding>(
                                    inflater,
                                    R.layout.item_movies_tmdb_year_production,
                                    parent,
                                    false
                            )
                    return
                }
                else -> {
                    val inflater = LayoutInflater.from(parent.context)
                    val binding =
                            DataBindingUtil.inflate<ItemListTopMovieInYearBinding>(
                                    inflater,
                                    R.layout.item_list_top_movie_in_year,
                                    parent,
                                    false
                            )
                    return
                }

            }
        }
    }

    class YearViewHolder(val binding: ItemMoviesTmdbYearProductionBinding) : RecyclerView.ViewHolder(binding.root)/* {
        fun bind(itemYear: ItemManyHolderTopMovies) {
            val item: ItemYear = itemYear as ItemYear
            itemView.mtvYearProduction.text = item.year.toString()

        }
    }
*/
    class ItemMovieHolder(val binding: ItemListTopMovieInYearBinding) : RecyclerView.ViewHolder(binding.root)
    /*{
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
*/

}