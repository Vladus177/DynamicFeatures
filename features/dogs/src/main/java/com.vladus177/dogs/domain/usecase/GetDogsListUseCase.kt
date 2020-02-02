package com.vladus177.dogs.domain.usecase

import com.vladus177.common_domain.Result
import com.vladus177.common_domain.usecase.UseCase
import com.vladus177.dogs.domain.model.DogsListModel
import com.vladus177.dogs.domain.repository.DogsRepository

class GetDogsListUseCase(private val dogsRepository: DogsRepository)
    : UseCase<Result<DogsListModel>> {
    override suspend fun execute(): Result<DogsListModel> = dogsRepository.getDogsList()
}