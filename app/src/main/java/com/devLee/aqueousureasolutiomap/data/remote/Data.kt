package com.devLee.aqueousureasolutiomap.data.remote


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("가격")
    val price: String,
    @SerializedName("경도")
    val longitude: Double,
    @SerializedName("위도")
    val latitude: Double,
    @SerializedName("데이터기준일")
    val dataDefaultDate: String,
    @SerializedName("명칭")
    val name: String,
    @SerializedName("영업시간")
    val officeHour: String,
    @SerializedName("재고량")
    val inventoryCount: String,
    @SerializedName("전화번호")
    val phoneNumber: String,
    @SerializedName("주소")
    val address: String,
    @SerializedName("코드")
    val code: String
)