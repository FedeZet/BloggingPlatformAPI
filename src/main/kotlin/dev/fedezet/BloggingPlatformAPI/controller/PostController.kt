package dev.fedezet.BloggingPlatformAPI.controller

import dev.fedezet.BloggingPlatformAPI.persistence.entity.Post
import dev.fedezet.BloggingPlatformAPI.service.IPostService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/posts")
class PostController(@Autowired private val postService: IPostService) {
    @PostMapping
    fun createPost(@RequestBody post: Post): ResponseEntity<Post> {
        return ResponseEntity.status(HttpStatus.CREATED).body(postService.savePost(post))
    }

    @PutMapping("/{idReceived}")
    fun updatePost(@PathVariable idReceived: Long, @RequestBody postReceived: Post): ResponseEntity<Post> {
        if(!postService.isExistPost(idReceived)) return ResponseEntity.notFound().build()

        val post: Post = postService.findPostById(idReceived)

        val postUpdated: Post = postService.savePost(
            postReceived.copy(id = idReceived, createdAt = post.createdAt)
        )

        return ResponseEntity.status(HttpStatus.CREATED).body(postUpdated)
    }

    @DeleteMapping("/{id}")
    fun deletePost(@PathVariable id: Long): ResponseEntity<Post> {
        if(!postService.isExistPost(id)) return ResponseEntity.notFound().build()

        postService.deletePost(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/{id}")
    fun getPostById(@PathVariable id: Long): ResponseEntity<Post> {
        val post = postService.findPostById(id)
        return ResponseEntity.ok(post)
    }

    @GetMapping
    fun getPosts(@RequestParam(value = "term", required = false) term: String?): ResponseEntity<MutableIterable<Post>> {
        if (term != null) {
            if(term.isNotEmpty()) return ResponseEntity.ok(postService.findPostByTerm(term))
        }

        return ResponseEntity.ok(postService.getPosts())
    }
}
