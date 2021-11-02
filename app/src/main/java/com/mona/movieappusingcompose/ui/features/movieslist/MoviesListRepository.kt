package com.mona.movieappusingcompose.ui.features.movieslist

import com.mona.movieappusingcompose.data.local.SharedPrefUtils
import com.mona.movieappusingcompose.data.model.MovieData
import com.mona.movieappusingcompose.data.remote.api.MoviesListApi
import com.mona.movieappusingcompose.ui.base.BaseRepository
import io.reactivex.Single
import retrofit2.Retrofit
import javax.inject.Inject

class MoviesListRepository @Inject constructor(
    val retrofit: Retrofit,
    val sharedPrefUtils: SharedPrefUtils
) : BaseRepository() {

    val moviesListApi = retrofit.create(MoviesListApi::class.java)

    fun getMoviesList(page: Int): Single<MovieData> {
        return moviesListApi.getMoviesList(page = page)
            .flatMap {
                return@flatMap Single.just(it.data)
            }
    }
}