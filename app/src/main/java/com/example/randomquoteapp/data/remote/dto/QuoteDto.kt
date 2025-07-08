package com.example.randomquoteapp.data.remote.dto

import com.example.randomquoteapp.domain.model.Quote
import kotlinx.serialization.Serializable

@Serializable
data class QuoteDto(
    val id: Int,
    val quote: String,
    val author: String
)