package com.dmitryweiner.braintrain.ui.checkReaction

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CheckReactionViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text
    private val _status = MutableLiveData<Int>().apply {
        value = 1
    }

    val status: LiveData<Int> = _status
    fun setStatus(newStatus: Int) {
        _status.value = newStatus
    }

    val results = MutableLiveData<MutableList<Double>>().apply {
        value = mutableListOf()
    }
    fun setResult(time: Double) {
        results.value?.add(time)
    }
}