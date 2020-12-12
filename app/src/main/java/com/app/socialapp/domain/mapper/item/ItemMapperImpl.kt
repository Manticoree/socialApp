package com.app.socialapp.domain.mapper.item

import com.app.socialapp.domain.entities.db.ItemMovieDb
import com.app.socialapp.domain.entities.imdb.ItemMovieImdb
import java.util.*
import javax.inject.Singleton

@Singleton
class ItemMapperImpl {

    companion object {
        fun convert(itemRemote: ItemMovieImdb): ItemMovieDb = ItemMovieDb(
                UUID.randomUUID().toString(),
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

}