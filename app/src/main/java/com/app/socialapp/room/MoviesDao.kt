package com.app.socialapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.app.socialapp.entities.ItemNews
import io.reactivex.rxjava3.core.Single

@Dao
interface MoviesDao {

    @Query("SELECT* FROM ItemNews")
    fun getAll(): Single<List<ItemNews>>

    @Query("SELECT* FROM ItemNews WHERE idItem = :idItem")
    fun getById(idItem: Long): Single<ItemNews>

    @Insert
    fun insert(itemNews: ItemNews)

    @Delete
    fun delete(itemNews: ItemNews)


}