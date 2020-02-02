package com.vladus177.dogs.di

import com.vladus177.common_feature.DogsFeature
import com.vladus177.dogs.DogsFeatureImpl
import com.vladus177.dogs.data.di.DogsApiModule
import com.vladus177.dogs.data.di.DogsRepositoryModule
import dagger.BindsInstance
import dagger.Component

@DogsScope
@Component(
    modules = [
       DogsModule::class,
        DogsApiModule::class,
        DogsRepositoryModule::class
    ],
    dependencies = [DogsFeature.Dependencies::class]
)
interface DogsComponent {
    val dogsFragmentComponentFactory: DogsFragmentComponent.Factory

    fun inject(dogsFeatureImpl: DogsFeatureImpl)

    @Component.Factory
    interface Factory {
        fun create(
            dependencies: DogsFeature.Dependencies,
            @BindsInstance dogsFeatureImpl: DogsFeatureImpl
        ): DogsComponent
    }
}