package com.mona.movieappusingcompose.ui.features.movieslist

import com.mona.movieappusingcompose.data.model.MovieData
import com.mona.movieappusingcompose.ui.base.ViewState

class MoviesListViewState : ViewState() {
    data class MoviesListData(val movieData: MovieData) :
        ViewState.Loaded<MovieData>(movieData)
}