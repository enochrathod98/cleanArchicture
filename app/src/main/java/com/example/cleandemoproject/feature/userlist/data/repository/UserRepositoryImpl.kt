package com.example.cleandemoproject.feature.userlist.data.repository

import com.example.cleandemoproject.common.Resource
import com.example.cleandemoproject.feature.userlist.data.model.toEntity
import com.example.cleandemoproject.feature.userlist.data.source.UserSource
import com.example.cleandemoproject.feature.userlist.domain.entity.UserEntity
import com.example.cleandemoproject.feature.userlist.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userSource: UserSource
) : UserRepository {


    override suspend fun getUsers(): Resource<List<UserEntity>> {
        return try {
            val model = userSource.getUsers()

            val list = model.data.map {
                it.toEntity()
            }

            Resource.Success(list)

        }catch(e: Exception) {
            Resource.Error(e)
        }
    }
}