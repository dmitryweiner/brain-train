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
import com.dmitryweiner.braintrain.databinding.FragmentRememberNumber3Binding
import com.dmitryweiner.braintrain.databinding.FragmentRememberNumberMainBinding

class RememberNumberFragment3 : Fragment() {
    private val rememberNumberViewModel by viewModels<RememberNumberViewModel> ({ requireParentFragment() })
    private var _binding: FragmentRememberNumber3Binding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRememberNumber3Binding.inflate(inflater, container, false)
        val root: View = binding.root

        rememberNumberViewModel.result.observe(viewLifecycleOwner) {
            binding.textResult.text =
                if (it) getString(R.string.remember_number_your_answer_is_correct)
                else getString(R.string.remember_number_your_answer_is_incorrect)
        }

        binding.buttonMore.setOnClickListener {
            rememberNumberViewModel.setState(State.SHOW_NUMBER)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}