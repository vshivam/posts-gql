package com.droid.posts.data

import androidx.paging.PagingSource
import com.droid.posts.common.data.LoadException
import com.droid.posts.common.data.LoadPostPreviewsResponse
import com.droid.posts.common.data.PostsService
import com.droid.posts.fake.FakePostPreviewRawData
import com.droid.posts.postspreview.data.PostsPagingSource
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

internal class PostsPagingSourceTest {

    private val postsService: PostsService = mock()

    private val tested = PostsPagingSource(postsService)

    @Test
    fun `when posts are loaded successfully from service, return page load result with loaded loaded posts `() =
        runBlocking {
            val postPreviews = listOf(
                FakePostPreviewRawData.postPreview("23", "title", "content"),
                FakePostPreviewRawData.postPreview("24", "title2", "content2")
            )
            val successResponse = LoadPostPreviewsResponse.Success(postPreviews, 3)

            whenever(postsService.loadPosts(any(), any())).thenReturn(successResponse)

            val expected = PagingSource.LoadResult.Page(postPreviews, 1, 3)
            val actual = tested.load(PagingSource.LoadParams.Refresh(2, loadSize = 2, false))
            assertEquals(expected, actual)
        }

    @Test
    fun `when service returns error, return error load result`() = runBlocking {
        val errorResponse = LoadPostPreviewsResponse.Error(LoadException("error_message"))

        whenever(postsService.loadPosts(any(), any())).thenReturn(errorResponse)

        val actual = tested.load(PagingSource.LoadParams.Refresh(2, 2, false))
        assert(actual is PagingSource.LoadResult.Error)
        assertEquals((actual as PagingSource.LoadResult.Error).throwable.message, "error_message")
    }
}
