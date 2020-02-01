package vladus177.ru.common_domain.usecase

interface UseCase<T> {
    suspend fun execute(): T
}