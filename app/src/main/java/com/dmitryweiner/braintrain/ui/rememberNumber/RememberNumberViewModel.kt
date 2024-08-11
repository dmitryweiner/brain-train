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
    var number = MutableLiveData(generateNumber(5))
    var state = MutableLiveData(State.SHOW_NUMBER)
    var result = MutableLiveData<Boolean>(true)
    var results = MutableLiveData(mutableListOf<Boolean>())
    private var answer: Int = 0

    fun setState(newState: State) {
        state.value = newState
        when(state.value) {
            State.SHOW_NUMBER -> number.value = generateNumber(5)
            State.SHOW_RESULT -> {
                val innerResult = number.value == answer // TODO: result could be a score
                result.value = innerResult
                results.value?.add(innerResult)
            }
            else -> {}
        }
    }

    fun setAnswer(newAnswer: Int) {
        answer = newAnswer
    }
}

fun generateNumber(length: Int = 5): Int {
    var result = ""
    for (idx in 1..length) {
        result += Math.round(Math.random() * 10)
    }
    return Integer.parseInt(result)
}
