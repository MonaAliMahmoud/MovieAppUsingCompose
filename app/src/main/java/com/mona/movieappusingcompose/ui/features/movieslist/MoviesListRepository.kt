package com.mona.movieappusingcompose.ui.features.movieslist

import com.mona.movieappusingcompose.data.local.SharedPrefUtils
import com.mona.movieappusingcompose.ui.base.BaseRepository
import retrofit2.Retrofit
import javax.inject.Inject

class MoviesListRepository @Inject constructor(
    val retrofit: Retrofit,
    val sharedPrefUtils: SharedPrefUtils
) : BaseRepository()