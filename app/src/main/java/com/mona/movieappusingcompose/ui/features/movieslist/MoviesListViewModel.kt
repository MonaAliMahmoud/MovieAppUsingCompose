package com.mona.movieappusingcompose.ui.features.movieslist

import com.mona.movieappusingcompose.ui.base.BaseViewModel
import com.mona.movieappusingcompose.utils.rx.SchedulerProvider
import javax.inject.Inject

class MoviesListViewModel @Inject constructor(
    repository: MoviesListRepository,
    val schedulerProvider: SchedulerProvider
) : BaseViewModel<MoviesListRepository>(repository, schedulerProvider)