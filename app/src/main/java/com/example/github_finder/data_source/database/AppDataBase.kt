package com.example.github_finder.data_source.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.github_finder.data_source.database.dao.RepositoriesDao
import com.example.github_finder.data_source.database.entity.RepositoriesEntity

@Database(entities = [RepositoriesEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun repositoryDao(): RepositoriesDao
}