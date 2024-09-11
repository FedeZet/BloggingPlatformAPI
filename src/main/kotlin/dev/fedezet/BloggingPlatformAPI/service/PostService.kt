package dev.fedezet.BloggingPlatformAPI.service

import dev.fedezet.BloggingPlatformAPI.persistence.entity.Post
import dev.fedezet.BloggingPlatformAPI.persistence.repository.PostRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PostService(@Autowired private val postRepository: PostRepository): IPostService {
    override fun getPosts(): MutableIterable<Post> {
        return postRepository.findAll()
    }

    override fun findPostById(id: Long): Post {
        return postRepository.findById(id).orElse(null)
    }

    override fun findPostByTerm(term: String): MutableIterable<Post> {
        return postRepository.findByTerm(term)
    }

    override fun isExistPost(id: Long): Boolean {
        return postRepository.existsById(id)
    }

    override fun savePost(post: Post): Post {
        return postRepository.save(post)
    }

    override fun deletePost(id: Long) {
        return postRepository.deleteById(id)
    }
}