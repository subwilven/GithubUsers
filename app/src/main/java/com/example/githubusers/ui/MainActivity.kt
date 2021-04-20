package com.example.githubusers.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubusers.R
import com.example.githubusers.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    val mainViewModel: MainViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding
    private lateinit var mAdapter: UsersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setUpViews()
        setUpObservers()
    }

    private fun setUpObservers() {
        mainViewModel.usersListLiveData.observe(this){
            mAdapter.setData(it)
        }
    }

    private fun setUpViews() {
        mAdapter= UsersAdapter()
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(this@MainActivity,2)
            adapter = mAdapter
        }
    }
}