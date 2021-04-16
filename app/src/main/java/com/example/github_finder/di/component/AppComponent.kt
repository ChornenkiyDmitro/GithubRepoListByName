package com.example.github_finder.di.component

import com.google.gson.Gson
import com.kalashnyk.denys.oollatest.di.module.AppModule
import com.example.github_finder.di.scope.AppScope
import dagger.Component

@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {
    val gson: Gson
}