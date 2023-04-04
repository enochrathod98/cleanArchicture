package com.example.cleandemoproject.feature.userlist.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.cleandemoproject.databinding.ItemUserBinding
import com.example.cleandemoproject.feature.userlist.domain.entity.UserEntity

class UserVH(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(userEntity: UserEntity) {
        binding.userNameTV.text = userEntity.name
        binding.emailTV.text = userEntity.email

        // do glide implementation
        binding.userIV

    }
}