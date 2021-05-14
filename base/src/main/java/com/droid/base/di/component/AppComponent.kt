package com.droid.base.di.component

import android.content.Context
import com.apollographql.apollo.ApolloClient
import com.droid.base.coroutines.AppCoroutineDispatchers
import com.droid.base.di.module.ApplicationModule
import com.droid.base.networking.NetworkModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, NetworkModule::class])
interface AppComponent {

    fun appCoroutineDispatchers(): AppCoroutineDispatchers
    fun apolloClient(): ApolloClient

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun applicationContext(applicationContext: Context): Builder
        fun build(): AppComponent
    }
}
