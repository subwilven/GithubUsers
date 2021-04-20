package com.example.githubusers.data

class Repository(val githubApis: GithubApis) {

    suspend fun fetchUsersList() = githubApis.fetchUsers()
}