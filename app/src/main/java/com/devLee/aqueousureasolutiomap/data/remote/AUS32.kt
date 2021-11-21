package com.devLee.aqueousureasolutiomap.data.remote


import com.google.gson.annotations.SerializedName

data class AUS32(
    val currentCount: Int,
    @SerializedName("data")
    val dataList: List<Data>,
    val matchCount: Int,
    val page: Int,
    val perPage: Int,
    val totalCount: Int
)