package vladus177.ru.dynamicfeatures

import vladus177.ru.dynamicfeatures.base.BaseFeatureNavigatorViewModel
import javax.inject.Inject

abstract class MainViewModel : BaseFeatureNavigatorViewModel()

class MainViewModelImpl @Inject constructor() : MainViewModel()