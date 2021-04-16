package com.example.github_finder.di.module

import com.example.github_finder.data_source.DataSource
import com.example.github_finder.data_source.DataSourceImpl
import com.example.github_finder.data_source.database.AppDataBase
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule(private val appDatabase: AppDataBase) {
    @Provides
    internal fun providesAppDatabase(): AppDataBase {
        return appDatabase
    }

    @Provides
    internal fun providesFeedDataSource(appDatabase: AppDataBase): DataSource {
        return DataSourceImpl(appDatabase)
    }
}