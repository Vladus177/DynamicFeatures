package com.vladus177.dynamicfeatures.di


import com.vladus177.dynamicfeatures.installdialog.InstallDialogFragment
import com.vladus177.dynamicfeatures.installdialog.InstallDialogModule
import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.vladus177.common_presentation.di.FragmentScope

@Module
interface FragmentContributor {
    @ContributesAndroidInjector(modules = [InstallDialogModule::class])
    @FragmentScope
    fun contributeInstallDialogFragment(): InstallDialogFragment
}