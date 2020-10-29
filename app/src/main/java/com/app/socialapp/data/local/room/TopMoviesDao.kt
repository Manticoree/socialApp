package com.app.socialapp.data.local.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.app.socialapp.data.entities.db.TopMoviesDb

@Dao
interface TopMoviesDao {

    @Query("SELECT* from top_movies")
    fun getAll(): List<TopMoviesDb>

    @Query("SELECT* from top_movies WHERE year = :year")
    fun getByYear(year: Int): TopMoviesDb

    @Insert
    fun insert(topMoviesDb: TopMoviesDb)

    @Delete
    fun delete(topMoviesDb: TopMoviesDb)

}