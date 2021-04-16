package com.example.github_finder.remote_data_source.communicator

import com.example.github_finder.data_source.database.entity.RepositoriesEntity
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/users/{user}/repos")
    fun fetchRepositoriesByUserName(
        @Path("user") user: String
    ): Single<List<RepositoriesEntity>>
}