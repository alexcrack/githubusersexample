package com.example.githubusersexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.loader.app.LoaderManager
import androidx.loader.content.Loader
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.githubusersexample.github.Api
import com.example.githubusersexample.github.User
import com.example.githubusersexample.github.UsersAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val usersList = findViewById<RecyclerView>(R.id.usersList)
        val adapter = UsersAdapter()
        usersList.layoutManager = LinearLayoutManager(this)
        usersList.adapter = adapter

        val list = ArrayList<User>()

        list.add(User(1,
            "John",
            "http://example.com",
            "http://example.com",
            "http://example.com",
            false)
        )

        val api = Api()

        api.getUsersList().enqueue(object : Callback<ArrayList<User>> {
            override fun onFailure(call: Call<ArrayList<User>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(
                call: Call<ArrayList<User>>,
                response: Response<ArrayList<User>>
            ) {
                adapter.setUsers(response.body() ?: ArrayList())
            }

        })
    }
}
