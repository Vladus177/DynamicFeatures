package vladus177.ru.dynamicfeatures.applinks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import vladus177.ru.common_presentation.ViewModelFactory
import vladus177.ru.common_presentation.ViewModelKey

@Module
object AppLinkModule {
    @Provides
    @IntoMap
    @JvmStatic
    @ViewModelKey(AppLinkViewModelImpl::class)
    fun provideAppLinkViewModelIntoMap(appLinkViewModelImpl: AppLinkViewModelImpl): ViewModel =
            appLinkViewModelImpl

    @Provides
    @JvmStatic
    fun provideMainActivityViewModel(
        appLinkActivity: AppLinkActivity,
        viewModelFactory: ViewModelFactory
    ): AppLinkViewModel =
            ViewModelProviders.of(appLinkActivity, viewModelFactory)[AppLinkViewModelImpl::class.java]
}