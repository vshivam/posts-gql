package com.droid.posts.common.di

import com.droid.posts.common.data.PostsRepositoryImpl
import com.droid.posts.common.domain.PostsRepository
import dagger.Binds
import dagger.Module

@Module
abstract class PostsModule {

    @Binds
    abstract fun providePostsRepository(postsRepositoryImpl: PostsRepositoryImpl): PostsRepository
}
