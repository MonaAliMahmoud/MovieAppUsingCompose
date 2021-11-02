package com.mona.movieappusingcompose

import android.content.Context
import android.content.res.Configuration
import androidx.multidex.MultiDexApplication
import com.mona.movieappusingcompose.di.helper.AppInjector
import com.mona.movieappusingcompose.utils.LocalHelper
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject


class AppInstance : MultiDexApplication(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>


    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)
    }


    override fun androidInjector() = androidInjector

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        LocalHelper.onAttach(context = this)
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(
            LocalHelper.onAttach(
                context = base
            )
        )
    }
}