package com.geeks.lovecalculator.ui.result

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.geeks.lovecalculator.R
import com.geeks.lovecalculator.ui.calculate.CalculateFragment
import com.geeks.lovecalculator.databinding.FragmentResultBinding
import com.geeks.lovecalculator.remote.model.LoveModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResultFragment : Fragment() {

    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!
    private var loveModel: LoveModel? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResultBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loveModel = arguments?.getSerializable(CalculateFragment.LOVEMODEL_KEY) as LoveModel

        initClickers()
        getResult()

    }

    private fun initClickers() {
        binding.btnTryAgain.setOnClickListener {
            findNavController().navigate(R.id.calculateFragment)
        }
    }

    private fun getResult() {
        if (arguments != null) {
            binding.tvFirstName.text = loveModel?.firstName.toString()
            binding.tvSecondName.text = loveModel?.secondName.toString()
            binding.tvResult.text = loveModel?.result.toString()

        }

    }

}