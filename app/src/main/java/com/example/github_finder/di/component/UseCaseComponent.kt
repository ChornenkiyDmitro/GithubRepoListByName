package com.kalashnyk.denys.oollatest.di.component

import com.example.github_finder.di.component.RepositoryComponent
import com.example.github_finder.di.module.UseCaseModule
import com.example.github_finder.use_case.MainUseCase
import com.example.github_finder.di.scope.UseCaseScope
import dagger.Component

@UseCaseScope
@Component(modules = [UseCaseModule::class], dependencies = [RepositoryComponent::class])
interface UseCaseComponent {
    val mainUseCase : MainUseCase
}