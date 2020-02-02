package com.vladus177.dogs

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import com.google.auto.service.AutoService
import com.vladus177.common_feature.DogsFeature
import com.vladus177.dogs.di.DaggerDogsComponent
import com.vladus177.dogs.di.DogsComponent
import com.vladus177.dogs.ui.DogsActivity
import com.vladus177.dogs.ui.createDogsFragment

internal lateinit var dogsComponent: DogsComponent
    private set

@AutoService(DogsFeature::class)
class DogsFeatureImpl : DogsFeature {
    override fun getLaunchIntent(context: Context): Intent = Intent(context, DogsActivity::class.java)

    override fun getMainScreen(): Fragment = createDogsFragment()

    override fun inject(dependencies: DogsFeature.Dependencies) {
        if (::dogsComponent.isInitialized) {
            return
        }

        dogsComponent = DaggerDogsComponent.factory()
            .create(dependencies, this)
    }
}