package com.example.githubusersexample.github

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

class Api {
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: GithubService = retrofit.create(GithubService::class.java)

    fun getUsersList(): Call<ArrayList<User>> {
        return service.getUsersList()
    }

    interface GithubService {

        @GET("users")
        fun getUsersList(): Call<ArrayList<User>>

        @GET("users/{user_id}/repos")
        fun getUserRepos(@Path("user_id") userId: Int): Call<ArrayList<Repository>>
    }
}