package dev.fedezet.BloggingPlatformAPI.persistence.repository

import dev.fedezet.BloggingPlatformAPI.persistence.entity.Blog
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BlogRepository: CrudRepository<Blog, Long> {
}