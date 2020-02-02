package com.vladus177.dogs.ui

import android.os.Bundle
import com.vladus177.common_presentation.BaseFragment
import com.vladus177.dogs.R
import com.vladus177.dogs.dogsComponent
import com.vladus177.dogs.presentation.DogsListViewModel
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

fun createDogsFragment(): DogsListFragment = DogsListFragment()

class DogsListFragment : BaseFragment<DogsListViewModel>(), HasAndroidInjector {
    override val layoutRes = R.layout.fragment_dogs_list
    @Inject
    override lateinit var viewModel: DogsListViewModel
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector

    override fun inject() {
        dogsComponent.dogsFragmentComponentFactory
            .create(this)
            .inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragmentManager?.beginTransaction()
            ?.setPrimaryNavigationFragment(this)
            ?.commit()
    }
}