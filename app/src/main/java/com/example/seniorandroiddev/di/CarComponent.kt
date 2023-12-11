package com.example.seniorandroiddev.di

import dagger.Component

@Component(modules = [EngineModule::class])
interface CarComponent {

    fun getCarComponent() : Car
}