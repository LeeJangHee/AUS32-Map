package com.devLee.aqueousureasolutiomap.di

import com.devLee.aqueousureasolutiomap.common.Constants.BASE_URL
import com.devLee.aqueousureasolutiomap.common.Constants.DECODING_KEY
import com.devLee.aqueousureasolutiomap.data.AUS32Api
import com.devLee.aqueousureasolutiomap.data.repository.AUS32Impl
import com.devLee.aqueousureasolutiomap.domain.repository.AUS32Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAUS32Api(): AUS32Api {
        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(
                OkHttpClient.Builder()
                    .connectTimeout(20, TimeUnit.SECONDS)
                    .readTimeout(20, TimeUnit.SECONDS)
                    .writeTimeout(20, TimeUnit.SECONDS)
                    .addInterceptor(interceptor)
                    .build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AUS32Api::class.java)
    }

    @Provides
    @Singleton
    fun provideAUS32Repository(api: AUS32Api): AUS32Repository = AUS32Impl(api)
}