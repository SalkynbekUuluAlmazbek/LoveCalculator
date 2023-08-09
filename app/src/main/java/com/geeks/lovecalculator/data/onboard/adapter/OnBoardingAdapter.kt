package com.geeks.lovecalculator.data.onboard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.geeks.lovecalculator.databinding.ItemOnBoardingBinding
import com.geeks.lovecalculator.remote.model.OnBoard

class OnBoardingAdapter(private val onClick: () -> Unit) :
    RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    val list = arrayListOf(
        OnBoard(
            "https://edit.sundayriley.com/wp-content/uploads/2019/08/break-up-apps-the-sunday-edit.jpg",
            "Расстаться?",
            "Попробуй с другим человеком. Не опускай руки"
        ),
        OnBoard(
            "https://play-lh.googleusercontent.com/XIPjvKSoBIuiaeqsXhO9iQQq2AJ90qv6DfOpoLWaLfwu8k5FxegF1rhWUcWT0Ah4Yw",
            "Утони в любви",
            "Посмотри нужно ли тебе это"
        ),
        OnBoard(
            "https://img.freepik.com/premium-vector/cute-couple-in-love-kissing-with-heart_76844-1888.jpg",
            "Строй оношения",
            "Но не принимай это приложение в серьёз"
        ),
        OnBoard(
            "https://img.freepik.com/premium-vector/cute-couple-in-love-valentine-s-day_73637-43.jpg?w=2000",
            "Живи и наслаждайся",
            "Не трать время зря. Женись чувак!!!"
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnBoardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnBoardingBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(onBoard: OnBoard) {
            with(binding) {
                ivOnboard.load(onBoard.image)
                tvTitle.text = onBoard.title
                tvDesc.text = onBoard.description
                binding.btnStart.isVisible = adapterPosition == list.lastIndex
                binding.btnStart.setOnClickListener {
                    onClick()
                }
            }
        }

    }
}