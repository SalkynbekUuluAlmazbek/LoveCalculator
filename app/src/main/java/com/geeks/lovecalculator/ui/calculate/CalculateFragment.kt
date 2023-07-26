package com.geeks.lovecalculator.ui.calculate

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.geeks.lovecalculator.viewmodel.LoveViewModel
import com.geeks.lovecalculator.R
import com.geeks.lovecalculator.databinding.FragmentCalculateBinding


class CalculateFragment : Fragment() {

    lateinit var binding: FragmentCalculateBinding

    private val viewModel: LoveViewModel by viewModels()


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

        initClickers()

    }

    private fun initClickers() {
        with(binding) {
            btnCalculate.setOnClickListener {
                viewModel.getLiveData(etFirstName.text.toString(), etSecondName.text.toString())
                    .observe(this@CalculateFragment) {loveModel->
                        findNavController().navigate(
                            R.id.resultFragment,
                        bundleOf(LOVEMODEL_KEY to loveModel)
                        )

                    }
            }
        }
    }

    companion object {
        const val LOVEMODEL_KEY = "LoveModel.key"
    }
}



