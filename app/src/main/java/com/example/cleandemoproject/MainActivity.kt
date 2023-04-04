package com.example.cleandemoproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cleandemoproject.common.Resource
import com.example.cleandemoproject.feature.userlist.domain.usecase.GetUserUseCase
import javax.inject.Inject

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }
}

