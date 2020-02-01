package vladus177.ru.dynamicfeatures.di

import vladus177.ru.dynamicfeatures.MainModule
import vladus177.ru.dynamicfeatures.applinks.AppLinkActivity
import vladus177.ru.dynamicfeatures.applinks.AppLinkModule
import dagger.Module
import dagger.android.ContributesAndroidInjector
import vladus177.ru.common_presentation.di.ActivityScope
import vladus177.ru.dynamicfeatures.MainActivity

@Module
interface ActivityContributor {
    @ActivityScope
    @ContributesAndroidInjector(modules = [
        MainModule::class,
        FragmentContributor::class
    ])
    fun contributeMainActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [
        AppLinkModule::class,
        FragmentContributor::class
    ])
    fun contributeAppLinkActivity(): AppLinkActivity
}