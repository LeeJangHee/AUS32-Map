package com.devLee.aqueousureasolutiomap.domain.repository

import com.devLee.aqueousureasolutiomap.data.remote.AUS32

interface AUS32Repository {

    suspend fun getAUS32(page: Int): AUS32
}