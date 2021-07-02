package com.sachin.aezionsystemassessment.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sachin.aezionsystemassessment.databinding.ItemUserBinding
import com.sachin.aezionsystemassessment.models.Users
import com.sachin.aezionsystemassessment.models.UsersItem

class UserAdapter(
    val userList: Users
) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {


    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val binding = ItemUserBinding.bind(view)
        fun bind(position: Int){
            binding.apply {
                tvLogin.text = userList[position].login
                tvNodeId.text = userList[position].node_id
                tvType.text = userList[position].type
            }
        }
    }
//    inner class ViewHolder(private val itemView: ItemUserBinding): RecyclerView.ViewHolder(itemView.root)




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(position)

    }


    override fun getItemCount(): Int {
        return userList.size
    }
}