package com.app.socialapp.data.local.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.app.socialapp.data.entities.db.ItemMovieDb


@Dao
interface MoviesDao {

    @Query("SELECT* from item_news")
    fun getAll(): List<ItemMovieDb>

    @Query("SELECT* from item_news WHERE idItem = :idItem")
    fun getById(idItem: Long): ItemMovieDb

    @Insert
    fun insert(itemMovieDb: ItemMovieDb)

    @Delete
    fun delete(itemMovieDb: ItemMovieDb)

}