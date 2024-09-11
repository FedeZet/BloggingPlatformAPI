package dev.fedezet.BloggingPlatformAPI.persistence.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.sql.Timestamp

@Entity
data class Blog(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val title: String,
    val content: String,
    val category: String,
    val tags: Set<String>,
    val createdAt: Timestamp,
    val updateAt: Timestamp
)