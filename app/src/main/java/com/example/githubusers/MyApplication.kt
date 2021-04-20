package com.example.githubusers

import android.app.Application
import com.example.githubusers.di.dataModules
import com.example.githubusers.di.networkModules
import com.example.githubusers.di.viewModelModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication:Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(networkModules,viewModelModules, dataModules)
        }
    }
}