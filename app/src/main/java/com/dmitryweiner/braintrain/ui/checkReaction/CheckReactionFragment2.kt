package com.dmitryweiner.braintrain.ui.checkReaction

import android.graphics.Color
import android.os.Bundle
import android.os.SystemClock
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.dmitryweiner.braintrain.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class CheckReactionFragment2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_check_reaction_2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<Button>(R.id.buttonPressMe)
        var currentTime = 0L
        var isRunning = false

        button.setOnClickListener {
            if (!isRunning) {
                return@setOnClickListener
            }

            // measure time
            val passedTime = SystemClock.elapsedRealtime() - currentTime

            // save to model
            val dashboardViewModel by viewModels<CheckReactionViewModel> ({ requireParentFragment() })
            dashboardViewModel.setStatus(3)
            dashboardViewModel.setResult(1.0 * passedTime / 1000)
            isRunning = false
        }

        lifecycleScope.launch {
            isRunning = false
            button.setBackgroundColor(Color.RED)
            // generate random delay
            val randomDelay = Math.round(2000 + (Math.random() - 0.5) * 1000) // here should be coefficient dependant on results
            delay(randomDelay)

            // get current time
            currentTime = SystemClock.elapsedRealtime()
            // change button color
            button.setBackgroundColor(Color.GREEN)
            isRunning = true
        }
    }

    private fun setModelStatus(status: Int) {

    }

}