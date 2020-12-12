package com.app.socialapp.domain.local.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.app.socialapp.domain.entities.db.ItemTopMoviesDb
import io.reactivex.rxjava3.core.Completable

@Dao
interface TopMoviesDao {

    @Query("SELECT* from top_movies")
    fun getAll(): List<ItemTopMoviesDb>

    @Query("SELECT* from top_movies WHERE year = :year")
    fun getByYear(year: Int): List<ItemTopMoviesDb>

    @Insert
    fun insert(itemTopMoviesDb: ItemTopMoviesDb): Completable

    @Delete
    fun delete(itemTopMoviesDb: ItemTopMoviesDb)

}