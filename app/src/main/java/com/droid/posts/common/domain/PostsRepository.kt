package com.droid.posts.common.domain

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

interface PostsRepository {
    fun getPosts(): Flow<PagingData<PostPreview>>

    suspend fun getPostDetails(id: String): PostDetails?
}
