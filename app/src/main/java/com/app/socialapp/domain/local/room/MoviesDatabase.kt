package com.app.socialapp.domain.local.room


import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.socialapp.domain.entities.db.ItemCategory
import com.app.socialapp.domain.entities.db.ItemMovieDb
import com.app.socialapp.domain.entities.db.ItemTopMoviesDb

@Database(entities = [ItemMovieDb::class, ItemCategory::class, ItemTopMoviesDb::class], version = 5, exportSchema = false)
abstract class MoviesDatabase : RoomDatabase() {

    abstract fun moviesDao(): MoviesDao
    abstract fun categoryDao(): CategoryDao
    abstract fun topMoviesDao(): TopMoviesDao

}