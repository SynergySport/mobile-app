package com.synergysport.synergysportandroid.data

import com.google.gson.Gson
import com.synergysport.synergysportandroid.data.api.AuthApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitProvider {

    fun provideAuthApi() = provideRetrofit().create(AuthApi::class.java)

    private fun provideRetrofit() = Retrofit.Builder()
        .baseUrl("http://192.168.1.45:8000/")
        .client(provideHttpClient())
        .addConverterFactory(GsonConverterFactory.create(Gson()))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    private fun provideHttpClient() = OkHttpClient.Builder()
        .connectTimeout(20, TimeUnit.SECONDS)
        .readTimeout(1, TimeUnit.MINUTES)
        .writeTimeout(1, TimeUnit.MINUTES)
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

}