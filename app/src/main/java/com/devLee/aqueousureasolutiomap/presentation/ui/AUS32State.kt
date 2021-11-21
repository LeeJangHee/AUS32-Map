package com.devLee.aqueousureasolutiomap.presentation.ui

import com.devLee.aqueousureasolutiomap.data.remote.Data

data class AUS32State(
    val isLoading: Boolean = false,
    val aus32: List<Data> = emptyList(),
    val error: String = ""
)