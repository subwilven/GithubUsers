package com.example.githubusers.data

open class Repository(val githubApis: GithubApis) {

    open suspend fun fetchUsersList() = githubApis.fetchUsers()
}