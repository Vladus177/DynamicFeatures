package com.vladus177.dogs.data.di

import android.content.Context
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.vladus177.dogs.R
import com.vladus177.dogs.data.mapper.DogsListEntityMapper
import com.vladus177.dogs.data.net.DogsApi
import com.vladus177.dogs.di.DogsScope
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
object DogsApiModule {
    @JvmStatic
    @Provides
    @DogsScope
    fun provideVideoApi(
        @DogsApiBaseUrl dogsApiBaseUrl: String,
        moshi: Moshi,
        okHttpClient: OkHttpClient
    ): DogsApi {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(dogsApiBaseUrl)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(DogsApi::class.java)
    }

    @JvmStatic
    @Provides
    @DogsScope
    @DogsApiBaseUrl
    fun provideVideoApiBaseUrl(context: Context): String {
        return context.getString(R.string.dogs_api_base_url)
    }

    @JvmStatic
    @Provides
    @DogsScope
    fun provideDogsEntityMapper(): DogsListEntityMapper = DogsListEntityMapper()

    @JvmStatic
    @Provides
    @DogsScope
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }
}