package com.example.cleandemoproject.feature.userlist.data.model

import com.example.cleandemoproject.feature.userlist.domain.entity.UserEntity

fun UserModel.toEntity(): UserEntity {
    return UserEntity(
        name = listOf(firstName, lastName).joinToString(" "),
        email = email,
        photo = avatar
    )
}