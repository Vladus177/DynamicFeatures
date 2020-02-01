package vladus177.ru.dynamicfeatures.installdialog

import android.content.Context
import androidx.annotation.IdRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import vladus177.ru.common_feature.*
import vladus177.ru.common_presentation.extensions.mutableLiveDataOf
import javax.inject.Inject

interface InstallDialogViewModel {
    val installState: LiveData<FeatureManager.InstallState>
    fun installFeature(feature: String)
    fun installFeature(@IdRes actionId: Int)
}

class InstallDialogViewModelImpl @Inject constructor(
        private val featureManager: FeatureManager,
        private val context: Context
) : ViewModel(), InstallDialogViewModel {
    override val installState = mutableLiveDataOf<FeatureManager.InstallState>()

    override fun installFeature(actionId: Int) {
        val listener: (FeatureManager.InstallState) -> Unit = { state ->
            installState.value = state
        }
        when (actionId) {
            HomeFeature::class.info(context).actionId -> featureManager.installFeature<HomeFeature>(listener)
            DogsFeature::class.info(context).actionId -> featureManager.installFeature<DogsFeature>(listener)
        }
    }

    override fun installFeature(feature: String) {
        val listener: (FeatureManager.InstallState) -> Unit = { state ->
            installState.value = state
        }
        when (feature) {
            HomeFeature::class.info(context).id -> featureManager.installFeature<HomeFeature>(listener)
            DogsFeature::class.info(context).id -> featureManager.installFeature<DogsFeature>(listener)
        }
    }
}