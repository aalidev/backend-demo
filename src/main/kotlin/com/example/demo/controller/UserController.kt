package com.example.demo.controller

import com.example.demo.model.UserResponse
import com.example.demo.repository.UserRepository
import com.example.demo.service.UserApiService
import kotlinx.coroutines.reactive.awaitFirst
import kotlinx.coroutines.reactive.awaitFirstOrNull
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono

@RestController
@RequestMapping("/api/status/{bin}")
class UserController(private val userApiService: UserApiService, private val userRepo: UserRepository) {
    @GetMapping
    suspend fun getStatus(@PathVariable bin: String): Mono<UserResponse> {
        if (userRepo.getBinExist(bin).awaitFirstOrNull() != null) {
            return userRepo.getBinExist(bin).toMono()
        }
        return userRepo.save(userApiService.getStatus(bin))
    }

}