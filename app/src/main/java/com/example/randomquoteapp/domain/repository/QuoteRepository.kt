package com.example.randomquoteapp.domain.repository

import com.example.randomquoteapp.domain.model.Quote

interface QuoteRepository {
    suspend fun getRandomQuote(): Result<Quote>
}