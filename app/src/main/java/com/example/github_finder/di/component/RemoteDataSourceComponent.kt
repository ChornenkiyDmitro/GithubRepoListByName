package com.example.github_finder.di.component

import com.example.github_finder.di.module.RemoteDataSourceModule
import com.example.github_finder.remote_data_source.RemoteDataSource
import com.kalashnyk.denys.oollatest.di.scope.RemoteDataSourceScope
import dagger.Component

@RemoteDataSourceScope
@Component(modules = [RemoteDataSourceModule::class], dependencies = [AppComponent::class])
interface RemoteDataSourceComponent {
    val repositoryRemoteDataSource: RemoteDataSource
}
