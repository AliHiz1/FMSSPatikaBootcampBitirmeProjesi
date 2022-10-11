package com.example.fmsspatikabitirme.di

import androidx.annotation.RestrictTo
import com.example.fmsspatikabitirme.data.remote.repository.TravelAppRepositoryImp
import com.example.fmsspatikabitirme.domain.repository.TravelAppRepository
import com.example.fmsspatikabitirme.service.TravelApi
import com.example.fmsspatikabitirme.utils.Constants
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideGsonConvertFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideService(retrofit: Retrofit): TravelApi {
        return retrofit.create(TravelApi::class.java)
    }

    @Provides
    @Singleton
    fun provideTravelAppRepository(api: TravelApi): TravelAppRepository{
        return TravelAppRepositoryImp(api)
    }

}