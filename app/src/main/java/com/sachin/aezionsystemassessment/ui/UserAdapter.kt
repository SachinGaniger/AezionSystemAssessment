package com.sachin.aezionsystemassessment.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sachin.aezionsystemassessment.databinding.ItemUserBinding
import com.sachin.aezionsystemassessment.models.Users
import com.sachin.aezionsystemassessment.models.UsersItem

class UserAdapter(
    val userList: Users
) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {


    class ViewHolder(var itemView: ItemUserBinding): RecyclerView.ViewHolder(itemView.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var itemView = holder as ItemUserBinding
        itemView.apply {
            tvLogin.text = userList[position].login
            tvNodeId.text = userList[position].node_id
            tvType.text = userList[position].type
        }

    }


    override fun getItemCount(): Int {
        return userList.size
    }
}