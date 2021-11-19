package com.example.viewmodelscopedemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        mainViewModel.users.observe(this, Observer { myUsers ->
            myUsers.forEach {
                Log.i("MyTag", "name is ${it.name}")
            }
        })
    }
}