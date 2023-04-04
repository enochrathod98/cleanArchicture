package com.example.cleandemoproject.feature.userlist.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cleandemoproject.R
import com.example.cleandemoproject.databinding.ActivityUserListBinding
import com.example.cleandemoproject.feature.userlist.presentation.adapter.UserListAdapter
import com.example.cleandemoproject.feature.userlist.presentation.vo.UserViewVO
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserListBinding

    private val viewModel by viewModels<UserListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_user_list
        )

        setupView()

        setupActions()
    }

    private fun setupView() {
        val adapter = UserListAdapter()
        binding.userListRV.adapter  = adapter
        binding.userListRV.layoutManager = LinearLayoutManager(this)



        viewModel.userView.observe(this) {

            Log.d("Activity", it.toString())


            binding.progressBar.isVisible = it is UserViewVO.Progress
            binding.errorTV.isVisible = it is UserViewVO.Error
            binding.retryBtn.isVisible = it is UserViewVO.Error
            binding.errorTV.text = (it as? UserViewVO.Error)?.message

            adapter.users = (it as? UserViewVO.Loaded)?.users ?: emptyList()

        }
    }
    private fun setupActions() {
        binding.retryBtn.setOnClickListener {
            viewModel.loadData()
        }
    }
}