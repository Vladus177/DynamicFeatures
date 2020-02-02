package com.vladus177.home

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import com.google.auto.service.AutoService
import com.vladus177.common_feature.HomeFeature
import com.vladus177.home.di.DaggerHomeComponent
import com.vladus177.home.di.HomeComponent
import com.vladus177.home.ui.HomeActivity
import com.vladus177.home.ui.createHomeFragment

lateinit var homeComponent: HomeComponent
    private set

@AutoService(HomeFeature::class)
class HomeFeatureImpl : HomeFeature {
    override fun getLaunchIntent(context: Context): Intent {
        return Intent(context, HomeActivity::class.java)
    }

    override fun inject(dependencies: HomeFeature.Dependencies) {
        if (::homeComponent.isInitialized) {
            return
        }

        homeComponent = DaggerHomeComponent.factory()
            .create(dependencies, this)
    }

    override fun getMainScreen(): Fragment = createHomeFragment()
}