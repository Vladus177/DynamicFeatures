package com.vladus177.dynamicfeatures.base

import android.content.Context
import androidx.lifecycle.ViewModel
import com.vladus177.common_feature.*
import com.vladus177.common_presentation.SingleLiveEvent
import com.vladus177.common_presentation.extensions.mutableLiveDataOf
import com.vladus177.dynamicfeatures.R
import dagger.Lazy
import javax.inject.Inject

abstract class BaseFeatureNavigatorViewModel : ViewModel() {

    private lateinit var context: Context
    private lateinit var featureManager: FeatureManager
    private lateinit var homeFeatureDependencies: Lazy<HomeFeature.Dependencies>
    private lateinit var dogsFeatureDependencies: Lazy<DogsFeature.Dependencies>

    val featureInstalled = SingleLiveEvent<Feature.Info>()
    val installState = mutableLiveDataOf<FeatureManager.InstallState>()

    @Inject
    fun injectMembers(
            context: Context,
            featureManager: FeatureManager,
            homeFeatureDependencies: Lazy<HomeFeature.Dependencies>,
            dogsFeatureDependencies: Lazy<DogsFeature.Dependencies>
    ) {
        this.context = context
        this.featureManager = featureManager
        this.homeFeatureDependencies = homeFeatureDependencies
        this.dogsFeatureDependencies = dogsFeatureDependencies
        featureManager.registerInstallListener(featureInstalled::setValue)
    }

    override fun onCleared() {
        super.onCleared()
        featureManager.unregisterInstallListener(featureInstalled::setValue)
    }

    fun isFeatureInstalled(feature: String): Boolean {
        return when (feature) {
            HomeFeature::class.info(context).id -> {
                featureManager.isFeatureInstalled<HomeFeature>()
            }
            DogsFeature::class.info(context).id -> {
                featureManager.isFeatureInstalled<DogsFeature>()
            }
            else -> false
        }
    }

    fun getFeature(feature: String): Feature<*> {
        return when (feature) {
            HomeFeature::class.info(context).id -> {
                featureManager.getFeature<HomeFeature, HomeFeature.Dependencies>(
                        dependencies = homeFeatureDependencies.get()
                )
            }
            DogsFeature::class.info(context).id -> {
                featureManager.getFeature<DogsFeature, DogsFeature.Dependencies>(
                        dependencies = dogsFeatureDependencies.get()
                )
            }
            else -> null
        } ?: throw IllegalArgumentException("Feature not found for action $feature")
    }

    fun isFeatureInstalled(actionId: Int): Boolean {
        return when (actionId) {
            R.id.actionHome -> {
                featureManager.isFeatureInstalled<HomeFeature>()
            }
            R.id.actionDogs -> {
                featureManager.isFeatureInstalled<DogsFeature>()
            }
            else -> false
        }
    }

    fun getFeature(actionId: Int): Feature<*> {
        return when (actionId) {
            R.id.actionHome -> {
                featureManager.getFeature<HomeFeature, HomeFeature.Dependencies>(
                        dependencies = homeFeatureDependencies.get()
                )
            }
            R.id.actionDogs -> {
                featureManager.getFeature<DogsFeature, DogsFeature.Dependencies>(
                        dependencies = dogsFeatureDependencies.get()
                )
            }
            else -> null
        } ?: throw IllegalArgumentException("Feature not found for action $actionId")
    }
}