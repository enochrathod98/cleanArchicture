package com.example.cleandemoproject.feature.userlist.domain.usecase

import com.example.cleandemoproject.common.Resource
import com.example.cleandemoproject.feature.userlist.domain.entity.UserEntity
import com.example.cleandemoproject.feature.userlist.domain.repository.UserRepository
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke() : Resource<List<UserEntity>> {
       return repository.getUsers()
    }
}