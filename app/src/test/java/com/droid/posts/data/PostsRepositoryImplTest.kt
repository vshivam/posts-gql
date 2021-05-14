package com.droid.posts.data

import com.droid.posts.common.data.LoadException
import com.droid.posts.common.data.LoadPostDetailsResponse
import com.droid.posts.common.data.PostDetailsDomainMapper
import com.droid.posts.common.data.PostPreviewDomainMapper
import com.droid.posts.common.data.PostsRepositoryImpl
import com.droid.posts.common.data.PostsService
import com.droid.posts.common.domain.PostDetails
import com.droid.posts.common.domain.User
import com.droid.posts.fake.FakePostDetailsRawData
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

internal class PostsRepositoryImplTest {

    private val postsService: PostsService = mock()
    private val postPreviewDomainMapper: PostPreviewDomainMapper = mock()
    private val postDetailsDomainMapper: PostDetailsDomainMapper = PostDetailsDomainMapper()

    private val tested =
        PostsRepositoryImpl(postsService, postPreviewDomainMapper, postDetailsDomainMapper)

    @Test
    fun `when successfully loaded post details from service, post success response with domain entity`() =
        runBlocking {
            val response = LoadPostDetailsResponse.Success(
                FakePostDetailsRawData.postDetails(
                    "title",
                    "content",
                    FakePostDetailsRawData.userRaw("name", "user_name")
                )
            )

            whenever(postsService.loadPostDetails(any())).thenReturn(response)

            val expected = PostDetails("title", "content", User("user_name", "name"))
            val actual = tested.getPostDetails("4")
            assertEquals(expected, actual)
        }

    @Test
    fun `when failed to load post details from service, post null value`() = runBlocking {
        val response = LoadPostDetailsResponse.Error(LoadException("Failed to load post details"))

        whenever(postsService.loadPostDetails(any())).thenReturn(response)

        val expected = null
        val actual = tested.getPostDetails("4")
        assertEquals(expected, actual)
    }
}
