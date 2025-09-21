package ru.netology.nmedia.dto

data class Post(
    val id: Int,
    val author: String,
    val content: String,
    val published: String,
    val likes: Int = 1_099_999,
    val likedByMe: Boolean = false,
    val share: Int = 9_999,
    val postViews: Int = 5
)
