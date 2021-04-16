package com.example.github_finder.di.component

import com.example.github_finder.presentation.main.MainActivity
import com.kalashnyk.denys.oollatest.di.component.UseCaseComponent
import com.example.github_finder.di.module.ViewModelModule
import com.example.github_finder.di.scope.ViewModelScope
import dagger.Component

@ViewModelScope
@Component(modules = [ViewModelModule::class], dependencies = [UseCaseComponent::class])
interface ViewModelComponent {
    fun inject(activity: MainActivity)
}