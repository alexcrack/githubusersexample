package com.example.githubusersexample.github

import com.google.gson.annotations.SerializedName

class Repository (
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("forks")
    val forks: Boolean,

    @SerializedName("created_at")
    val createdAt: String,

    @SerializedName("updated_at")
    val updaterAt: String,

    @SerializedName("pushed_at")
    val pushedAt: String,

    @SerializedName("homepage")
    val homepage: String,

    @SerializedName("size")
    val size: Int,

    @SerializedName("stargazers_count")
    val stars: Int
) {

}