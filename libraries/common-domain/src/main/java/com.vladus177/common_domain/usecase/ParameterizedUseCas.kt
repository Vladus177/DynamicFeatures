package com.vladus177.common_domain.usecase

interface ParameterizedUseCase<T, TParams> {
    suspend fun execute(params: TParams): T
}