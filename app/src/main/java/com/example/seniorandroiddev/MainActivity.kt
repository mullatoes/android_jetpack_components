package com.example.seniorandroiddev

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.seniorandroiddev.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        binding.lifecycleOwner = this

        binding.viewmodel = viewModel

    }

    override fun onStart() {
        super.onStart()
        Log.i("TAG", "onStart: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("TAG", "onRestart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.i("TAG", "onResume: ")
    }

    override fun onStop() {
        super.onStop()
        Log.i("TAG", "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("TAG", "onDestroy: ")
    }

    override fun onPause() {
        super.onPause()
        Log.i("TAG", "onPause: ")
    }

    //onStart, onResume, onPause, onStop, onRestart, onStart, onResume

}