package com.samuelokello.counter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {
    private val _count = MutableStateFlow(State())
    val count = _count.asStateFlow()

    private val MAX_COUNT = 110

    fun incrementCount() {
        if (_count.value.count >= MAX_COUNT) return
        else {
            val currentCount = _count.value
            _count.value = State(currentCount.count + 1)
        }
    }

    fun decrementCount() {
        if (_count.value.count <= 0) return
        else {
            val currentCount = _count.value
            _count.value = State(currentCount.count - 1)
        }
    }
}

data class State(
    val count: Int = 0
)