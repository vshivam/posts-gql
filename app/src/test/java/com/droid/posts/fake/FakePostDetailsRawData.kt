package com.droid.posts.fake

import com.droid.posts.PostDetailsRawQuery

internal object FakePostDetailsRawData {
    fun userRaw(
        name: String = "name",
        username: String = "username"
    ) = PostDetailsRawQuery.User(name = name, username = username)

    fun postDetails(
        title: String = "title",
        body: String = "body",
        user: PostDetailsRawQuery.User = userRaw()
    ) = PostDetailsRawQuery.Post(title = title, body = body, user = user)
}
