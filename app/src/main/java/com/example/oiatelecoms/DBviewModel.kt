package com.example.oiatelecoms


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.oiatelecoms.data.AppRepo
import com.example.oiatelecoms.data.LoginRequest
import com.example.oiatelecoms.data.LoginResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@Serializable
data class User(
    @SerialName("first_name") val firstName: String = "",
    @SerialName("last_name") val lastName: String = "",
    @SerialName("password") val passwordHash: String = "", // If storing hashed passwords
    val pin: Int = 1111,
    @SerialName("current_balance") val currentBalance: Double = 0.00,
    val email: String = "",
    @SerialName("account_type") val accountType: String = "Subscriber",
    @SerialName("phone_number") val phoneNumber: String = "",
)
class DBViewModel(
    private val appRepo: AppRepo
) :ViewModel(){
    private val _user =  MutableStateFlow(User())
    val user: StateFlow<User> = _user

    fun updateFirstName(input: String){
        _user.update {
            it.copy(
                firstName = input
            )
        }
    }

    fun updateLastName(input: String){
        _user.update {
            it.copy(
                lastName = input
            )
        }
    }
    fun updatePassword(input: String){
        _user.update {
            it.copy(
                passwordHash = input
            )
        }
    }
    fun updatePin(input: Int){
        _user.update {
            it.copy(
               pin = input
            )
        }
    }
    fun updateEmail(input: String){
        _user.update {
            it.copy(
                email = input
            )
        }
    }
    fun updatePhoneNumber(input: String){
        _user.update {
            it.copy(
                phoneNumber = input
            )
        }
    }
    fun registerUser(user: User, onResult: (String) -> Unit) {
        viewModelScope.launch {
            appRepo.register(user).enqueue(object : Callback<Map<String, String>> {
                override fun onResponse(call: Call<Map<String, String>>, response: Response<Map<String, String>>) {
                    onResult(response.body()?.get("message") ?: "Registration failed")
                }
                override fun onFailure(call: Call<Map<String, String>>, t: Throwable) {
                    onResult("Error: ${t.message}")
                }
            })
        }
    }
    fun loginUser(phoneNumber: String, password: String, onResult: (String) -> Unit) {
        viewModelScope.launch {
            val request = LoginRequest(phoneNumber, password)
            appRepo.loginTheUser(request).enqueue(object : Callback<LoginResponse> {
                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                    val result = response.body()
                    if (result?.success == true) {
                        onResult("Welcome ${result.user?.firstName}")
                    } else {
                        onResult(result?.error ?: "Login failed")
                    }
                }
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    onResult("Error: ${t.message}")
                }
            })
        }
    }

    companion object{
        val factory:ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as OIATELECOMSApplication)
                val appRepo = application.container.repo
                DBViewModel(appRepo = appRepo)
            }
        }
    }

}