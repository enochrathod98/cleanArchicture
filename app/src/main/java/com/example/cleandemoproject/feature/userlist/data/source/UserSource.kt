package com.example.cleandemoproject.feature.userlist.data.source

import com.example.cleandemoproject.feature.userlist.data.model.UserResponseModel
import retrofit2.http.GET

interface UserSource {
    @GET("api/users")
    suspend fun getUsers() : UserResponseModel
}

