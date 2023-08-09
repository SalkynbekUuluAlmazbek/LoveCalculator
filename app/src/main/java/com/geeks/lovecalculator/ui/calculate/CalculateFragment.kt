package com.geeks.lovecalculator.ui.calculate

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.geeks.lovecalculator.viewmodel.LoveViewModel
import com.geeks.lovecalculator.R
import com.geeks.lovecalculator.data.local.Pref
import com.geeks.lovecalculator.databinding.FragmentCalculateBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CalculateFragment : Fragment() {

    lateinit var binding: FragmentCalculateBinding

    private val viewModel: LoveViewModel by viewModels()

    @Inject
    lateinit var pref: Pref


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCalculateBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        if (!pref.isOnBoardSeen()) {
            findNavController().navigate(R.id.onBoardFragment2)
        }


        initClickers()

    }

    private fun initClickers() {
        with(binding) {
            btnCalculate.setOnClickListener {
                viewModel.getLiveData(etFirstName.text.toString(), etSecondName.text.toString())
                    .observe(requireActivity()) {loveModel->
                        if (it.error != null) {
                            Toast.makeText(requireContext(), it.error, Toast.LENGTH_SHORT).show()
                        } else {
                            findNavController().navigate(
                                R.id.resultFragment,
                                bundleOf(LOVEMODEL_KEY to it)
                            )
                        }

                    }
            }
        }
    }

    companion object {
        const val LOVEMODEL_KEY = "LoveModel.key"
    }
}



