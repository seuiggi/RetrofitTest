package com.seuiggi.retrofittest.pojo.demon

import com.seuiggi.retrofittest.pojo.demon.Player

data class Records (
    val id : Int,
    val player : Player,
    val progress : Int,
    val status : String,
    val video : String
)