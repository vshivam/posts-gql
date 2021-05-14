package com.droid.posts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.droid.base.di.AppComponentProvider
import com.droid.base.di.factory.ViewModelFactory
import com.droid.posts.details.presentation.PostDetailsScreen
import com.droid.posts.di.DaggerMainActivityComponent
import com.droid.posts.di.ProvideViewModelFactory
import com.droid.posts.navigation.LocalNavHostController
import com.droid.posts.navigation.ProvideNavHostController
import com.droid.posts.navigation.Route
import com.droid.posts.postspreview.presentation.PostsPreviewScreen
import com.droid.posts.ui.theme.PostsTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
        setContent {
            PostsTheme {
                ProvideViewModelFactory(viewModelProviderFactory = viewModelFactory) {
                    ProvideNavHostController {
                        NavHost(
                            navController = LocalNavHostController.current,
                            startDestination = Route.posts
                        ) {
                            composable(Route.posts) { PostsPreviewScreen() }
                            composable(
                                Route.PostDetails.template,
                                arguments = Route.PostDetails.navArgs
                            ) {
                                it.arguments?.getString(Route.PostDetails.Args.postId)
                                    ?.also { postId ->
                                        PostDetailsScreen(postId)
                                    }
                            }
                        }
                    }
                }
            }
        }
    }

    private fun inject() {
        DaggerMainActivityComponent
            .builder()
            .appComponent((applicationContext as AppComponentProvider).provideAppComponent())
            .build()
            .inject(this)
    }
}
