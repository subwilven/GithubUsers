package com.example.githubusers.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubusers.data.Repository
import com.example.githubusers.models.User
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository) : ViewModel() {

    val usersListLiveData = MutableLiveData<List<User>>()

    init {
        fetchUsersFromGithub()
    }

    private fun fetchUsersFromGithub() {
        viewModelScope.launch {
            usersListLiveData.value = repository.fetchUsersList()
        }
    }
}
