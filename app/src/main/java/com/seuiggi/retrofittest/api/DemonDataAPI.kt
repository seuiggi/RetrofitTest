package com.seuiggi.retrofittest.api

import com.seuiggi.retrofittest.pojo.demon.DemonData
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface DemonDataAPI {

    @GET("api/v1/demons/{position}")
    @Headers("Content-Type: application/json")
    suspend fun getDemon(
        @Path("position") position: Int
    ): DemonData

    companion object {
        private const val BASE_URL = "https://www.pointercrate.com/"
        private val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        fun create(): DemonDataAPI {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
                .create(DemonDataAPI::class.java)
        }
    }
}