package com.example.github_finder.view_model

import androidx.lifecycle.MutableLiveData
import com.example.github_finder.data_source.database.entity.RepositoriesEntity
import com.example.github_finder.use_case.MainUseCase
import io.reactivex.rxkotlin.plusAssign
import java.util.concurrent.TimeUnit

class MainViewModel(
    private val mainUseCase: MainUseCase
) : BaseViewModel() {

    val allRepo = MutableLiveData<List<RepositoriesEntity>>()

    private fun getListRepoByUser(username: String) {
        compositeDisposable += mainUseCase.queryRepositoriesByUserName(username)
            .subscribe({ list ->
                allRepo.value = list
            }, {
                it.printStackTrace()
            })
    }

    fun fetchListRepoByUser(username: String) {
        compositeDisposable += mainUseCase.fetchRepositories(username)
            .delay(5, TimeUnit.SECONDS)
            .subscribe({
                getListRepoByUser(username)
            }, {
                it.printStackTrace()
            })
    }
}