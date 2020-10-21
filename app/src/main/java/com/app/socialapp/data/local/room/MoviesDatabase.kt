package com.app.socialapp.data.local.room


import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.socialapp.data.entities.db.ItemCategory
import com.app.socialapp.data.entities.imdb.ItemMovie

@Database(entities = [ItemMovie::class, ItemCategory::class], version = 2, exportSchema = false)
abstract class MoviesDatabase : RoomDatabase() {
    abstract fun moviesDao(): MoviesDao
    abstract fun categoryDao(): CategoryDao

}