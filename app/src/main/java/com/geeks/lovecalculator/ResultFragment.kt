package com.geeks.lovecalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.geeks.lovecalculator.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    lateinit var binding: FragmentResultBinding

    private var result: String? = null
    private var firstName: String? = null
    private var secondName: String? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initClickers()
        getResult()

    }

    private fun initClickers() {
        binding.btnTryAgain.setOnClickListener {
            findNavController().navigate(R.id.calculateFragment)
        }

        if (arguments != null) {
            result = arguments?.getSerializable(CalculateFragment.LOVE_MODEL) as String?

            binding.tvResult.text = result
            binding.tvFirstName.text = firstName
            binding.tvSecondName.text = secondName
        }
    }

    private fun getResult() {
        if (arguments != null) {
            val result = arguments?.getSerializable(CalculateFragment.LOVE_MODEL) as LoveModel
            binding.tvFirstName.text = result.firstName
            binding.tvSecondName.text = result.secondName
            binding.tvResult.text = result.percentage

        }

    }

}