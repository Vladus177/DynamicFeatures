package com.vladus177.dogs.data.mapper

import com.vladus177.dogs.data.entity.DogsListResponseEntity
import com.vladus177.dogs.domain.model.DogsListModel

class DogsListEntityMapper {

    fun DogsListResponseEntity.fromEntityToDomain() = DogsListModel(
        status = status,
        dogsList = dogsList
    )
}