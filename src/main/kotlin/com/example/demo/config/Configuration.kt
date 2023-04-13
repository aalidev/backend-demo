package com.example.demo.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.client.WebClient


@Configuration
class Configuration {

    @Bean
    fun webClient(builder: WebClient.Builder): WebClient =
        builder
            .baseUrl("https://stat.gov.kz/api/juridical/counter")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build()
}