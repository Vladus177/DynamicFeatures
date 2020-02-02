package com.vladus177.dogs.ui

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import com.vladus177.common_feature.DogsFeature
import com.vladus177.common_feature.FeatureManager
import com.vladus177.common_feature.getFeature
import com.vladus177.common_presentation.AppUiContainer
import com.vladus177.common_presentation.BaseActivity
import com.vladus177.dogs.R
import com.vladus177.dynamicfeatures.appComponent

class DogsActivity : BaseActivity(), AppUiContainer {
    private val featureManager: FeatureManager by lazy { appComponent.featureManager }

    override fun enterFullscreen() {
        window?.decorView?.systemUiVisibility =
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
    }

    override fun exitFullscreen() {
        window?.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
        window?.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dogs)

        if (savedInstanceState == null) {
            val feature = featureManager.getFeature<DogsFeature, DogsFeature.Dependencies>(
                dependencies = appComponent.videoFeatureDependencies
            ) ?: throw IllegalStateException("Could not retrieve dogs feature")

            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, feature.getMainScreen())
                .commit()
        }
    }
}