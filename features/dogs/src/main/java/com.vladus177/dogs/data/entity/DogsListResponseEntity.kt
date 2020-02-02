package com.vladus177.dogs.data.entity

import com.squareup.moshi.Json

data class DogsListResponseEntity (
    @Json(name = "status")
    val status: String?,

    @Json(name = "message")
    val dogsList: Map<String, List<String>>?

)