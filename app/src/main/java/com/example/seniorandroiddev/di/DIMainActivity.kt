package com.example.seniorandroiddev.di

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.seniorandroiddev.R

class DIMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dimain)

        DaggerCarComponent.create()
            .getCarComponent()
            .startMovingCar()
    }
}