package com.example.oiatelecoms.adsPackage

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit


interface AdsRepo{
    suspend fun getAds(): AdsData
}

class AdsRepoNetwork(
    private val apiService: AdsApiService
): AdsRepo {
    override suspend fun getAds(): AdsData = apiService.getAds()
}



object Ads{
    private const val firstBaseUrl = "https://android-kotlin-fun-mars-server.appspot.com/"

    private val firstRetrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(firstBaseUrl)
        .build()

    private val firstRetrofitService: AdsApiService by lazy {
        firstRetrofit.create(AdsApiService::class.java)
    }

    private const val secondBaseUrl = "https://android-kotlin-fun-mars-server.appspot.com/"

    private val secondRetrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(secondBaseUrl)
        .build()

    private val secondRetrofitService: AdsApiService by lazy {
        secondRetrofit.create(AdsApiService::class.java)
    }

    val firstAd = AdsRepoNetwork(firstRetrofitService)
    val secondAd = AdsRepoNetwork(secondRetrofitService)
}