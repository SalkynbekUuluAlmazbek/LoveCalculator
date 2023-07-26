package com.geeks.lovecalculator.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.geeks.lovecalculator.repository.Repository
import com.geeks.lovecalculator.remote.model.LoveModel

class LoveViewModel : ViewModel() {
    var repository = Repository()

    fun getLiveData(firstName: String, secondName: String): LiveData<LoveModel> {

        return repository.getPercentage(firstName,secondName)
    }
}