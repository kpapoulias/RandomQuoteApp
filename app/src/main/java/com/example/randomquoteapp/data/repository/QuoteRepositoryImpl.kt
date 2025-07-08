package com.example.randomquoteapp.data.repository

import com.example.randomquoteapp.data.mapper.toDomain
import com.example.randomquoteapp.data.remote.api.QuoteApi
import com.example.randomquoteapp.domain.model.Quote
import com.example.randomquoteapp.domain.repository.QuoteRepository
import javax.inject.Inject

class QuoteRepositoryImpl @Inject constructor(
    private val api: QuoteApi
) : QuoteRepository {
    override suspend fun getRandomQuote(): Result<Quote> {
        return try {
            val quoteDto = api.getRandomQuote()
            Result.success(quoteDto.toDomain())
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }
}