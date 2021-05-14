package com.droid.posts.common.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.droid.posts.common.domain.PostDetails
import com.droid.posts.common.domain.PostPreview
import com.droid.posts.common.domain.PostsRepository
import com.droid.posts.postspreview.data.PostsPagingSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PostsRepositoryImpl @Inject constructor(
    private val postsService: PostsService,
    private val postPreviewDomainMapper: PostPreviewDomainMapper,
    private val postDetailsDomainMapper: PostDetailsDomainMapper
) : PostsRepository {

    override fun getPosts(): Flow<PagingData<PostPreview>> {
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                enablePlaceholders = false,
                maxSize = MAX_SIZE
            ),
            pagingSourceFactory = { PostsPagingSource(postsService) }
        ).flow.map { pagingData -> pagingData.map { postPreviewDomainMapper(it) } }
    }

    override suspend fun getPostDetails(id: String): PostDetails? {
        return when (val response = postsService.loadPostDetails(id)) {
            is LoadPostDetailsResponse.Success -> postDetailsDomainMapper(response.post)
            is LoadPostDetailsResponse.Error -> null
        }
    }

    companion object {
        const val PAGE_SIZE = 20
        const val MAX_SIZE = 100
    }
}
