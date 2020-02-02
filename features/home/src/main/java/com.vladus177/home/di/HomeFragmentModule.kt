package com.vladus177.home.di

import androidx.lifecycle.ViewModelProviders
import com.vladus177.common_presentation.di.FragmentScope
import com.vladus177.home.presentation.HomeViewModel
import com.vladus177.home.ui.HomeFragment
import dagger.Module
import dagger.Provides

@Module
object HomeFragmentModule {
    @JvmStatic
    @Provides
    @FragmentScope
    fun provideHomeFragment(homeFragment: HomeFragment): HomeViewModel =
        ViewModelProviders.of(homeFragment)[HomeViewModel::class.java]
}