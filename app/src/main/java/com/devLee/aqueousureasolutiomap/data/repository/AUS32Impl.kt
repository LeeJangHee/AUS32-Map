package com.devLee.aqueousureasolutiomap.data.repository

import com.devLee.aqueousureasolutiomap.data.AUS32Api
import com.devLee.aqueousureasolutiomap.data.remote.AUS32
import com.devLee.aqueousureasolutiomap.domain.repository.AUS32Repository
import javax.inject.Inject

class AUS32Impl @Inject constructor(
    private val api: AUS32Api
): AUS32Repository {
    override suspend fun getAUS32(page: Int): AUS32 {
        return api.getAUS32(page = page)
    }

}