package com.seuiggi.retrofittest.api

import com.seuiggi.retrofittest.pojo.demon.ListedDemonData
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ListedDemonAPI {

    @GET("api/v2/demons/")
    @Headers("Content-Type: application/json")
    suspend fun getList(
        @Query("limit") limit: Int,
        @Query("after") after: Int = 0
    ): List<ListedDemonData>

    @GET("api/v2/demons/")
    @Headers("Content-Type: application/json")
    suspend fun getList(
        @Query("limit") limit: Int,
        @Query("after") after: Int,
        @Query("before") before: Int
    ): List<ListedDemonData>

    @GET("api/v2/demons/listed")
    @Headers("Content-Type: application/json")
    suspend fun getListAsSorted(
        @Query("limit") limit: Int,
        @Query("after") after: Int = 0
    ): List<ListedDemonData>

    @GET("api/v2/demons/listed/")
    @Headers("Content-Type: application/json")
    suspend fun getListAsSorted(
        @Query("limit") limit: Int,
        @Query("after") after: Int,
        @Query("before") before: Int
    ): List<ListedDemonData>

    companion object {
        private const val BASE_URL = "https://www.pointercrate.com/"
        private val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        fun create(): ListedDemonAPI {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
                .create(ListedDemonAPI::class.java)
        }
    }
}