package com.vladus177.home.di

import com.vladus177.common_feature.HomeFeature
import com.vladus177.home.HomeFeatureImpl
import dagger.BindsInstance
import dagger.Component

@HomeScope
@Component(
    modules = [HomeModule::class],
    dependencies = [HomeFeature.Dependencies::class]
)
interface HomeComponent {
    val homeFragmentComponentFactory: HomeFragmentComponent.Factory

    fun inject(homeFeature: HomeFeatureImpl)

    @Component.Factory
    interface Factory {
        fun create(
            dependencies: HomeFeature.Dependencies,
            @BindsInstance homeFeatureImpl: HomeFeatureImpl
        ): HomeComponent
    }
}


