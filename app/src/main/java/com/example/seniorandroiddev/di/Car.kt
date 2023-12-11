package com.example.seniorandroiddev.di

import javax.inject.Inject


class Car @Inject constructor(
    private val engine: Engine
) {

    fun startMovingCar(){
        engine.startEngine()
    }

}