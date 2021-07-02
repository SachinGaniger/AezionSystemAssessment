package com.sachin.aezionsystemassessment.repository

import com.sachin.aezionsystemassessment.network.ApiService
import javax.inject.Inject

class Repository @Inject constructor(
    private val api: ApiService
){

    suspend fun getUsers() = api.getUsers()

}