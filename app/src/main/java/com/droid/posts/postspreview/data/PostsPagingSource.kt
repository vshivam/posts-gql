package com.droid.posts.postspreview.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.droid.posts.PostPreviewsRawQuery
import com.droid.posts.common.data.LoadPostPreviewsResponse
import com.droid.posts.common.data.PostsService

class PostsPagingSource constructor(
    private val postsService: PostsService
) : PagingSource<Int, PostPreviewsRawQuery.Data1>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PostPreviewsRawQuery.Data1> {
        val page = params.key ?: STARTING_PAGE_INDEX
        return when (val postsListResponse = postsService.loadPosts(page, PAGE_SIZE)) {
            is LoadPostPreviewsResponse.Success -> {
                LoadResult.Page(
                    data = postsListResponse.posts,
                    prevKey = if (page == STARTING_PAGE_INDEX) null else page - 1,
                    nextKey = postsListResponse.nextPageIndex
                )
            }
            is LoadPostPreviewsResponse.Error -> {
                LoadResult.Error(postsListResponse.exception)
            }
        }
    }

    override fun getRefreshKey(state: PagingState<Int, PostPreviewsRawQuery.Data1>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    private companion object {
        const val STARTING_PAGE_INDEX = 1
        const val PAGE_SIZE = 20
    }
}
