package com.example.githubusers.di

import com.example.githubusers.data.GithubApis
import com.example.githubusers.utils.BASE_URL
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModules = module {

    single {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.create()
    }

    single {
        val builder = OkHttpClient.Builder()
        builder.readTimeout(20, TimeUnit.SECONDS)
        builder.connectTimeout(20, TimeUnit.SECONDS)
        builder.build()
    }

    single {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(get()))
            .baseUrl(BASE_URL)
            .client(get())
            .build()
    }

    single {
        get<Retrofit>().create(GithubApis::class.java)
    }

}