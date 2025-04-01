package com.example.oiatelecoms.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer{
    val repo: NetworkRepo
}

class DefaultAppContainer():AppContainer{
    private val baseUrl = "https://damdlord.infinityfreeapp.com/api/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    override val repo  by lazy {
        NetworkRepo(retrofitService)
    }
}