package vladus177.ru.dynamicfeatures

import com.google.android.play.core.splitcompat.SplitCompatApplication
import vladus177.ru.dynamicfeatures.di.AppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import vladus177.ru.dynamicfeatures.di.DaggerAppComponent
import javax.inject.Inject

lateinit var appComponent: AppComponent

open class MainApplication : SplitCompatApplication(), HasAndroidInjector {
    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector() = dispatchingActivityInjector

    open fun inject() {
        appComponent = DaggerAppComponent.factory().create(this)
        appComponent.inject(this)
    }

    override fun onCreate() {
        super.onCreate()
        inject()
    }
}