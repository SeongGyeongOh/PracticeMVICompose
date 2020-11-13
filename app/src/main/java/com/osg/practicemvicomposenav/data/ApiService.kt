package com.osg.practicemvicomposenav.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("/server/rest/services/Hosted/MedicalFacilityInfo/FeatureServer/0/query?where=1%3D1&outFields=*&outSR=4326&f=json")
    suspend fun getData(): PharmacyElement
}

val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl("https://icloudgis.incheon.go.kr/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val apiService = retrofit.create(ApiService::class.java)
