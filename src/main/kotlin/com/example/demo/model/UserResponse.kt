package com.example.demo.model

import org.springframework.data.annotation.Id
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("users")
data class UserResponse(
    @Id val id: Int,
    val bin: String,
    val status: Boolean
)
