package com.example.cleandemoproject.feature.userlist.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleandemoproject.common.Resource
import com.example.cleandemoproject.feature.userlist.domain.usecase.GetUserUseCase
import com.example.cleandemoproject.feature.userlist.presentation.vo.UserViewVO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    val userView = MutableLiveData<UserViewVO>(UserViewVO.Progress)

    init {
        loadData()
    }

    fun loadData() {
        userView.postValue(UserViewVO.Progress)
        viewModelScope.launch {

            val view = when(val resource = getUserUseCase()) {
                is Resource.Error ->  UserViewVO.Error(resource.error.message ?: "Something went wrong")
                Resource.Pending -> UserViewVO.Progress
                is Resource.Success -> UserViewVO.Loaded(resource.data)
            }

            userView.postValue(view)
        }
    }

}