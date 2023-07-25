package com.geeks.lovecalculator.service

import com.geeks.lovecalculator.model.LoveApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    var retrofit = Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var api = retrofit.create(LoveApi::class.java)
}

