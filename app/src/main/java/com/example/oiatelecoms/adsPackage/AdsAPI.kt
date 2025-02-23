package com.example.oiatelecoms.adsPackage

import retrofit2.http.GET

interface ApiService{
    @GET("")
    suspend fun getAds(): AdsData
}