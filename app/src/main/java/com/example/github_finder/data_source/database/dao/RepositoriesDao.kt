package com.example.github_finder.data_source.database.dao

import androidx.room.*
import com.example.github_finder.data_source.database.entity.RepositoriesEntity
import io.reactivex.Single

@Dao
interface RepositoriesDao {

    @Query("DELETE FROM repositories")
    fun deleteRepositories()

    @Query("SELECT * FROM repositories WHERE username = :username")
    fun queryRepositoriesByUserName(username : String) : Single<List<RepositoriesEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertListRepositories(listRepositories: List<RepositoriesEntity>)

    @Transaction
    fun insertAndClearCache(
        listRepositories: List<RepositoriesEntity>
    ){
        deleteRepositories()
        insertListRepositories(listRepositories)
    }
}