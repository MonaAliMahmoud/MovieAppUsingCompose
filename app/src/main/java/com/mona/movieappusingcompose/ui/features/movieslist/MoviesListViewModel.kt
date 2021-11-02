package com.mona.movieappusingcompose.ui.features.movieslist

import com.mona.movieappusingcompose.ui.base.BaseViewModel
import com.mona.movieappusingcompose.ui.base.ViewState
import com.mona.movieappusingcompose.utils.rx.SchedulerProvider
import io.reactivex.functions.Consumer
import javax.inject.Inject

class MoviesListViewModel @Inject constructor(
    repository: MoviesListRepository,
    private val schedulerProvider: SchedulerProvider
) : BaseViewModel<MoviesListRepository>(repository, schedulerProvider){

    fun getMoviesList() {
        internalState.value = ViewState.NetworkAvailable
        subscribe(repository.getMoviesList(1),
            Consumer {
                internalState.value = MoviesListViewState.MoviesListData(it)
            })
    }
}