package com.droid.posts.fake

import com.droid.posts.PostPreviewsRawQuery

internal object FakePostPreviewRawData {

    fun postPreview(
        id: String = "id",
        title: String = "title",
        body: String = "body"
    ) = PostPreviewsRawQuery.Data1(id = id, title = title, body = body)
}
