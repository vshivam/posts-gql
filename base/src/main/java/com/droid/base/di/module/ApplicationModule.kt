package com.droid.base.di.module

import com.droid.base.coroutines.AppCoroutineDispatchers
import com.droid.base.coroutines.AppCoroutineDispatchersImpl
import dagger.Module
import dagger.Provides

@Module
object ApplicationModule {

    @Provides
    fun provideAppCoroutineDispatchers(
        appCoroutineDispatchersImpl: AppCoroutineDispatchersImpl
    ): AppCoroutineDispatchers = appCoroutineDispatchersImpl
}
