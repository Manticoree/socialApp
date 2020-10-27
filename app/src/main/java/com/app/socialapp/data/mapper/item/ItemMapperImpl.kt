package com.app.socialapp.data.mapper.item

import com.app.socialapp.data.entities.db.ItemMovieDb
import com.app.socialapp.data.entities.imdb.ItemMovieImdb

import javax.inject.Singleton

@Singleton
class ItemMapperImpl {

    fun convert(itemRemote: ItemMovieImdb): ItemMovieDb = ItemMovieDb(
            1,
            itemRemote.title,
            itemRemote.year,
            itemRemote.rated,
            itemRemote.released,
            itemRemote.runtime,
            itemRemote.genre,
            itemRemote.director,
            itemRemote.writer,
            itemRemote.actors,
            itemRemote.plot,
            itemRemote.language,
            itemRemote.country,
            itemRemote.awards,
            itemRemote.poster
    )

}