package com.dmitryweiner.braintrain.ui.rememberNumber

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.dmitryweiner.braintrain.databinding.FragmentNotificationsBinding
import com.dmitryweiner.braintrain.databinding.FragmentRememberNumbersBinding
import com.dmitryweiner.braintrain.ui.notifications.NotificationsViewModel

class RememberNumberFragment : Fragment() {
    private var _binding: FragmentRememberNumbersBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rememberNumberViewModel =
            ViewModelProvider(this).get(RememberNumberViewModel::class.java)

        _binding = FragmentRememberNumbersBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textNumber
        rememberNumberViewModel.number.observe(viewLifecycleOwner) {
            textView.text = it.toString()
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}