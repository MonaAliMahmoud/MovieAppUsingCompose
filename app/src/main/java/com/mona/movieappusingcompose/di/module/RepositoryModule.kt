package com.mona.movieappusingcompose.di.module

import com.mona.movieappusingcompose.ui.base.BaseRepository
import com.mona.movieappusingcompose.ui.features.movieslist.MoviesListRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindMoviesListRepository(moviesListRepository: MoviesListRepository): BaseRepository
}