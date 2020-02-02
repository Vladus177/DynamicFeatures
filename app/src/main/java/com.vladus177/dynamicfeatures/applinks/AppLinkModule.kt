package com.vladus177.dynamicfeatures.applinks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import com.vladus177.common_presentation.ViewModelFactory
import com.vladus177.common_presentation.ViewModelKey

@Module
object AppLinkModule {
    @Provides
    @IntoMap
    @JvmStatic
    @ViewModelKey(AppLinkViewModelImpl::class)
    fun provideAppLinkViewModelIntoMap(appLinkViewModelImpl: AppLinkViewModelImpl): ViewModel =
            appLinkViewModelImpl

    @Provides
    @JvmStatic
    fun provideMainActivityViewModel(
        appLinkActivity: AppLinkActivity,
        viewModelFactory: ViewModelFactory
    ): AppLinkViewModel =
            ViewModelProviders.of(appLinkActivity, viewModelFactory)[AppLinkViewModelImpl::class.java]
}