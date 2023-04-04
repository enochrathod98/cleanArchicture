package com.example.cleandemoproject.feature.userlist.presentation.vo

import com.example.cleandemoproject.feature.userlist.domain.entity.UserEntity

sealed class UserViewVO {
    data class Error(val message: String): UserViewVO()
    object Progress : UserViewVO()
    data class Loaded(val users: List<UserEntity>) : UserViewVO()
}
