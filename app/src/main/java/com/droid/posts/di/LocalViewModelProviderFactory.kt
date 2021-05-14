package com.droid.posts.di

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.lifecycle.ViewModelProvider

@Composable
fun ProvideViewModelFactory(
    viewModelProviderFactory: ViewModelProvider.Factory,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(LocalViewModelProviderFactory provides viewModelProviderFactory) {
        content()
    }
}

val LocalViewModelProviderFactory = staticCompositionLocalOf<ViewModelProvider.Factory> {
    error("Provide a view model factory")
}
