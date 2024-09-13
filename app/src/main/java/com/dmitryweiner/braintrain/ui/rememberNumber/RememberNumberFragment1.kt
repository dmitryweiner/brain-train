package com.dmitryweiner.braintrain.ui.rememberNumber

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.dmitryweiner.braintrain.R
import com.dmitryweiner.braintrain.databinding.FragmentRememberNumber1Binding
import com.dmitryweiner.braintrain.databinding.FragmentRememberNumberMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class RememberNumberFragment1 : Fragment() {
    private val rememberNumberViewModel by viewModels<RememberNumberViewModel> ({ requireParentFragment() })
    private var _binding: FragmentRememberNumber1Binding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRememberNumber1Binding.inflate(inflater, container, false)
        val root: View = binding.root

        rememberNumberViewModel.number.observe(viewLifecycleOwner) {
            binding.textNumber.text = it.toString()
        }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rememberNumberViewModel by viewModels<RememberNumberViewModel> ({ requireParentFragment() })
        lifecycleScope.launch {
            delay(5000) // TODO: add here counter for user
            rememberNumberViewModel.nextState()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}