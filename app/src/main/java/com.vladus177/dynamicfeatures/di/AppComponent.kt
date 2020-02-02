package com.vladus177.dynamicfeatures.di

import android.content.Context
import com.vladus177.dynamicfeatures.MainApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import com.vladus177.common_data.DataModule
import com.vladus177.common_feature.DogsFeature
import com.vladus177.common_feature.FeatureManager
import com.vladus177.common_feature.HomeFeature
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    DataModule::class,
    AndroidInjectionModule::class,
    ActivityContributor::class
])
interface AppComponent : HomeFeature.Dependencies, DogsFeature.Dependencies {
    override val context: Context
    val homeFeatureDependencies: HomeFeature.Dependencies
    val videoFeatureDependencies: DogsFeature.Dependencies
    val featureManager: FeatureManager

    fun inject(application: MainApplication)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance mainApplication: MainApplication): AppComponent
    }
}