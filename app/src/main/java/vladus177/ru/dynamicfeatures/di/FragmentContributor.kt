package vladus177.ru.dynamicfeatures.di


import vladus177.ru.dynamicfeatures.installdialog.InstallDialogFragment
import com.jeppeman.jetpackplayground.installdialog.InstallDialogModule
import dagger.Module
import dagger.android.ContributesAndroidInjector
import vladus177.ru.common_presentation.di.FragmentScope

@Module
interface FragmentContributor {
    @ContributesAndroidInjector(modules = [InstallDialogModule::class])
    @FragmentScope
    fun contributeInstallDialogFragment(): InstallDialogFragment
}