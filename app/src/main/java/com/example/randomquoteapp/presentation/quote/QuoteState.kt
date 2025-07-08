package com.example.randomquoteapp.presentation.quote

import com.example.randomquoteapp.domain.model.Quote

data class QuoteState(
    val quote: Quote? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
