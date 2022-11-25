package com.example.myapplication.repository

import com.example.myapplication.model.MultipleResource
import com.example.myapplication.retrofit.ApiService
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Response
import javax.inject.Inject
@Module
@InstallIn(ViewModelComponent::class)
class MultipleListRepository @Inject constructor(val apiService: ApiService) {

    suspend fun doGetListResources() :Response<MultipleResource>{
       return apiService.doGetListResources()
    }


}