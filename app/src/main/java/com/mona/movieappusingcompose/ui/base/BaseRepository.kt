package com.mona.movieappusingcompose.ui.base

import com.mona.movieappusingcompose.data.local.SharedPrefUtils
import javax.inject.Inject

abstract class BaseRepository {
    @Inject
    lateinit var localDataSource: SharedPrefUtils
}