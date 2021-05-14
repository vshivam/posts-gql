package com.droid.posts.di

import com.droid.base.di.annotation.PerActivity
import com.droid.base.di.component.AppComponent
import com.droid.base.di.module.ViewModelFactoryModule
import com.droid.posts.MainActivity
import com.droid.posts.common.di.PostsModule
import dagger.Component

@PerActivity
@Component(
    modules = [
        PostsModule::class,
        PostDetailsViewModelModule::class,
        PostsViewModelModule::class,
        ViewModelFactoryModule::class
    ],
    dependencies = [AppComponent::class]
)

interface MainActivityComponent {
    fun inject(app: MainActivity)
}
