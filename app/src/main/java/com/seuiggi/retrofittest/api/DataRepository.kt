package com.seuiggi.retrofittest.api

class DataRepository {

    private val api = DataAPI.create()

    suspend fun getList(limit: Int, after: Int = 0) = api.getList(limit, after)

    suspend fun getList(limit: Int, after: Int, before: Int) = api.getList(limit, after, before)

    suspend fun getListAsSorted(limit: Int, after: Int = 0) = api.getListAsSorted(limit, after)

    suspend fun getListAsSorted(limit: Int, after: Int, before: Int) = api.getListAsSorted(limit, after, before)

    suspend fun getInfo() = api.getInfo()

    suspend fun getDemon(position: Int) = api.getDemon(position)
}