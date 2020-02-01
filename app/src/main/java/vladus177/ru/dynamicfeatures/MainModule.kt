package vladus177.ru.dynamicfeatures

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import vladus177.ru.common_presentation.ViewModelFactory
import vladus177.ru.common_presentation.ViewModelKey

@Module
object MainModule {
    @Provides
    @IntoMap
    @JvmStatic
    @ViewModelKey(MainViewModelImpl::class)
    fun provideMainViewModelIntoMap(mainActivityViewModel: MainViewModelImpl): ViewModel =
        mainActivityViewModel

    @Provides
    @JvmStatic
    fun provideMainViewModel(
        mainActivity: MainActivity,
        viewModelFactory: ViewModelFactory
    ): MainViewModel =
        ViewModelProviders.of(mainActivity, viewModelFactory)[MainViewModelImpl::class.java]
}