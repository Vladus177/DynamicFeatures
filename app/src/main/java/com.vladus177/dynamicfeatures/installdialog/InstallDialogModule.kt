package com.vladus177.dynamicfeatures.installdialog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import com.vladus177.common_presentation.ViewModelFactory
import com.vladus177.common_presentation.ViewModelKey

@Module
object InstallDialogModule {
    @Provides
    @JvmStatic
    @IntoMap
    @ViewModelKey(InstallDialogViewModelImpl::class)
    fun provideIntoViewModelFactory(
            installDialogViewModelImpl: InstallDialogViewModelImpl
    ): ViewModel = installDialogViewModelImpl

    @Provides
    @JvmStatic
    fun provideInstallDialogViewModel(
        installDialogFragment: InstallDialogFragment,
        viewModelFactory: ViewModelFactory
    ): InstallDialogViewModel = ViewModelProviders.of(
            installDialogFragment,
            viewModelFactory
    )[InstallDialogViewModelImpl::class.java]
}