package com.example.demo.model

import com.fasterxml.jackson.annotation.JsonProperty

data class DataResponse(
    @JsonProperty("success") var success: Boolean,
    @JsonProperty("obj") var obj: String? = null,
    @JsonProperty("description") var description: String? = null
)
