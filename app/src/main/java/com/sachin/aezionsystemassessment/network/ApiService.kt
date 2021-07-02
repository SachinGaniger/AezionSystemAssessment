package com.sachin.aezionsystemassessment.network

import com.sachin.aezionsystemassessment.models.Users
import com.sachin.aezionsystemassessment.models.UsersItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    fun getUsers(): Response<Users>

}