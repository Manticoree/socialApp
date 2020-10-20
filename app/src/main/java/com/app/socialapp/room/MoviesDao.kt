package com.app.socialapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.app.socialapp.entities.imdb.ItemMovie


@Dao
interface MoviesDao {

    @Query("SELECT* from item_news")
    fun getAll(): List<ItemMovie>

    @Query("SELECT* from item_news WHERE idItem = :idItem")
    fun getById(idItem: Long): ItemMovie

    @Insert
    fun insert(itemMovie: ItemMovie)

    @Delete
    fun delete(itemMovie: ItemMovie)


}