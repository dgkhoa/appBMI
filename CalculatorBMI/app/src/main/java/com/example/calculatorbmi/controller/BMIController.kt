package com.example.calculatorbmi.controller

class BMIController {
    fun calculateBMI(height: Double, weight: Double): Double {
        val heightInMeter = height / 100
        val bmi = weight / (heightInMeter * heightInMeter)
        return kotlin.math.round(bmi * 10.0) / 10.0
    }

    fun minIdealWeight(height: Double): Double {
        val heightInMeter = height / 100
        val idealWeight = 18.5 * (heightInMeter * heightInMeter)
        return kotlin.math.round(idealWeight * 10.0) / 10.0
    }

    fun maxIdealWeight(height: Double): Double {
        val heightInMeter = height / 100
        val idealWeight = 24.9 * (heightInMeter * heightInMeter)
        return kotlin.math.round(idealWeight * 10.0) / 10.0
    }
}