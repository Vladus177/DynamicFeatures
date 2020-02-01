package vladus177.ru.dynamicfeatures.applinks

import vladus177.ru.dynamicfeatures.base.BaseFeatureNavigatorViewModel
import javax.inject.Inject

abstract class AppLinkViewModel : BaseFeatureNavigatorViewModel()

class AppLinkViewModelImpl @Inject constructor() : AppLinkViewModel()