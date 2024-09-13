package com.dmitryweiner.braintrain.ui.rememberNumber

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.dmitryweiner.braintrain.R
import com.dmitryweiner.braintrain.databinding.FragmentRememberNumber1Binding
import com.dmitryweiner.braintrain.databinding.FragmentRememberNumber2Binding
import com.dmitryweiner.braintrain.databinding.FragmentRememberNumberMainBinding

class RememberNumberFragment2 : Fragment() {
    private val rememberNumberViewModel by viewModels<RememberNumberViewModel> ({ requireParentFragment() })
    private var _binding: FragmentRememberNumber2Binding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentRememberNumber2Binding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.buttonOk.setOnClickListener {
            var parsedInt = 0
            try {
                parsedInt = binding.editNumber.text.toString().toInt()
            } catch (e: NumberFormatException) {
                //
            }
            rememberNumberViewModel.nextState(parsedInt)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}