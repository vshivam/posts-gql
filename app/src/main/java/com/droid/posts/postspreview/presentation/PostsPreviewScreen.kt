package com.droid.posts.postspreview.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.droid.posts.common.presentation.Loading
import com.droid.posts.di.LocalViewModelProviderFactory
import com.droid.posts.navigation.LocalNavHostController
import com.droid.posts.navigation.Route
import com.droid.posts.ui.theme.Typography

// There is a bug in compose: https://issuetracker.google.com/issues/177245496 which fails to
// remember the scroll state here when coming back from the PostDetailsScreen

@Composable
fun PostsPreviewScreen(
    viewModel: PostPreviewsViewModel = viewModel(factory = LocalViewModelProviderFactory.current)
) {
    val navController: NavHostController = LocalNavHostController.current
    val lazyPagingItems = viewModel.posts.collectAsLazyPagingItems()

    if (lazyPagingItems.loadState.refresh == LoadState.Loading) {
        Loading(Modifier.fillMaxSize())
    }

    LazyColumn {
        items(lazyPagingItems) { post ->
            post?.let {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .clickable { navController.navigate(Route.PostDetails.buildUri(post.id)) }
                ) {
                    Text(
                        it.title,
                        style = MaterialTheme.typography.body1
                    )
                    Text(it.preview, style = MaterialTheme.typography.body2)
                    Divider(modifier = Modifier.padding(4.dp))
                }
            }
        }
    }
}
