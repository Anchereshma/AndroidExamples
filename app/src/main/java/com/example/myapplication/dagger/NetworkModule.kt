package com.example.myapplication.dagger

import com.example.myapplication.BuildConfig
import com.example.myapplication.retrofit.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideOkHTTPClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()

    } else {

        OkHttpClient().newBuilder().build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://reqres.in").client(okHttpClient).build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit) =retrofit.create(ApiService::class.java)






}