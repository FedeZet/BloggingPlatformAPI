package dev.fedezet.BloggingPlatformAPI.persistence.repository

import dev.fedezet.BloggingPlatformAPI.persistence.entity.Post
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepository: CrudRepository<Post, Long> {
    @Query(value = "select * from post p where p.title like %?1% or p.content like %?1% or p.category like %?1%", nativeQuery = true)
    fun findByTerm(term: String): MutableIterable<Post>
}