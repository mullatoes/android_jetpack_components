package com.example.seniorandroiddev.di

import dagger.Module
import dagger.Provides

@Module
class EngineModule {

    @Provides
    fun providesEngineModule() : Engine{
        return Engine()
    }
}