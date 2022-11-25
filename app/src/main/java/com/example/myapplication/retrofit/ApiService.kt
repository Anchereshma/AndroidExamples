package com.example.myapplication.retrofit

import com.example.myapplication.database.entity.User
import com.example.myapplication.model.MultipleResource
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("/api/unknown")
    suspend fun doGetListResources(): Response<MultipleResource>

}