package com.example.seniorandroiddev.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.seniorandroiddev.R
import com.example.seniorandroiddev.coroutines.viewmodelscope.MainViewModel
import com.example.seniorandroiddev.databinding.ActivityCoroutinesBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CoroutinesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCoroutinesBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_coroutines)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.users.observe(this, Observer { users ->
            users.forEach {
                Log.i("USERS", "Username is: ${it.name}")
            }
        })

        binding.downloadUserDataBtn.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                downloadUserData()
            }
        }

        lifecycleScope.launch {

        }

        lifecycleScope.launchWhenStarted {

        }

    }


    private suspend fun downloadUserData() {
        for (i in 1..20000) {
            withContext(Dispatchers.Main) {
                binding.textViewUserData.text =
                    "Downloading user $i in ${Thread.currentThread().name}"
            }
        }
    }

    private suspend fun getStock(): Int {
        delay(1000)
        return 100
    }


}