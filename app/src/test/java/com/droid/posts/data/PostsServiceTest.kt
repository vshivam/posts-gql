package com.droid.posts.data

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.exception.ApolloException
import com.droid.posts.PostDetailsRawQuery
import com.droid.posts.PostPreviewsRawQuery
import com.droid.posts.common.data.LoadPostDetailsResponse
import com.droid.posts.common.data.LoadPostPreviewsResponse
import com.droid.posts.common.data.PostsService
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

internal class PostsServiceTest {

    private val apolloClient: ApolloClient = mock()

    private val tested = PostsService(apolloClient)

    @Test
    fun `when loading list of post previews throws an exception, return error response `() = runBlocking {
        whenever(apolloClient.query(any<PostPreviewsRawQuery>())).thenThrow(ApolloException("error_message"))

        val actual = tested.loadPosts(1, 20)
        assert(actual is LoadPostPreviewsResponse.Error)
        assertEquals((actual as LoadPostPreviewsResponse.Error).exception.message, "error_message")
    }

    @Test
    fun `when loading details of a post throws an exception, return error response `() =
        runBlocking {
            whenever(apolloClient.query(any<PostDetailsRawQuery>()))
                .thenThrow(ApolloException("error_message"))

            val actual = tested.loadPostDetails("3")
            assert(actual is LoadPostDetailsResponse.Error)
            assertEquals(
                (actual as LoadPostDetailsResponse.Error).exception.message,
                "error_message"
            )
        }
}
