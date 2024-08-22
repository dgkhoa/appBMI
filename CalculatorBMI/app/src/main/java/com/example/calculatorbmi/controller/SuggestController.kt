package com.example.calculatorbmi.controller

import com.example.calculatorbmi.fragment.CalculatorBmiFragment

class SuggestController(private val view: CalculatorBmiFragment) {
    fun setDefaultValuesBasedOnAge(genre: String, selectedAge: Int) {
        if (genre == "Male") {
            if (selectedAge < 18) {
                view.setSelectedHeight(160)
                view.setSelectedWeight(50)
            } else {
                view.setSelectedHeight(165)
                view.setSelectedWeight(55)
            }
        } else if (genre == "FeMale") {
            if (selectedAge < 18) {
                view.setSelectedHeight(150)
                view.setSelectedWeight(40)
            } else {
                view.setSelectedHeight(155)
                view.setSelectedWeight(45)
            }
        }
    }
}