package com.example.githubusersexample.github

import com.google.gson.annotations.SerializedName

class User (
    @SerializedName("id")
    val id: Int,

    @SerializedName("login")
    val login: String,

    @SerializedName("avatar_url")
    val avatarUrl: String,

    @SerializedName("url")
    val url: String,

    @SerializedName("html_url")
    val htmlUrl: String,

    @SerializedName("site_admin")
    val isSiteAdmin: Boolean
) {

}