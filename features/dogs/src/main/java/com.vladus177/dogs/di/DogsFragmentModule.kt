package com.vladus177.dogs.di

import androidx.lifecycle.ViewModelProviders
import com.vladus177.common_presentation.AppUiContainer
import com.vladus177.common_presentation.di.ChildFragmentScope
import com.vladus177.common_presentation.di.FragmentScope
import com.vladus177.dogs.presentation.DogsListViewModel
import com.vladus177.dogs.ui.DogsDetailFragment
import com.vladus177.dogs.ui.DogsListFragment
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
object DogsFragmentModule {
    @JvmStatic
    @Provides
    @FragmentScope
    fun provideDogsViewModel(
        dogsListFragment: DogsListFragment
    ): DogsListViewModel =
        ViewModelProviders.of(dogsListFragment)[DogsListViewModel::class.java]

    @JvmStatic
    @Provides
    fun provideAppUiContainer(dogsFragment: DogsListFragment): AppUiContainer =
        dogsFragment.activity as AppUiContainer

    @Module
    interface Contributor {
        /*@ChildFragmentScope
        @ContributesAndroidInjector(modules = [DogsDetailModule::class])
        fun contributeVideoDetailFragment(): DogsDetailFragment*/
    }
}