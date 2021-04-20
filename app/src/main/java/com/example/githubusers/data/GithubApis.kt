package com.example.githubusers.data

import com.example.githubusers.models.User
import retrofit2.http.GET

interface GithubApis {
    @GET("users")
    suspend fun fetchUsers(): List<User>

}