package com.droid.posts.common.data

import com.droid.posts.PostDetailsRawQuery
import com.droid.posts.common.domain.PostDetails
import com.droid.posts.common.domain.User
import dagger.Reusable
import javax.inject.Inject

@Reusable
class PostDetailsDomainMapper @Inject constructor() {
    operator fun invoke(postDetailsRaw: PostDetailsRawQuery.Post): PostDetails =
        PostDetails(
            postDetailsRaw.title ?: DEFAULT_TITLE,
            postDetailsRaw.body ?: DEFAULT_BODY,
            User(userName = postDetailsRaw.user!!.username!!, name = postDetailsRaw.user.name!!)
        )

    private companion object {
        const val DEFAULT_TITLE = ""
        const val DEFAULT_BODY = ""
    }
}
