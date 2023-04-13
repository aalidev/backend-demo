package com.example.demo.repository

import com.example.demo.model.UserResponse
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@Repository
interface UserRepository : ReactiveCrudRepository<UserResponse, String?> {
    @Query("select * from users where bin = :bin")
    fun getBinExist(bin: String): Mono<UserResponse>
}
