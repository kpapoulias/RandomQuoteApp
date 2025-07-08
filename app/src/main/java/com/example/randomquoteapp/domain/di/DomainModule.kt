package com.example.randomquoteapp.domain.di

import com.example.randomquoteapp.domain.repository.QuoteRepository
import com.example.randomquoteapp.domain.usecase.GetRandomQuoteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object DomainModule {

    @Provides
    @ViewModelScoped
    fun provideGetRandomQuoteUseCase(repository: QuoteRepository): GetRandomQuoteUseCase {
        return GetRandomQuoteUseCase(repository)
    }
}

// While Hilt already knows how to create our use case thanks to @Inject,
// creating a module for the domain layer is good practice for consistency
// and for cases where you might need to provide an interface instead of a
// concrete class. For this project, it's not strictly necessary, but we'll
// do it to maintain a clean, scalable structure.

// Unlike our data module which was a SingletonComponent, we install this in
// the ViewModelComponent. This means the use case will be scoped to the lifecycle
// of a ViewModel. A new instance will be created for each ViewModel, which is
// exactly what we want.

// @ViewModelScoped: This annotation ensures that within a given ViewModel,
// the same instance of the GetRandomQuoteUseCase is provided every time it's
// requested.