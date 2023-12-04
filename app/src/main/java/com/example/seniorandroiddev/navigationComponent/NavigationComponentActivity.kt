package com.example.seniorandroiddev.navigationComponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.seniorandroiddev.R
import com.example.seniorandroiddev.databinding.ActivityNavigationComponentBinding

class NavigationComponentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNavigationComponentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_navigation_component)
    }
}