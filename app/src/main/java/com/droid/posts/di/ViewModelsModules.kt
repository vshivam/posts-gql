package com.droid.posts.di

import androidx.lifecycle.ViewModel
import com.droid.base.di.annotation.ViewModelKey
import com.droid.posts.details.presentation.PostDetailsViewModel
import com.droid.posts.postspreview.presentation.PostPreviewsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class PostsViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(PostPreviewsViewModel::class)
    abstract fun bindViewModel(viewModel: PostPreviewsViewModel): ViewModel
}

@Module
abstract class PostDetailsViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(PostDetailsViewModel::class)
    abstract fun bindViewModel(viewModel: PostDetailsViewModel): ViewModel
}
