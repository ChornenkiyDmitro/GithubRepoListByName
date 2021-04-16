package com.example.github_finder.presentation.main.recycleradapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.github_finder.R
import com.example.github_finder.data_source.database.entity.RepositoriesEntity

class RecyclerAdapter: RecyclerView.Adapter<ViewHolder>() {
    private var placeList = mutableListOf<RepositoriesEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return placeList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(placeList[position])
    }

    fun setData(repo: List<RepositoriesEntity>) {
        Log.d("ListAdapter", "users = $repo")
        placeList.clear()
        placeList.addAll(repo)
        notifyDataSetChanged()
    }
}
