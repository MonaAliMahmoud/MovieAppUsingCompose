package com.mona.movieappusingcompose.di.module

import androidx.lifecycle.ViewModel
import com.mona.movieappusingcompose.ui.features.movieslist.MoviesListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.mona.movieappusingcompose.di.helper.ViewModelKey

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MoviesListViewModel::class)
    abstract fun bindMoviesListViewModel(moviesListViewModel: MoviesListViewModel): ViewModel
}


