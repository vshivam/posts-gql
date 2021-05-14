package com.droid.posts.common.data

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Error
import com.apollographql.apollo.coroutines.await
import com.apollographql.apollo.exception.ApolloException
import com.droid.posts.PostDetailsRawQuery
import com.droid.posts.PostPreviewsRawQuery
import dagger.Reusable
import javax.inject.Inject

@Reusable
class PostsService @Inject constructor(
    private val apolloClient: ApolloClient,
) {
    suspend fun loadPosts(page: Int, pageSize: Int): LoadPostPreviewsResponse {
        return try {
            apolloClient.query(
                PostPreviewsRawQuery(
                    page = page,
                    limit = pageSize
                )
            ).await().let { rawResponse ->
                if (!rawResponse.hasErrors()) {
                    rawResponse.data?.posts?.let { page ->
                        page.data?.filterNotNull()?.let { listOfRawPosts ->
                            LoadPostPreviewsResponse.Success(
                                listOfRawPosts,
                                page.links?.next?.page
                            )
                        } ?: LoadPostPreviewsResponse.Error(
                            LoadException(
                                DEFAULT_ERR_MSG
                            )
                        )
                    } ?: LoadPostPreviewsResponse.Error(
                        LoadException(
                            DEFAULT_ERR_MSG
                        )
                    )
                } else {
                    LoadPostPreviewsResponse.Error(
                        LoadException(
                            mapErrorsToErrorMessage(
                                rawResponse.errors
                            )
                        )
                    )
                }
            }
        } catch (exception: ApolloException) {

            LoadPostPreviewsResponse.Error(
                LoadException(
                    exception.message ?: DEFAULT_ERR_MSG
                )
            )
        }
    }

    suspend fun loadPostDetails(postId: String): LoadPostDetailsResponse {
        return try {
            apolloClient.query(PostDetailsRawQuery(postId)).await().let { rawResponse ->
                if (!rawResponse.hasErrors()) {
                    rawResponse.data?.post?.let {
                        LoadPostDetailsResponse.Success(it)
                    } ?: LoadPostDetailsResponse.Error(LoadException(DEFAULT_LOAD_DETAILS_ERR_MSG))
                } else {
                    LoadPostDetailsResponse.Error(LoadException(mapErrorsToErrorMessage(rawResponse.errors)))
                }
            }
        } catch (exception: ApolloException) {
            LoadPostDetailsResponse.Error(
                LoadException(exception.message ?: DEFAULT_LOAD_DETAILS_ERR_MSG)
            )
        }
    }

    private fun mapErrorsToErrorMessage(errors: List<Error>?): String =
        errors?.joinToString(ERROR_MSG_SEPARATOR) { error -> error.message }
            ?: DEFAULT_ERR_MSG

    companion object {
        private const val DEFAULT_ERR_MSG = "Failed to load posts"
        private const val DEFAULT_LOAD_DETAILS_ERR_MSG = "Failed to load details"
        private const val ERROR_MSG_SEPARATOR = "\n"
    }
}
