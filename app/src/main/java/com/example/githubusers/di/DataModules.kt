package com.example.githubusers.di

import com.example.githubusers.data.Repository
import org.koin.dsl.module

val dataModules = module {
    single { Repository(get()) }
}