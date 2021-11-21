package com.devLee.aqueousureasolutiomap.data

import com.devLee.aqueousureasolutiomap.common.Constants.DECODING_KEY
import com.devLee.aqueousureasolutiomap.data.remote.AUS32
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface AUS32Api {
    @GET("15094782/v1/uddi:6b2017af-659d-437e-a549-c59788817675")
    suspend fun getAUS32(
        @Query("serviceKey") serviceKey: String = DECODING_KEY,
        @Query("page") page: Int,
        @Query("perPage") perPage: Int = 20,
        @Query("returnType") returnType: String = "JSON"
        ): AUS32
}