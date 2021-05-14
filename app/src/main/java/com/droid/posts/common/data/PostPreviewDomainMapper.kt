package com.droid.posts.common.data

import com.droid.posts.PostPreviewsRawQuery
import com.droid.posts.common.domain.PostPreview
import dagger.Reusable
import javax.inject.Inject

@Reusable
class PostPreviewDomainMapper @Inject constructor() {
    operator fun invoke(postRaw: PostPreviewsRawQuery.Data1): PostPreview =
        PostPreview(postRaw.id!!, postRaw.title ?: DEFAULT_TITLE, postRaw.body ?: DEFAULT_BODY)

    private companion object {
        const val DEFAULT_TITLE = ""
        const val DEFAULT_BODY = ""
    }
}
