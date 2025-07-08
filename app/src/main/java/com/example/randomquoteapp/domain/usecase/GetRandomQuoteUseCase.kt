package com.example.randomquoteapp.domain.usecase

import com.example.randomquoteapp.domain.model.Quote
import com.example.randomquoteapp.domain.repository.QuoteRepository
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(
    private val repository: QuoteRepository
) {
    suspend operator fun invoke(): Result<Quote> {
        return repository.getRandomQuote()
    }
}

// suspend operator fun invoke(): This is a special Kotlin feature.
// By declaring an invoke function with the operator keyword, we can
// call an instance of this class as if it were a function itself
// (e.g., getRandomQuoteUseCase()). It's a clean and conventional way
// to design use cases. The function is suspend because it calls the
// suspend function in our repository.