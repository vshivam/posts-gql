package com.droid.posts.postspreview.presentation

import com.droid.posts.common.domain.PostPreview
import dagger.Reusable
import javax.inject.Inject

@Reusable
class PostPreviewViewEntityMapper @Inject constructor() {
    operator fun invoke(postPreview: PostPreview): PostPreviewViewEntity =
        PostPreviewViewEntity(
            id = postPreview.id,
            title = postPreview.title,
            preview = postPreview.body.take(MAX_PREVIEW_LENGTH)
        )

    companion object {
        const val MAX_PREVIEW_LENGTH = 120
    }
}
