package com.dmitryweiner.braintrain.ui.checkReaction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.dmitryweiner.braintrain.R


class CheckReactionFragment3 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_check_reaction_3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textView = view.findViewById<TextView>(R.id.textViewResult)
        val dashboardViewModel by viewModels<CheckReactionViewModel> ({ requireParentFragment() })
        dashboardViewModel.results.observe(viewLifecycleOwner) {
            textView.text = it.last().toString()
        }

        val buttonMore = view.findViewById<Button>(R.id.buttonMore)
        buttonMore.setOnClickListener {
            dashboardViewModel.nextState()
        }
    }

}