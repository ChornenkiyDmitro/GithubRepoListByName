package com.example.github_finder.data_source

import com.example.github_finder.data_source.database.AppDataBase
import com.example.github_finder.data_source.database.entity.RepositoriesEntity
import io.reactivex.Completable
import io.reactivex.Single

interface DataSource {
    fun deleteRepositories(): Completable
    fun queryRepositoriesByUserName(username: String): Single<List<RepositoriesEntity>>
    fun insertListRepositories(listRepositories: List<RepositoriesEntity>): Completable
    fun insertAndClearCache(repositoryItems: List<RepositoriesEntity>): Completable
}

class DataSourceImpl(private val dataBase: AppDataBase) : DataSource {
    override fun deleteRepositories(): Completable =
        Completable.fromAction {
            dataBase.repositoryDao().deleteRepositories()
        }

    override fun queryRepositoriesByUserName(username: String): Single<List<RepositoriesEntity>> =
        dataBase.repositoryDao().queryRepositoriesByUserName(username)

    override fun insertListRepositories(listRepositories: List<RepositoriesEntity>): Completable =
        Completable.fromAction {
            dataBase.repositoryDao().insertListRepositories(listRepositories)
        }

    override fun insertAndClearCache(repositoryItems: List<RepositoriesEntity>): Completable =
        Completable.fromAction {
            dataBase.repositoryDao().insertAndClearCache(repositoryItems)
        }
}