package com.vladus177.common_domain.usecase

interface UseCase<T> {
    suspend fun execute(): T
}