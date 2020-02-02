package com.vladus177.common_feature

import android.content.Context
import android.content.Intent
import android.os.Handler
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import kotlinx.coroutines.CoroutineDispatcher
import okhttp3.OkHttpClient
import kotlin.reflect.KClass

fun <T : Feature<*>> KClass<T>.info(context: Context) = when (this) {
    HomeFeature::class -> Feature.Info(
        id = "home",
        name = context.getString(R.string.title_feature_home),
        actionId = R.id.actionHome
    )
    DogsFeature::class -> Feature.Info(
        id = "dogs",
        name = context.getString(R.string.title_feature_dogs),
        actionId = R.id.actionDogs //TODO change name
    )
    else -> throw IllegalArgumentException("Unexpected feature $this")
}

interface Feature<T> {
    fun getMainScreen(): Fragment
    fun getLaunchIntent(context: Context): Intent
    fun inject(dependencies: T)

    data class Info(
        val id: String,
        val name: String,
        @IdRes val actionId: Int
    )
}

interface HomeFeature : Feature<HomeFeature.Dependencies> {
    interface Dependencies {
        val context: Context
    }
}

interface DogsFeature : Feature<DogsFeature.Dependencies> {
    interface Dependencies {
        val okHttpClient: OkHttpClient
        val context: Context
        val handler: Handler
        val backgroundDispatcher: CoroutineDispatcher
    }
}