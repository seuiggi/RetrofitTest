package com.seuiggi.retrofittest.api

import com.seuiggi.retrofittest.pojo.demon.DemonData
import com.seuiggi.retrofittest.pojo.demon.ListInformation
import com.seuiggi.retrofittest.pojo.demon.ListedDemonData
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface DataAPI {

    @GET("api/v2/demons/")
    suspend fun getList(
        @Query("limit") limit: Int,
        @Query("after") after: Int = 0
    ): List<ListedDemonData>

    @GET("api/v2/demons/")
    suspend fun getList(
        @Query("limit") limit: Int,
        @Query("after") after: Int,
        @Query("before") before: Int
    ): List<ListedDemonData>

    @GET("api/v2/demons/listed")
    suspend fun getListAsSorted(
        @Query("limit") limit: Int,
        @Query("after") after: Int = 0
    ): List<ListedDemonData>

    @GET("api/v2/demons/listed/")
    suspend fun getListAsSorted(
        @Query("limit") limit: Int,
        @Query("after") after: Int,
        @Query("before") before: Int
    ): List<ListedDemonData>

    @GET("api/v1/list_information")
    suspend fun getInfo(
        //No query
    ): ListInformation

    @GET("api/v1/demons/{position}")
    suspend fun getDemon(
        @Path("position") position: Int
    ): DemonData

    companion object {
        private const val BASE_URL = "https://www.pointercrate.com/"
        private val client = OkHttpClient.Builder()
            .addInterceptor {
                val request = it.request().newBuilder().addHeader("Content-Type", "application/json").build()
                return@addInterceptor it.proceed(request)
            }.build()
        private val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        fun create(): DataAPI {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .client(client)
                .build()
                .create(DataAPI::class.java)
        }
    }
}