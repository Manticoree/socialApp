package com.app.socialapp.domain.mapper.item

import com.app.socialapp.domain.entities.db.ItemTopMoviesDb
import com.app.socialapp.domain.entities.tmdb.ItemMovie
import javax.inject.Singleton

@Singleton
class ItemTopMapperImpl {

    companion object {
        fun convert(itemRemote: ItemMovie, year: Int): ItemTopMoviesDb = ItemTopMoviesDb(
                itemRemote.vote_average,
                itemRemote.title,
                itemRemote.release_date,
                itemRemote.original_language,
                itemRemote.overview,
                itemRemote.poster_path,
                year
        )
    }

}