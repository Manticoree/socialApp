package com.app.socialapp.room


import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.socialapp.entities.ItemNews

@Database(entities = [ItemNews::class], version = 1)
abstract class MoviesDatabase : RoomDatabase() {
    abstract fun moviesDao(): MoviesDao

}