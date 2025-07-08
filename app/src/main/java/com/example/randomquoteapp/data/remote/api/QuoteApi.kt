package com.example.randomquoteapp.data.remote.api

import com.example.randomquoteapp.data.remote.dto.QuoteDto
import retrofit2.http.GET

interface QuoteApi {
    @GET("quotes/random")
    suspend fun getRandomQuote(): QuoteDto

    companion object {
        const val BASE_URL = "https://dummyjson.com/"
    }
}