package com.hlandim.petbreed.web.dogceo

import retrofit2.Call
import retrofit2.http.GET

interface DogCeoApi {

    @GET("breeds/list")
    fun listBreeds(): Call<DogCeoResponse>
}