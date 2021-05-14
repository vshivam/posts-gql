package com.droid.posts.postspreview.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.droid.posts.common.domain.PostsRepository
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PostPreviewsViewModel @Inject constructor(
    postsRepository: PostsRepository,
    postPreviewViewEntityMapper: PostPreviewViewEntityMapper
) : ViewModel() {

    internal val posts by lazy {
        postsRepository.getPosts()
            .map { it.map { postDomain -> postPreviewViewEntityMapper(postDomain) } }
            .cachedIn(viewModelScope)
    }
}
