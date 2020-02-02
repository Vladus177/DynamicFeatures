package com.vladus177.dynamicfeatures

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import com.vladus177.common_presentation.ViewModelFactory
import com.vladus177.common_presentation.ViewModelKey
import com.vladus177.dynamicfeatures.presentation.MainViewModel
import com.vladus177.dynamicfeatures.presentation.MainViewModelImpl

@Module
object MainModule {
    @Provides
    @IntoMap
    @JvmStatic
    @ViewModelKey(MainViewModelImpl::class)
    fun provideMainViewModelIntoMap(mainActivityViewModel: MainViewModelImpl): ViewModel =
        mainActivityViewModel

    @Provides
    @JvmStatic
    fun provideMainViewModel(
        mainActivity: MainActivity,
        viewModelFactory: ViewModelFactory
    ): MainViewModel =
        ViewModelProviders.of(mainActivity, viewModelFactory)[MainViewModelImpl::class.java]
}