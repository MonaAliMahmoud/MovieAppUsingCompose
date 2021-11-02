package com.mona.movieappusingcompose.di.helper

import com.mona.movieappusingcompose.AppInstance
import com.mona.movieappusingcompose.BuildConfig
import com.mona.movieappusingcompose.di.component.AppComponent
import com.mona.movieappusingcompose.di.component.DaggerAppComponent
import com.mona.movieappusingcompose.utils.MyLifecycleHandler

object AppInjector {

    lateinit var appComponent: AppComponent

    fun init(appInstance: AppInstance) {
        appComponent = DaggerAppComponent.builder()
            .application(appInstance)
            .baseUrl(BuildConfig.BASE_URL)
            .build()


        appComponent.inject(appInstance)

        appInstance.registerActivityLifecycleCallbacks(MyLifecycleHandler())
    }

}
