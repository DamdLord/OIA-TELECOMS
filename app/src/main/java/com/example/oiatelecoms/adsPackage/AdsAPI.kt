package com.example.oiatelecoms.adsPackage

import retrofit2.http.GET

interface AdsApiService{
    @GET("")
    suspend fun getAds(): AdsData
}