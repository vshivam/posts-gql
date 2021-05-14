package com.droid.posts.details.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.droid.posts.common.presentation.Loading
import com.droid.posts.di.LocalViewModelProviderFactory

@Composable
fun PostDetailsScreen(
    id: String,
    viewModel: PostDetailsViewModel = viewModel(factory = LocalViewModelProviderFactory.current)
) {
    val viewState by viewModel.viewState.observeAsState()
    when (val state = viewState) {
        PostDetailsViewState.Loading -> Loading(modifier = Modifier.fillMaxSize())
        PostDetailsViewState.Error -> Error()
        is PostDetailsViewState.Content -> Content(state.postDetailsViewEntity)
    }

    LaunchedEffect(Unit) {
        viewModel.onLaunched(id)
    }
}

@Composable
private fun Error() {
    // Show some error state here
}

@Composable
private fun Content(viewEntity: PostDetailsViewEntity) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp)
    ) {
        Text(text = viewEntity.postTitle, style = MaterialTheme.typography.body1)
        Text(
            text = "by ${viewEntity.name} (${viewEntity.userName})",
            style = MaterialTheme.typography.caption
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = viewEntity.postContent, style = MaterialTheme.typography.body2)
    }
}
