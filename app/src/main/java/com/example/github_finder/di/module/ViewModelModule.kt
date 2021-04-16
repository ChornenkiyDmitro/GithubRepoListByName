package com.example.github_finder.di.module

import android.app.Application
import com.example.github_finder.App
import com.example.github_finder.use_case.MainUseCase
import com.example.github_finder.view_model.MainViewModel
import com.example.github_finder.di.scope.ViewModelScope
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule(app: App) {

    internal var app: Application = app

    @ViewModelScope
    @Provides
    internal fun providesFeedViewModel(mainUseCase: MainUseCase): MainViewModel {
        return MainViewModel(mainUseCase)
    }
}