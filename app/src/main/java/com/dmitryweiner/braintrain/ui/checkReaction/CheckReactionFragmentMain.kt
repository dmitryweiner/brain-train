package com.dmitryweiner.braintrain.ui.checkReaction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.dmitryweiner.braintrain.R
import com.dmitryweiner.braintrain.databinding.FragmentCheckReactionMainBinding

class CheckReactionFragmentMain : Fragment() {

    private var _binding: FragmentCheckReactionMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(CheckReactionViewModel::class.java)

        _binding = FragmentCheckReactionMainBinding.inflate(inflater, container, false)
        val root: View = binding.root

        dashboardViewModel.state.observe(viewLifecycleOwner) {
            if (it == CheckReactionViewModel.State.SHOW_INSTRUCTION) {
                setFragment(CheckReactionFragment1())
            }
            if (it == CheckReactionViewModel.State.SHOW_BUTTON) {
                setFragment(CheckReactionFragment2())
            }
            if (it == CheckReactionViewModel.State.SHOW_RESULT) {
                setFragment(CheckReactionFragment3())
            }
        }
        return root
    }

    private fun setFragment(fragment: Fragment) {
        val fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}