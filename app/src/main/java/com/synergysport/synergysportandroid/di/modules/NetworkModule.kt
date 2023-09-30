package com.synergysport.synergysportandroid.di.modules

import com.google.gson.Gson
import com.synergysport.synergysportandroid.data.network.api.ActivitiesApi
import com.synergysport.synergysportandroid.data.network.api.AuthApi
import com.synergysport.synergysportandroid.domain.handler.TokenDataHandler
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(tokenDataHandler: TokenDataHandler): Retrofit = Retrofit.Builder()
        .baseUrl("http://194.67.91.216:8000/")
        .client(provideHttpClient(tokenDataHandler))
        .addConverterFactory(GsonConverterFactory.create(Gson()))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    private fun provideHttpClient(tokenDataHandler: TokenDataHandler) = OkHttpClient.Builder()
        .connectTimeout(20, TimeUnit.SECONDS)
        .readTimeout(20, TimeUnit.SECONDS)
        .writeTimeout(20, TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .addInterceptor(AuthInterceptor(tokenDataHandler))
        .build()

    @Provides
    fun provideAuthApi(retrofit: Retrofit): AuthApi = retrofit.create(AuthApi::class.java)

    @Provides
    fun provideActivitiesApi(retrofit: Retrofit): ActivitiesApi =
        retrofit.create(ActivitiesApi::class.java)
}

private class AuthInterceptor(
    private val tokenDataHandler: TokenDataHandler
) :
    Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val requestBuilder = originalRequest.newBuilder()
            .header("Authorization", tokenDataHandler.getToken().token)
            .method(originalRequest.method, originalRequest.body)

        val modifiedRequest = requestBuilder.build()
        return chain.proceed(modifiedRequest)
    }
}
