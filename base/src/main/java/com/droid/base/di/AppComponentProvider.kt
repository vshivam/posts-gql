package com.droid.base.di

import com.droid.base.di.component.AppComponent

interface AppComponentProvider {
    fun provideAppComponent(): AppComponent
}
