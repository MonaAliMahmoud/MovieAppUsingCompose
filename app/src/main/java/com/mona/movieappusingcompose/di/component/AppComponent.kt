package com.mona.movieappusingcompose.di.component

import android.app.Application
import com.mona.movieappusingcompose.AppInstance
import com.mona.movieappusingcompose.di.module.ActivityModule
import com.mona.movieappusingcompose.di.module.AppModule
import com.mona.movieappusingcompose.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import com.mona.movieappusingcompose.di.module.ViewModelModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ViewModelModule::class,
        AppModule::class,
        ActivityModule::class,
        NetworkModule::class,
        AndroidSupportInjectionModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        @BindsInstance
        fun baseUrl(url: String): Builder

        fun build(): AppComponent
    }

    fun inject(appInstance: AppInstance)

}