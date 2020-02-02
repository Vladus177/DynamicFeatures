package com.vladus177.dogs.data.di

import com.vladus177.dogs.data.repository.DogsRepositoryImpl
import com.vladus177.dogs.di.DogsScope
import com.vladus177.dogs.domain.repository.DogsRepository
import dagger.Binds
import dagger.Module

@Module
abstract class DogsRepositoryModule {
    @Binds
    @DogsScope
    abstract fun bindVideoRepository(videoRepositoryImpl: DogsRepositoryImpl): DogsRepository
}