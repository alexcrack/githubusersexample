package com.example.githubusersexample.github

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.githubusersexample.*

class UsersAdapter : RecyclerView.Adapter<UsersAdapter.UsersViewHolder>() {

    private var usersList: ArrayList<User> = ArrayList<User>()

    fun setUsers(users: ArrayList<User>) {
        usersList = users
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = usersList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_user, parent, false)

        view.setOnClickListener {
            println("==========> Item clicked")
        }

        return UsersViewHolder(view)
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.bind(usersList[position])
    }


    class UsersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtName = itemView.findViewById<TextView>(R.id.txtLogin)
        val txtId = itemView.findViewById<TextView>(R.id.txtId)
        val imgAvatar = itemView.findViewById<ImageView>(R.id.imgAvatar)

        fun bind(user: User) {
            txtName.text = user.login
            txtId.text = user.id.toString()

            Glide.with(itemView)
                .load(user.avatarUrl)
                .centerCrop()
                .circleCrop()
                .into(imgAvatar)
        }
    }

}