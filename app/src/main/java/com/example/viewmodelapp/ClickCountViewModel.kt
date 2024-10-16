package com.example.viewmodelapp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class ClickCountViewModel : ViewModel() {


    private val _uiState = MutableStateFlow(0)
    val uiState: StateFlow<Int> = _uiState


    fun increment() {
        _uiState.value += 1
    }

}