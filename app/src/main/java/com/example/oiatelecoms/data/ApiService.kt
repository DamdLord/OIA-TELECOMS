package com.example.oiatelecoms.data

import com.example.oiatelecoms.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


data class LoginRequest(val phoneNumber: String, val password: String)

data class LoginResponse(val success: Boolean, val user: User?, val error: String?)

interface ApiService {
    @POST("register_user.php")
    fun registerUser(@Body user:User): Call<Map<String, String>>

    @POST("login.php")
    fun loginUser(@Body request: LoginRequest): Call<LoginResponse>
}