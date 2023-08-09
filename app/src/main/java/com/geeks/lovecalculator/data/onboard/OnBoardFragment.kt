package com.geeks.lovecalculator.data.onboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.geeks.lovecalculator.R
import com.geeks.lovecalculator.data.local.Pref
import com.geeks.lovecalculator.data.onboard.adapter.OnBoardingAdapter
import com.geeks.lovecalculator.databinding.FragmentOnBoardBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardBinding
    private val adapter = OnBoardingAdapter(this::onClick)

    @Inject
    lateinit var pref: Pref
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewPagerOnBoard.adapter = adapter
        binding.indicatorOnBoard.setViewPager(binding.viewPagerOnBoard)
    }

    private fun onClick() {
        pref.saveOnBoardSeen()
        findNavController().navigate(R.id.calculateFragment)
    }
}