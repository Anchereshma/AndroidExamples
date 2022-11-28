package com.example.myapplication.retrofit

import com.example.myapplication.model.MultipleResource
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/api/unknown")
    suspend fun doGetListResources(): Response<MultipleResource>
}