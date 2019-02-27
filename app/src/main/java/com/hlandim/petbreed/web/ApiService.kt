package com.hlandim.petbreed.web

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiService(baseUrl: String) {

    var retrofit: Retrofit = Retrofit
        .Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


}