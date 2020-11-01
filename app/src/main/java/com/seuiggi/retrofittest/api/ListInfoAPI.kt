package com.seuiggi.retrofittest.api

import com.seuiggi.retrofittest.pojo.demon.ListInformation
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

interface ListInfoAPI {

    @GET("api/v1/list_information")
    @Headers("Content-Type: application/json")
    suspend fun getInfo(
        //No query
    ): ListInformation

    companion object {
        private const val BASE_URL = "https://www.pointercrate.com/"
        private val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        fun create() : ListInfoAPI {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
                .create(ListInfoAPI::class.java)
        }
    }
}