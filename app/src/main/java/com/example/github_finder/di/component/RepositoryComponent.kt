package com.example.github_finder.di.component

import com.example.github_finder.repository.RepositoriesRepository
import com.example.github_finder.di.module.RepositoryModule
import com.kalashnyk.denys.oollatest.di.scope.RepositoryScope
import dagger.Component

@RepositoryScope
@Component(modules = [RepositoryModule::class], dependencies = [RemoteDataSourceComponent::class, DatabaseComponent::class])
interface RepositoryComponent {
    val repositoriesRepository: RepositoriesRepository
}