package com.vladus177.home.ui

import android.os.Bundle
import com.vladus177.common_feature.FeatureManager
import com.vladus177.common_feature.HomeFeature
import com.vladus177.common_feature.getFeature
import com.vladus177.common_presentation.BaseActivity
import com.vladus177.dynamicfeatures.appComponent
import com.vladus177.home.R

class HomeActivity : BaseActivity() {
    private val featureManager: FeatureManager by lazy { appComponent.featureManager }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        if (savedInstanceState == null) {
            val feature = featureManager.getFeature<HomeFeature, HomeFeature.Dependencies>(
                dependencies = appComponent.homeFeatureDependencies
            ) ?: throw IllegalStateException("Could not retrieve video feature")

            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, feature.getMainScreen())
                .commit()
        }
    }
}