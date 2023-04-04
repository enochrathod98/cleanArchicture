package com.example.cleandemoproject.feature.userlist.domain.repository

import com.example.cleandemoproject.common.Resource
import com.example.cleandemoproject.feature.userlist.domain.entity.UserEntity

interface UserRepository {
    suspend fun getUsers(): Resource<List<UserEntity>>
}