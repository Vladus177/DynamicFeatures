package com.vladus177.dogs.data.net

import com.vladus177.dogs.data.entity.DogsListResponseEntity
import retrofit2.http.GET
import retrofit2.http.Path

interface DogsApi {

    @GET("breeds/list/all")
    suspend fun getDogsList(): DogsListResponseEntity

    /*@GET("breed/{breed}/images")
    fun getDogImages(@Path("breed") breed: String): Observable<DogImageResponse>*/

}