package com.ejemplo.pruebamarvel.core

import com.pikotres.app.utils.ApiConnectionConstants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiConnectionConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}