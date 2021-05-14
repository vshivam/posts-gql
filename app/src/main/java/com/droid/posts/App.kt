package com.droid.posts

import android.app.Application
import com.droid.base.di.AppComponentProvider
import com.droid.base.di.component.AppComponent
import com.droid.base.di.component.DaggerAppComponent

class App : Application(), AppComponentProvider {

    private val appComponent: AppComponent by lazy {
        DaggerAppComponent
            .builder()
            .applicationContext(this)
            .build()
    }

    override fun provideAppComponent(): AppComponent = appComponent
}
