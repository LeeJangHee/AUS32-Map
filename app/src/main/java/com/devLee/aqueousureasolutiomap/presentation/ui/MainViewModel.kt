package com.devLee.aqueousureasolutiomap.presentation.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devLee.aqueousureasolutiomap.common.Resource
import com.devLee.aqueousureasolutiomap.domain.use_case.GetAUS32UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAUS32UseCase: GetAUS32UseCase
): ViewModel() {

    private val _aus32Response = MutableStateFlow(AUS32State())
    val aus32Response: StateFlow<AUS32State> = _aus32Response


    fun getAUS32SafeCall(page: Int) {
        getAUS32UseCase(page).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _aus32Response.value = AUS32State(aus32 = result.data?.dataList ?: emptyList())
                }
                is Resource.Error -> {
                    _aus32Response.value = AUS32State(error = result.message ?: "An unexpected error")
                }
                is Resource.Loading -> {
                    _aus32Response.value = AUS32State(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}