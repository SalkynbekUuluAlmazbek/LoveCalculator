package com.geeks.lovecalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.geeks.lovecalculator.databinding.FragmentCalculateBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CalculateFragment : Fragment() {

    lateinit var binding: FragmentCalculateBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initClickers()

    }

    private fun initClickers() {
        binding.btnCalculate.setOnClickListener {
            if (binding.etFirstName.text.isNotEmpty() && binding.etSecondName.text.isNotEmpty()) {
                RetrofitService
                    .api
                    .getPercentage(
                        binding.etFirstName.text.toString(),
                        binding.etSecondName.text.toString()
                    )
                    .enqueue(object : Callback<LoveModel> {
                        override fun onResponse(
                            call: Call<LoveModel>,
                            response: Response<LoveModel>
                        ) {
                            findNavController().navigate(
                                R.id.resultFragment,
                                bundleOf(
                                    LOVE_MODEL to response.body()
                                )
                            )
                        }

                        override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                            Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
                        }
                    })
            }
        }
    }

    companion object {
        const val LOVE_MODEL = "love_model"
    }
}

