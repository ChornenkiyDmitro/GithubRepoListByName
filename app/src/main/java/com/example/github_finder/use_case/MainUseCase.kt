package com.example.github_finder.use_case

import com.example.github_finder.data_source.database.entity.RepositoriesEntity
import com.example.github_finder.repository.RepositoriesRepository
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

interface MainUseCase {
    fun fetchRepositories(username: String): Completable
    fun deleteRepositories(): Completable
    fun queryRepositoriesByUserName(username: String): Single<List<RepositoriesEntity>>
}

class MainUseCaseImpl(private val repository: RepositoriesRepository): MainUseCase{
    override fun fetchRepositories(username: String): Completable =
        repository.fetchRepositories(username)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    override fun deleteRepositories(): Completable =
        repository.deleteRepositories()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    override fun queryRepositoriesByUserName(username: String): Single<List<RepositoriesEntity>> =
        repository.queryRepositoriesByUserName(username)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}