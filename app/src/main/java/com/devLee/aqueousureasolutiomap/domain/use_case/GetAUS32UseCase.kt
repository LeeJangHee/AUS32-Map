package com.devLee.aqueousureasolutiomap.domain.use_case

import com.devLee.aqueousureasolutiomap.common.Resource
import com.devLee.aqueousureasolutiomap.data.remote.AUS32
import com.devLee.aqueousureasolutiomap.domain.repository.AUS32Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAUS32UseCase @Inject constructor(
    private val repository: AUS32Repository
) {
    operator fun invoke(page: Int): Flow<Resource<AUS32>> = flow {
        try {
            emit(Resource.Loading())
            val aus32 = repository.getAUS32(page)
            emit(Resource.Success(aus32))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connect!!"))
        }
    }
}