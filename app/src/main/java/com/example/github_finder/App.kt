package com.example.github_finder

import android.app.Application
import androidx.room.Room
import com.example.github_finder.data_source.database.AppDataBase
import com.example.github_finder.di.component.*
import com.example.github_finder.di.module.DatabaseModule
import com.example.github_finder.di.module.RemoteDataSourceModule
import com.example.github_finder.di.module.UseCaseModule
import com.example.github_finder.di.module.ViewModelModule
import com.kalashnyk.denys.oollatest.di.component.DaggerUseCaseComponent
import com.kalashnyk.denys.oollatest.di.module.AppModule
import com.example.github_finder.di.module.RepositoryModule


class App :Application(){

    private lateinit var viewModelComponent: ViewModelComponent
    private lateinit var database: AppDataBase

    override fun onCreate() {
        super.onCreate()
        initRoom()
        initDagger()
    }

    private fun initRoom() {
        database = Room.databaseBuilder(this, AppDataBase::class.java, "database")
            .allowMainThreadQueries()
            .build()
    }

    private fun initDagger() {
        val appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()

        val remoteDataSourceComponent = DaggerRemoteDataSourceComponent.builder()
            .appComponent(appComponent)
            .remoteDataSourceModule(RemoteDataSourceModule())
            .build()

        val databaseComponent = DaggerDatabaseComponent.builder()
            .databaseModule(DatabaseModule(database))
            .build()

        val repositoryComponent = DaggerRepositoryComponent.builder()
            .remoteDataSourceComponent(remoteDataSourceComponent)
            .databaseComponent(databaseComponent)
            .repositoryModule(RepositoryModule())
            .build()

        val useCaseComponent = DaggerUseCaseComponent.builder()
            .repositoryComponent(repositoryComponent)
            .useCaseModule(UseCaseModule())
            .build()

        viewModelComponent = DaggerViewModelComponent.builder()
            .useCaseComponent(useCaseComponent)
            .viewModelModule(ViewModelModule(this))
            .build()
    }

    fun getViewModelComponent(): ViewModelComponent {
        return this.viewModelComponent
    }
}