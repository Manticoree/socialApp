package com.app.socialapp.room


import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.socialapp.entities.db.ItemCategory
import com.app.socialapp.entities.imdb.ItemMovie

@Database(entities = [ItemMovie::class, ItemCategory::class], version = 2, exportSchema = false)
abstract class MoviesDatabase : RoomDatabase() {
    abstract fun moviesDao(): MoviesDao
    abstract fun categoryDao(): CategoryDao

}