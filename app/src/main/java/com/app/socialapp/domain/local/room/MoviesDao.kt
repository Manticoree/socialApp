package com.app.socialapp.domain.local.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.app.socialapp.domain.entities.db.ItemMovieDb
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single


@Dao
interface MoviesDao {

    @Query("SELECT* from item_news")
    fun getAll(): Single<List<ItemMovieDb>>

    @Query("SELECT* from item_news WHERE idItem = :idItem")
    fun getById(idItem: Long): Single<ItemMovieDb>

    @Insert
    fun insert(itemMovieDb: ItemMovieDb): Completable

    @Delete
    fun delete(itemMovieDb: ItemMovieDb): Completable

}