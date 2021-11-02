package com.mona.movieappusingcompose.di.builder

import com.mona.movieappusingcompose.ui.features.movieslist.MoviesListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityFragmentBuilderModule {
    @ContributesAndroidInjector
    abstract fun contributeMoviesList(): MoviesListFragment
}