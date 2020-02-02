package com.vladus177.dynamicfeatures.applinks


import com.vladus177.dynamicfeatures.base.BaseFeatureNavigatorViewModel
import javax.inject.Inject

abstract class AppLinkViewModel : BaseFeatureNavigatorViewModel()

class AppLinkViewModelImpl @Inject constructor() : AppLinkViewModel()