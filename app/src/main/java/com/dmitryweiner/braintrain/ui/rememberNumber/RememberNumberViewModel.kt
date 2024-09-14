package com.dmitryweiner.braintrain.ui.rememberNumber

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RememberNumberViewModel : ViewModel() {
    enum class State(val stateId: Int) {
        SHOW_NUMBER(1),
        GUESS_NUMBER(2),
        SHOW_RESULT(3)
    }

    var number = MutableLiveData(generateNumber(5))
    var result = MutableLiveData<Boolean>(true)
    var results = MutableLiveData(mutableListOf<Boolean>())

    var state = MutableLiveData(State.SHOW_NUMBER)
    fun nextState(answer: Int? = null) {
        when(state.value) {
            State.SHOW_NUMBER -> {
                state.value = State.GUESS_NUMBER
            }
            State.GUESS_NUMBER -> {
                if (answer == null) {
                    return
                }
                val innerResult = number.value == answer // TODO: result could be a score
                result.value = innerResult
                results.value?.add(innerResult)
                state.value = State.SHOW_RESULT
            }
            State.SHOW_RESULT -> {
                state.value = State.SHOW_NUMBER
                number.value = generateNumber(5)
            }
            else -> {}
        }
    }
}

fun generateNumber(length: Int = 5): Int {
    var result = ""
    for (idx in 1..length) {
        result += Math.round(Math.random() * 10)
    }
    return Integer.parseInt(result)
}
