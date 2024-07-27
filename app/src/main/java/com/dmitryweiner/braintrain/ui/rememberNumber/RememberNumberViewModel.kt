package com.dmitryweiner.braintrain.ui.rememberNumber

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

public enum class State(val stateId: Int) {
    SHOW_NUMBER(1),
    GUESS_NUMBER(2),
    SHOW_RESULT(3)
}

class RememberNumberViewModel : ViewModel() {
    private var _number = MutableLiveData<Int>()
    var number: LiveData<Int> = _number
    private var state = State.SHOW_NUMBER
    init {
        // TODO: calc length depending on user's success
        _number.value = generateNumber(5)
    }
}

fun generateNumber(length: Int = 5): Int {
    var result = ""
    for (idx in 1..length) {
        result += Math.round(Math.random() * 10)
    }
    return Integer.parseInt(result)
}
