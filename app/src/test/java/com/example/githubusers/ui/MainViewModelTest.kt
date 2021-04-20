package com.example.githubusers.ui

import androidx.lifecycle.Observer
import com.example.githubusers.data.Repository
import com.example.githubusers.models.User
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.RegisterExtension
import org.mockito.Mock

@ExperimentalCoroutinesApi
internal class MainViewModelTest {

    @RegisterExtension
    @JvmField
    val instantExecutorExtension: InstantExecutorExtension =
        InstantExecutorExtension()


    @Mock
    var mRepo: Repository = mock()

    private lateinit var mViewModel: MainViewModel

    @Test
    fun onCreation_fetchUserApiCalled_dataSavedToLiveData() {
        instantExecutorExtension.runBlockingTest {
            val users = listOf(User("Islam", ""), User("Mostafa", ""))

            whenever(mRepo.fetchUsersList()).thenReturn(users)
            val observer: Observer<List<User>> = mock()

            mViewModel = MainViewModel(mRepo)
            mViewModel.usersListLiveData.observeForever(observer)

            verify(observer, times(1)).onChanged(users)
        }
    }
}