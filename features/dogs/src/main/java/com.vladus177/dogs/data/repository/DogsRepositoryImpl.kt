package com.vladus177.dogs.data.repository

import com.vladus177.common_domain.Result
import com.vladus177.dogs.data.mapper.DogsListEntityMapper
import com.vladus177.dogs.data.net.DogsApi
import com.vladus177.dogs.domain.model.DogsListModel
import com.vladus177.dogs.domain.repository.DogsRepository
import dagger.Lazy
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DogsRepositoryImpl @Inject constructor(
    private val dogsApi: Lazy<DogsApi>,
    private val dogsEntityMapper: DogsListEntityMapper,
    private val backgroundDispatcher: CoroutineDispatcher
) : DogsRepository {

    override suspend fun getDogsList(): Result<DogsListModel> = withContext(backgroundDispatcher) {
        Result.fromSuspending {
            with(dogsEntityMapper) {
                val response = dogsApi.get().getDogsList()
                response.fromEntityToDomain()
            }
        }
    }
}