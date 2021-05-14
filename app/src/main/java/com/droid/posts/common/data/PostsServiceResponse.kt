package com.droid.posts.common.data

import com.droid.posts.PostDetailsRawQuery
import com.droid.posts.PostPreviewsRawQuery

//region load posts
sealed class LoadPostPreviewsResponse {
    data class Success(val posts: List<PostPreviewsRawQuery.Data1>, val nextPageIndex: Int?) :
        LoadPostPreviewsResponse()

    data class Error(val exception: LoadException) : LoadPostPreviewsResponse()
}

//region load post details
sealed class LoadPostDetailsResponse {
    data class Success(val post: PostDetailsRawQuery.Post) : LoadPostDetailsResponse()
    data class Error(val exception: LoadException) : LoadPostDetailsResponse()
}

class LoadException(override val message: String) : Exception()
