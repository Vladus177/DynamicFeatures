package vladus177.ru.common_data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

fun OkHttpClient.Companion.create(): OkHttpClient = OkHttpClient.Builder()
    .addInterceptor(
        interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    )
    .build()