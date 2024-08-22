package com.example.calculatorbmi.controller

import android.content.Context
import androidx.fragment.app.FragmentManager

class CalculatorBmiController(
    private val edtHeight: Double,
    private val edtWeight: Double
) {
    private lateinit var parentFragmentManager: FragmentManager
    private lateinit var context: Context

    fun setFragmentManager(fragmentManager: FragmentManager) {
        this.parentFragmentManager = fragmentManager
    }

    fun setContext(applicationContext: Context) {
        this.context = applicationContext
    }

    fun calculatorBMI(callback: CallBack) {
        val heightUser = edtHeight
        val weightUser = edtWeight
        if (heightUser > 0 && weightUser > 0) {
            val bmiCalculator = BMIController()
            val bmi = bmiCalculator.calculateBMI(heightUser, weightUser)
            val minIdealWeight = bmiCalculator.minIdealWeight(heightUser)
            val maxIdealWeight = bmiCalculator.maxIdealWeight(heightUser)

            callback.onResult(bmi, minIdealWeight, maxIdealWeight)
        } else {
            callback.onError("Cân nặng hoặc chiều cao không hợp lệ")
        }
    }
}

interface CallBack {
    fun onResult(bmi: Double, minIdealWeight: Double, maxIdealWeight: Double)
    fun onError(message: String)
    fun onSuggestion(suggestedHeight: Double, suggestedWeight: Double)
}