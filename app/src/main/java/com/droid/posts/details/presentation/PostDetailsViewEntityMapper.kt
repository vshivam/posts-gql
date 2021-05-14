package com.droid.posts.details.presentation

import com.droid.posts.common.domain.PostDetails
import javax.inject.Inject

class PostDetailsViewEntityMapper @Inject constructor() {
    operator fun invoke(postDetails: PostDetails): PostDetailsViewEntity =
        PostDetailsViewEntity(
            postDetails.user.userName,
            postDetails.user.name,
            postDetails.title,
            postDetails.body
        )
}
