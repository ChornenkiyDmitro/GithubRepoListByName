package com.example.github_finder.di.module

import com.example.github_finder.repository.RepositoriesRepository
import com.example.github_finder.use_case.MainUseCase
import com.example.github_finder.use_case.MainUseCaseImpl
import com.example.github_finder.di.scope.UseCaseScope
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @UseCaseScope
    @Provides
    internal fun providesRepositoriesUseCases(repository: RepositoriesRepository): MainUseCase {
        return MainUseCaseImpl(repository)
    }
}