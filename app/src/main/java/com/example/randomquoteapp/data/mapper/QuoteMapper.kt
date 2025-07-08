package com.example.randomquoteapp.data.mapper

import com.example.randomquoteapp.data.remote.dto.QuoteDto
import com.example.randomquoteapp.domain.model.Quote

fun QuoteDto.toDomain() : Quote {
    return Quote(
        text = this.quote,
        author = this.author
    )
}