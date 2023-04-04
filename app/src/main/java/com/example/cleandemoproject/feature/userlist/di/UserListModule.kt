package com.example.cleandemoproject.feature.userlist.di

import com.example.cleandemoproject.feature.userlist.data.repository.UserRepositoryImpl
import com.example.cleandemoproject.feature.userlist.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class UserListModule {
    @Binds
    abstract fun provideRepository(repositoryImpl: UserRepositoryImpl) : UserRepository
}