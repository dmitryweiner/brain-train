package com.dmitryweiner.braintrain.ui.rememberNumber

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.dmitryweiner.braintrain.R
import com.dmitryweiner.braintrain.databinding.FragmentRememberNumberMainBinding
import java.io.Console

class RememberNumberFragmentMain : Fragment() {
    private var _binding: FragmentRememberNumberMainBinding? = null

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

        _binding = FragmentRememberNumberMainBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val frame: FrameLayout = binding.frame
        rememberNumberViewModel.state.observe(viewLifecycleOwner) {
            when(it) {
                State.SHOW_NUMBER -> setFragment(RememberNumberFragment1())
                State.GUESS_NUMBER -> setFragment(RememberNumberFragment2())
                State.SHOW_RESULT -> setFragment(RememberNumberFragment3())
                else -> { /* no op */}
            }
        }
        return root
    }

    private fun setFragment(fragment: Fragment) {
        val fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}