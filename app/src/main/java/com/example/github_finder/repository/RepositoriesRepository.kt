package com.example.github_finder.repository

import com.example.github_finder.data_source.DataSource
import com.example.github_finder.data_source.database.entity.RepositoriesEntity
import com.example.github_finder.remote_data_source.RemoteDataSource
import io.reactivex.Completable
import io.reactivex.Single

interface RepositoriesRepository {
    fun fetchRepositories(username: String): Completable
    fun deleteRepositories(): Completable
    fun queryRepositoriesByUserName(username: String): Single<List<RepositoriesEntity>>
}

class RepositoriesRepositoryImpl(
    private val dataSource: DataSource,
    private val remoteDataSource: RemoteDataSource
) : RepositoriesRepository {

    override fun fetchRepositories(username: String): Completable {
        return remoteDataSource.fetchRepositories(username = username)
            .flatMapCompletable { list -> saveItems(username = username, items = list, isCached = true)}
    }

    override fun deleteRepositories(): Completable {
       return dataSource.deleteRepositories()
    }

    override fun queryRepositoriesByUserName(username: String): Single<List<RepositoriesEntity>> {
       return dataSource.queryRepositoriesByUserName(username = username)
    }

    private fun saveItems(
        username: String, items: List<RepositoriesEntity>, isCached: Boolean
    ): Completable {

            if (isCached) {
                items.forEach { it.username = username }
               return dataSource.insertListRepositories(items)
            } else {
                return dataSource.insertAndClearCache(items)
            }

    }
}