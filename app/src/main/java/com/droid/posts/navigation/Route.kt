package com.droid.posts.navigation

import androidx.navigation.NavType
import androidx.navigation.compose.navArgument

internal object Route {
    const val posts = "posts"

    object PostDetails {
        const val template = "post_detail/{${Args.postId}}"
        val navArgs = listOf(navArgument(Args.postId) { type = NavType.StringType })

        fun buildUri(postId: String): String = "post_detail/$postId"

        object Args {
            const val postId = "post_id"
        }
    }
}
