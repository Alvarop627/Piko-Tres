package com.ejemplo.pruebamarvel.core

import com.ejemplo.pruebamarvel.utils.GlobalConstants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(GlobalConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}