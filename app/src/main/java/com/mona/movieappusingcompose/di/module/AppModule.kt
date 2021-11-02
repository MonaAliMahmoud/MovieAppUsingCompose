package com.mona.movieappusingcompose.di.module

import android.app.Application
import android.content.Context
import com.mona.movieappusingcompose.data.local.SharedPrefUtils
import com.mona.movieappusingcompose.utils.LocalHelper
import com.mona.movieappusingcompose.utils.rx.SchedulerProvider
import com.mona.movieappusingcompose.utils.rx.SchedulerProviderImp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    fun provideContext(application: Application) = LocalHelper.onAttach(application.baseContext)

    @Provides
    @Singleton
    internal fun provideSchedulerProvider(schedulerProviderImp: SchedulerProviderImp): SchedulerProvider =
        schedulerProviderImp

    @Provides
    fun provideSharedPref(context: Context) = SharedPrefUtils(context)
}