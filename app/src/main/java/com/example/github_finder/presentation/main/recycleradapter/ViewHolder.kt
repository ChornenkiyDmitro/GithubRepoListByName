package com.example.github_finder.presentation.main.recycleradapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.github_finder.data_source.database.entity.RepositoriesEntity
import kotlinx.android.synthetic.main.item_list.view.*

class ViewHolder(
    itemView: View
): RecyclerView.ViewHolder(itemView) {
    fun bind(repo: RepositoriesEntity) {
        with(itemView) {
            textTitle.text = repo.name
        }

    }
}