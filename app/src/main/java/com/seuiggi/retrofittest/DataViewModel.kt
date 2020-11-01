package com.seuiggi.retrofittest

import android.content.ClipData.Item
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.seuiggi.retrofittest.api.DataRepository
import com.seuiggi.retrofittest.pojo.demon.ListedDemonData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch


class DataViewModel : ViewModel() {

    private val repository = DataRepository()

    fun getList(limit: Int, after: Int = 0) = flow {
        emit(repository.getList(limit, after))
    }.flowOn(Dispatchers.IO)

    fun getList(limit: Int, after: Int, before: Int) =  flow {
        emit(repository.getList(limit, after, before))
    }.flowOn(Dispatchers.IO)

    fun getListAsSorted(limit: Int, after: Int = 0) = flow {
        emit(repository.getListAsSorted(limit, after))
    }.flowOn(Dispatchers.IO)

    fun getListAsSorted(limit: Int, after: Int, before: Int) = flow {
        emit(repository.getListAsSorted(limit, after, before))
    }.flowOn(Dispatchers.IO)

    fun getInfo() = flow {
        emit(repository.getInfo())
    }.flowOn(Dispatchers.IO)

    fun getDemon(position: Int) = flow {
        emit(repository.getDemon(position))
    }.flowOn(Dispatchers.IO)
}