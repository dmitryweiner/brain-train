package com.dmitryweiner.braintrain.ui.checkReaction

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CheckReactionViewModel : ViewModel() {
    enum class State(val stateId: Int) {
        SHOW_INSTRUCTION(1),
        SHOW_BUTTON(2),
        SHOW_RESULT(3)
    }

    val state = MutableLiveData<State>().apply {
        value = State.SHOW_INSTRUCTION
    }
    fun nextState(newResult: Double? = null) {
        when (state.value) {
            State.SHOW_INSTRUCTION -> {
                state.value = State.SHOW_BUTTON
            }

            State.SHOW_BUTTON -> {
                if (newResult == null) {
                    return
                }
                results.value?.add(newResult)
                state.value = State.SHOW_RESULT
            }

            State.SHOW_RESULT -> {
                state.value = State.SHOW_BUTTON
            }

            else -> {}
        }
    }

    val results = MutableLiveData<MutableList<Double>>().apply {
        value = mutableListOf()
    }
}