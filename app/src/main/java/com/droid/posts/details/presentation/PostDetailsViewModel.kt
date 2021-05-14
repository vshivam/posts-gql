package com.droid.posts.details.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droid.base.coroutines.AppCoroutineDispatchers
import com.droid.posts.common.domain.PostsRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class PostDetailsViewModel @Inject constructor(
    private val postsRepository: PostsRepository,
    private val appCoroutineDispatchers: AppCoroutineDispatchers,
    private val postDetailsViewEntityMapper: PostDetailsViewEntityMapper,
) : ViewModel() {

    internal val viewState = MutableLiveData<PostDetailsViewState>(PostDetailsViewState.Loading)

    fun onLaunched(id: String) {
        viewModelScope.launch(appCoroutineDispatchers.default()) {
            viewState.postValue(
                postsRepository.getPostDetails(id)
                    ?.let { PostDetailsViewState.Content(postDetailsViewEntityMapper(it)) }
                    ?: PostDetailsViewState.Error
            )
        }
    }
}
