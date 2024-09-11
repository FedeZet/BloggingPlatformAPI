package dev.fedezet.BloggingPlatformAPI.service

import dev.fedezet.BloggingPlatformAPI.persistence.entity.Post

interface IPostService {
    fun getPosts(): MutableIterable<Post>
    fun findPostById(id: Long): Post
    fun findPostByTerm(term: String): MutableIterable<Post>
    fun isExistPost(id: Long): Boolean
    fun savePost(post: Post): Post
    fun deletePost(id: Long)
}