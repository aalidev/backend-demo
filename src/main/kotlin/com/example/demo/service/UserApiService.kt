package com.example.demo.service

import com.example.demo.model.DataResponse
import com.example.demo.model.UserResponse
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBodilessEntity
import org.springframework.web.reactive.function.client.awaitBody
import org.springframework.web.reactive.function.client.awaitExchange

@Service
class UserApiService(
    private val webClient: WebClient
) {
    private val logger = LoggerFactory.getLogger(UserApiService::class.java)
    suspend fun getStatus(bin: String): UserResponse =
        webClient.get()
            .uri("/api/?bin={bin}&lang=ru", bin)
            .awaitExchange { clientResponse ->
                val headers = clientResponse.headers().asHttpHeaders()
                logger.info("Received response from the user API, headers $headers")
                val body = clientResponse.awaitBody<DataResponse>()
                UserResponse(0, bin, body.success)
            }
}