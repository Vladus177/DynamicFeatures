package com.vladus177.dogs.di

import com.vladus177.common_presentation.di.FragmentScope
import com.vladus177.dogs.ui.DogsListFragment
import dagger.BindsInstance
import dagger.Subcomponent
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@FragmentScope
@Subcomponent(modules = [
    DogsFragmentModule::class,
    DogsFragmentModule.Contributor::class,
    AndroidInjectionModule::class
])
interface DogsFragmentComponent : AndroidInjector<DogsListFragment> {
    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance videoFragment: DogsListFragment): DogsFragmentComponent
    }
}