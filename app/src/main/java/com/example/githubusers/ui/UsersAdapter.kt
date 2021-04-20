package com.example.githubusers.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.githubusers.R
import com.example.githubusers.databinding.ItemUserBinding
import com.example.githubusers.models.User

class UsersAdapter :RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {


    var userList :List<User>? =null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user,parent,false)
        val binding = ItemUserBinding.bind(view)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        userList?.let {
            holder.bind(it[position])
        }

    }

    override fun getItemCount(): Int {
       return userList?.count() ?:0
    }

    fun setData(it: List<User>?) {
        this.userList = it
        notifyDataSetChanged()
    }

    inner class UserViewHolder(val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(user:User){
            binding.tvUserName.text = user.id.toString()
        }
    }
}