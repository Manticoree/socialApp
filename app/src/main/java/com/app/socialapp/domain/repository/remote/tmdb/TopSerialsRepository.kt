package com.app.socialapp.domain.repository.remote.tmdb

import com.app.socialapp.base.MainApplication
import com.app.socialapp.domain.entities.tmdb.ItemTopMovies
import com.app.socialapp.domain.remote.retrofit.ServiceTmdb
import javax.inject.Inject

class TopSerialsRepository {

    @Inject
    lateinit var serviceTmdb: ServiceTmdb

    init {
        MainApplication.applicationComponent.inject(this)
    }

    companion object {
        const val PAGE = 1
        const val PRIMARY_RELEASE = "US"
        const val CERTIFICATION = "R"
        const val API_KEY = "93ab2fe14a1dc7357659e0c56f2b93c4"
    }

    suspend fun getTopSerials(): ItemTopMovies = serviceTmdb.getHighestRatingSerials(
            PRIMARY_RELEASE,
            CERTIFICATION,
            API_KEY,
            PAGE
    )

}