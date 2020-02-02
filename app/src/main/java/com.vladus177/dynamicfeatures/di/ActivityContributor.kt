package com.vladus177.dynamicfeatures.di

import com.vladus177.dynamicfeatures.MainModule
import com.vladus177.dynamicfeatures.applinks.AppLinkActivity
import com.vladus177.dynamicfeatures.applinks.AppLinkModule
import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.vladus177.common_presentation.di.ActivityScope
import com.vladus177.dynamicfeatures.MainActivity

@Module
interface ActivityContributor {
    @ActivityScope
    @ContributesAndroidInjector(modules = [
        MainModule::class,
        FragmentContributor::class
    ])
    fun contributeMainActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [
        AppLinkModule::class,
        FragmentContributor::class
    ])
    fun contributeAppLinkActivity(): AppLinkActivity
}