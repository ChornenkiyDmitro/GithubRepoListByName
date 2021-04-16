package com.example.github_finder.di.module

import com.example.github_finder.data_source.DataSource
import com.example.github_finder.remote_data_source.RemoteDataSource
import com.example.github_finder.repository.RepositoriesRepository
import com.example.github_finder.repository.RepositoriesRepositoryImpl
import com.kalashnyk.denys.oollatest.di.scope.RepositoryScope
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @RepositoryScope
    @Provides
    internal fun providesFeedRepository(remoteDataSource: RemoteDataSource, dataSource: DataSource): RepositoriesRepository {
        return RepositoriesRepositoryImpl(dataSource, remoteDataSource)
    }
}