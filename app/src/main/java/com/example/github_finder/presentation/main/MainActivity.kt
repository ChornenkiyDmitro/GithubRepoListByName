package com.example.github_finder.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.github_finder.App
import com.example.github_finder.R
import com.example.github_finder.presentation.main.recycleradapter.RecyclerAdapter
import com.example.github_finder.view_model.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    val starttext = "dan1603"
    val adapter = RecyclerAdapter()
    var mainViewModel: MainViewModel? = null @Inject set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        listRepositoriesTitle.adapter = adapter
        listRepositoriesTitle.layoutManager = LinearLayoutManager(this)

        (application as App).getViewModelComponent().inject(this)

        val textWatcher = object: TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                mainViewModel?.fetchListRepoByUser(username = editUserName.text.toString().trim())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

        }

        editUserName.addTextChangedListener(textWatcher)

        editUserName.setText(starttext)

        mainViewModel?.allRepo?.observe(this, Observer {
adapter.setData(it)
        })
    }
}