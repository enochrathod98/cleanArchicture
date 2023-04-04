package com.example.cleandemoproject.feature.userlist.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cleandemoproject.databinding.ItemUserBinding
import com.example.cleandemoproject.feature.userlist.domain.entity.UserEntity

class UserListAdapter : RecyclerView.Adapter<UserVH>() {

    var users: List<UserEntity> = emptyList()
    set(value) {
        field = value
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserVH {
        return UserVH(
            ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        )

    }

    override fun onBindViewHolder(holder: UserVH, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int = users.size
}