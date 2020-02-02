package com.vladus177.home.di

import com.vladus177.common_presentation.di.FragmentScope
import com.vladus177.home.ui.HomeFragment
import dagger.BindsInstance
import dagger.Subcomponent
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@FragmentScope
@Subcomponent(modules = [
    HomeFragmentModule::class,
    AndroidInjectionModule::class
])
interface HomeFragmentComponent : AndroidInjector<HomeFragment> {
    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance homeFragment: HomeFragment): HomeFragmentComponent
    }
}