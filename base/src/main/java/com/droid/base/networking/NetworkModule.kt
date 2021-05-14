package com.droid.base.networking

import com.apollographql.apollo.ApolloClient
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object NetworkModule {

    @Singleton
    @Provides
    fun provideApolloClient(): ApolloClient =
        ApolloClient.builder()
            .serverUrl(BASE_URL)
            .build()
}
