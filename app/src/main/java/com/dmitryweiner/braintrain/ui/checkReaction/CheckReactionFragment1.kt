package com.dmitryweiner.braintrain.ui.checkReaction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import com.dmitryweiner.braintrain.R

class CheckReactionFragment1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_check_reaction_1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<Button>(R.id.buttonStart)
        button?.setOnClickListener {
            setModelStatus(2)
        }
    }

    private fun setModelStatus(status: Int) {
        val dashboardViewModel by viewModels<CheckReactionViewModel> ({ requireParentFragment() })
        dashboardViewModel.setStatus(status)
    }

}