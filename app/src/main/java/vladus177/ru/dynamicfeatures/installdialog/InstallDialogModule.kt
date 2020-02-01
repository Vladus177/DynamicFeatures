package com.jeppeman.jetpackplayground.installdialog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import vladus177.ru.common_presentation.ViewModelFactory
import vladus177.ru.common_presentation.ViewModelKey
import vladus177.ru.dynamicfeatures.installdialog.InstallDialogFragment
import vladus177.ru.dynamicfeatures.installdialog.InstallDialogViewModel
import vladus177.ru.dynamicfeatures.installdialog.InstallDialogViewModelImpl

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