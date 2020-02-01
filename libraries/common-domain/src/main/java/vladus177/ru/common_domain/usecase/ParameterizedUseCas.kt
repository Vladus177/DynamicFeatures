package vladus177.ru.common_domain.usecase

interface ParameterizedUseCase<T, TParams> {
    suspend fun execute(params: TParams): T
}