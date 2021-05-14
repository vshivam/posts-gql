package com.droid.posts.presentation

import com.droid.posts.common.domain.PostDetails
import com.droid.posts.common.domain.PostsRepository
import com.droid.posts.common.domain.User
import com.droid.posts.details.presentation.PostDetailsViewEntity
import com.droid.posts.details.presentation.PostDetailsViewEntityMapper
import com.droid.posts.details.presentation.PostDetailsViewModel
import com.droid.posts.details.presentation.PostDetailsViewState
import com.droid.posts.fake.FakeCoroutineDispatchers
import com.droid.test.core.CoroutinesExtension
import com.droid.test.core.InstantTask
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@InstantTask
@CoroutinesExtension
class PostDetailsViewModelTest {

    private val postsRepository: PostsRepository = mock()
    private val appCoroutineDispatchers = FakeCoroutineDispatchers()
    private val postDetailsViewEntityMapper = PostDetailsViewEntityMapper()

    private val tested =
        PostDetailsViewModel(postsRepository, appCoroutineDispatchers, postDetailsViewEntityMapper)

    @Test
    fun `initial state posted to the state live data should be loading`() {
        assertEquals(tested.viewState.value, PostDetailsViewState.Loading)
    }

    @Test
    fun `when post details are successfully loaded from repository, post content to live data`() =
        runBlocking {
            whenever(postsRepository.getPostDetails(any())).thenReturn(
                PostDetails(
                    "post_title",
                    "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. " +
                        "Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque " +
                        "penatibus et magnis dis p",
                    User("Vishy", "Vishwanathan Anand")
                )
            )

            tested.onLaunched("5")

            val expected =
                PostDetailsViewState.Content(
                    PostDetailsViewEntity(
                        "Vishy",
                        "Vishwanathan Anand",
                        "post_title",
                        "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. " +
                            "Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque " +
                            "penatibus et magnis dis p"
                    )
                )
            val actual = tested.viewState.value
            assertEquals(expected, actual)
        }

    @Test
    fun `when post details are null, post error state to live data`() = runBlocking {
        whenever(postsRepository.getPostDetails(any())).thenReturn(null)

        tested.onLaunched("45")

        val expected = PostDetailsViewState.Error
        val actual = tested.viewState.value
        assertEquals(expected, actual)
    }
}
