package com.vladus177.dogs.di

import com.vladus177.dogs.domain.repository.DogsRepository
import com.vladus177.dogs.domain.usecase.GetDogsListUseCase
import com.vladus177.dogs.ui.mapper.DogsListViewMapper
import dagger.Module
import dagger.Provides

@Module(subcomponents = [DogsFragmentComponent::class])
object DogsModule {
    @JvmStatic
    @Provides
    @DogsScope
    fun provideDogsViewMapper(): DogsListViewMapper = DogsListViewMapper()

    @JvmStatic
    @Provides
    @DogsScope
    fun provideGetDogsListUseCase(dogsRepository: DogsRepository): GetDogsListUseCase =
        GetDogsListUseCase(dogsRepository)
}