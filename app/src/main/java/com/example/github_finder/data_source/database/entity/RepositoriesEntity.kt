package com.example.github_finder.data_source.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "repositories")
data class RepositoriesEntity(
    @PrimaryKey(autoGenerate = false)
    @SerializedName("id")
    var id: Int,

    @SerializedName("name")
    var name: String,

    var username: String
)