package com.vladus177.dynamicfeatures.presentation

import com.vladus177.dynamicfeatures.base.BaseFeatureNavigatorViewModel
import javax.inject.Inject

abstract class MainViewModel : BaseFeatureNavigatorViewModel()

class MainViewModelImpl @Inject constructor() : MainViewModel()