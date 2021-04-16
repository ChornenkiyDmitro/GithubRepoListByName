package com.example.github_finder.di.module

import com.example.github_finder.remote_data_source.RemoteDataSource
import com.example.github_finder.remote_data_source.RemoteDataSourceImpl
import com.example.github_finder.remote_data_source.communicator.ApiService
import com.kalashnyk.denys.oollatest.di.scope.RemoteDataSourceScope
import dagger.Module
import dagger.Provides
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
class RemoteDataSourceModule {

    companion object {
        private val API_URL = "https://api.github.com/"
    }

    @Provides
    @RemoteDataSourceScope
    fun provideOkHttpClient(): OkHttpClient {
        var httpClient=OkHttpClient.Builder()
            .connectionPool(ConnectionPool(5, 30, TimeUnit.SECONDS))
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)

        return httpClient.build()
    }

    @Provides
    @RemoteDataSourceScope
    fun provideRetrofitBuilder(client: OkHttpClient): Retrofit.Builder {
        return Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    }

    @Provides
    @RemoteDataSourceScope
    fun provideRetrofit(builder: Retrofit.Builder): Retrofit {
        return builder.baseUrl(API_URL).build()
    }

    @Provides
    @RemoteDataSourceScope
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create<ApiService>(
            ApiService::class.java)
    }


    @Provides
    @RemoteDataSourceScope
    fun providesFeedRemoteDataSource(apiService: ApiService): RemoteDataSource {
        return RemoteDataSourceImpl(apiService)
    }
}
