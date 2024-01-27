package com.samuelokello.counter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {
    private val _count = MutableStateFlow(0)
    val count = _count.asStateFlow()

    private val MAX_COUNT = 110

    fun incrementCount() {
        val currentCount = _count.value ?: 0
        _count.value = currentCount + 1
    }

    fun decrementCount() {
        val currentCount = _count.value ?: 0
        if (currentCount > 0) {
            _count.value = currentCount - 1
        }
    }
}