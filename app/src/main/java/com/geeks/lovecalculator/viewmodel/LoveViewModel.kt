package com.geeks.lovecalculator.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.geeks.lovecalculator.repository.Repository
import com.geeks.lovecalculator.remote.model.LoveModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoveViewModel @Inject constructor(private val repository: Repository) : ViewModel() {


    fun getLiveData(firstName: String, secondName: String): LiveData<LoveModel> {

        return repository.getPercentage(firstName,secondName)
    }
}