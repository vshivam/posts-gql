package com.droid.posts.common.domain

data class PostPreview(val id: String, val title: String, val body: String)

data class PostDetails(val title: String, val body: String, val user: User)

data class User(val userName: String, val name: String)
