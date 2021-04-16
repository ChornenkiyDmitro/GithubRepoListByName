package com.example.github_finder.remote_data_source

import com.example.github_finder.data_source.database.entity.RepositoriesEntity
import com.example.github_finder.remote_data_source.communicator.ApiService
import io.reactivex.Single
import retrofit2.Response

interface RemoteDataSource {

    fun fetchRepositories(username: String): Single<List<RepositoriesEntity>>
}

class RemoteDataSourceImpl(private val apiService: ApiService) : RemoteDataSource {

    override fun fetchRepositories(username: String): Single<List<RepositoriesEntity>> {
        return apiService.fetchRepositoriesByUserName(username)
    }
}