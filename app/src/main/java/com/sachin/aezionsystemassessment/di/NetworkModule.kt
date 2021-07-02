package com.sachin.aezionsystemassessment.di

import com.sachin.aezionsystemassessment.network.ApiService
import com.sachin.aezionsystemassessment.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    val BASE_URL = "https://api.github.com/users"

    @Provides
    fun provideOkHttpClient(): OkHttpClient {

        return OkHttpClient.Builder().build()

    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideApi(retrofit: Retrofit) = retrofit.create(ApiService::class.java)

}