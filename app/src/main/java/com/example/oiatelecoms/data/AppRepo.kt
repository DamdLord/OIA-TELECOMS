package com.example.oiatelecoms.data

import com.example.oiatelecoms.User
import retrofit2.Call

interface AppRepo{
    fun register(user: User): Call<Map<String, String>>
    fun loginTheUser(request: LoginRequest): Call<LoginResponse>
}

class NetworkRepo(
    val apiService : ApiService
):AppRepo{
    override fun register(user: User): Call<Map<String, String>> = apiService.registerUser(user)
    override fun loginTheUser(request: LoginRequest): Call<LoginResponse> = apiService.loginUser(request)
}