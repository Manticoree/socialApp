package com.app.socialapp.di.modules

import android.content.Context
import androidx.room.Room
import com.app.socialapp.di.ApplicationContext
import com.app.socialapp.di.DatabaseInfo
import com.app.socialapp.room.MoviesDao
import com.app.socialapp.room.MoviesDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule(@ApplicationContext
                 val context: Context) {

    companion object {
        @DatabaseInfo
        const val dbName: String = "social_app.db"
    }

    @Singleton
    @Provides
    fun provideDatabase(): MoviesDatabase {
        return Room.databaseBuilder(
                context,
                MoviesDatabase::class.java,
                dbName
        )
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration().build();
    }

    @Provides
    @DatabaseInfo
    fun provideDatabaseName(): String {
        return dbName
    }

    @Singleton
    @Provides
    fun providesMoviesDao(db: MoviesDatabase): MoviesDao {
        return db.moviesDao()
    }


}