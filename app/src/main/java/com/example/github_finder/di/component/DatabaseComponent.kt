package com.example.github_finder.di.component

import com.example.github_finder.data_source.DataSource
import com.example.github_finder.di.module.DatabaseModule
import dagger.Component

@Component(modules = [DatabaseModule::class])
interface DatabaseComponent {
    val dataSource: DataSource
}
