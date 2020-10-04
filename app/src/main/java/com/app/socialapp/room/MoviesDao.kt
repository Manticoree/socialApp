package com.app.socialapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.app.socialapp.entities.ItemNews


@Dao
interface MoviesDao {

    @Query("SELECT* from item_news")
    fun getAll(): List<ItemNews>

    @Query("SELECT* from item_news WHERE idItem = :idItem")
    fun getById(idItem: Long): ItemNews

    @Insert
    fun insert(itemNews: ItemNews)

    @Delete
    fun delete(itemNews: ItemNews)


}