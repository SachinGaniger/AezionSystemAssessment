package com.sachin.aezionsystemassessment.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sachin.aezionsystemassessment.models.Users
import com.sachin.aezionsystemassessment.models.UsersItem
import com.sachin.aezionsystemassessment.repository.Repository
import com.sachin.aezionsystemassessment.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val users: MutableLiveData<Resource<Users>> = MutableLiveData()

    fun getUsers(): LiveData<Resource<Users>>{
        return users
    }

    fun getUsersFromRepo() =
        viewModelScope
        .launch {
            users.postValue(Resource.Loading())
            val usersList = handleUsers(repository.getUsers())
            users.postValue(usersList)
        }

    private fun handleUsers(response: Response<Users>): Resource<Users> {
        if(response.isSuccessful){
            response.body()?.let { userResponse ->
              return  Resource.Success(userResponse)
            }
        }
        return Resource.Error(response.body(), response.message())
    }

}