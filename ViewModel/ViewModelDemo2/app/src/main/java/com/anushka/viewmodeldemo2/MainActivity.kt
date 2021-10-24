package com.anushka.viewmodeldemo2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.anushka.viewmodeldemo2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var dataBinding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        dataBinding.resultTextView.text = viewModel.getTotal().toString()

        dataBinding.insertButton.setOnClickListener {
            dataBinding.apply {
                viewModel.setTotal(inputEditText.text.toString().toInt())
                resultTextView.text = viewModel.getTotal().toString()
            }
        }
    }
}