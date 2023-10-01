package com.synergysport.synergysportandroid.di.modules

import com.google.gson.Gson
import com.synergysport.synergysportandroid.data.network.api.ActivitiesApi
import com.synergysport.synergysportandroid.data.network.api.AuthApi
import com.synergysport.synergysportandroid.data.network.api.MetricsApi
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
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofitDefault(tokenDataHandler: TokenDataHandler): Retrofit = Retrofit.Builder()
        .baseUrl("http://194.67.91.216:8000/")
        .client(provideHttpClient(tokenDataHandler))
        .addConverterFactory(GsonConverterFactory.create(Gson()))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    @Provides
    @Singleton
    @Named("AuthInterceptor")
    fun provideRetrofit(tokenDataHandler: TokenDataHandler): Retrofit = Retrofit.Builder()
        .baseUrl("http://194.67.91.216:8000/")
        .client(provideHttpClient(tokenDataHandler))
        .addConverterFactory(GsonConverterFactory.create(Gson()))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    @Provides
    @Singleton
    @Named("NoAuthInterceptor")
    fun provideRetrofitNoAuth(): Retrofit = Retrofit.Builder()
        .baseUrl("http://194.67.91.216:8000/")
        .client(provideHttpClientNoAuth())
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

    private fun provideHttpClientNoAuth() = OkHttpClient.Builder()
        .connectTimeout(20, TimeUnit.SECONDS)
        .readTimeout(20, TimeUnit.SECONDS)
        .writeTimeout(20, TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    @Provides
    @Named("AuthInterceptor")
    fun provideAuthApi(@Named("AuthInterceptor") retrofit: Retrofit): AuthApi =
        retrofit.create(AuthApi::class.java)

    @Provides
    @Named("NoAuthInterceptor")
    fun provideNoAuthApi(@Named("NoAuthInterceptor") retrofit: Retrofit): AuthApi =
        retrofit.create(AuthApi::class.java)


    @Provides
    fun provideActivitiesApi(retrofit: Retrofit): ActivitiesApi =
        retrofit.create(ActivitiesApi::class.java)

    @Provides
    fun provideMetricsApi(retrofit: Retrofit): MetricsApi =
        retrofit.create(MetricsApi::class.java)
}

private class AuthInterceptor(
    private val tokenDataHandler: TokenDataHandler
) :
    Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val requestBuilder = originalRequest.newBuilder()
            .header("Authorization", "Token ${tokenDataHandler.getToken().token}")
            .method(originalRequest.method, originalRequest.body)

        val modifiedRequest = requestBuilder.build()
        return chain.proceed(modifiedRequest)
    }
}
