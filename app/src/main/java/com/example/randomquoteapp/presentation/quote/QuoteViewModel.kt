package com.example.randomquoteapp.presentation.quote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randomquoteapp.domain.usecase.GetRandomQuoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val getRandomQuoteUseCase: GetRandomQuoteUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(QuoteState())
    val state = _state.asStateFlow()

    init {
        loadRandomQuote()
    }

    fun loadRandomQuote() {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLoading = true, error = null
                )
            }
            val result = getRandomQuoteUseCase()

            result.onSuccess { quote ->
                _state.update {
                    it.copy(
                        quote = quote,
                        isLoading = false
                    )
                }
            }.onFailure { exception ->
                _state.update {
                    it.copy(
                        error = exception.message ?: "Unknown error",
                        isLoading = false
                    )
                }
            }
        }
    }
}