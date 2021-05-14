package com.droid.posts.details.presentation

sealed class PostDetailsViewState {
    object Loading : PostDetailsViewState()
    data class Content(val postDetailsViewEntity: PostDetailsViewEntity) : PostDetailsViewState()
    object Error : PostDetailsViewState()
}

data class PostDetailsViewEntity(
    val userName: String,
    val name: String,
    val postTitle: String,
    val postContent: String
)
