package com.vladus177.dogs.domain.repository

import com.vladus177.common_domain.Result
import com.vladus177.dogs.domain.model.DogsListModel

interface DogsRepository {
    suspend fun getDogsList(): Result<DogsListModel>
}