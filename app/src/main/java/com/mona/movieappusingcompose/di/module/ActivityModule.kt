package com.mona.movieappusingcompose.di.module

import com.mona.movieappusingcompose.MainActivity
import com.mona.movieappusingcompose.di.builder.MainActivityFragmentBuilderModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [MainActivityFragmentBuilderModule::class])
    abstract fun contributeSplashActivity(): MainActivity
}