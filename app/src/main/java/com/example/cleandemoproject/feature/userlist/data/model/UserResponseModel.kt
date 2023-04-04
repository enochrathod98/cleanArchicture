package com.example.cleandemoproject.feature.userlist.data.model

import com.google.gson.annotations.SerializedName

data class UserResponseModel (
    val page: Long,
    val perPage: Long,
    val total: Long,
    val totalPages: Long,
    val data: List<UserModel>,
    val support: Support
)

data class UserModel (
    val id: Long,
    val email: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    val avatar: String
)

data class Support (
    val url: String,
    val text: String
)
