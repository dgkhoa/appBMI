package com.example.calculatorbmi.model

import android.widget.TextView
import androidx.cardview.widget.CardView

data class History(
    val bmi: Double,
    val date: String,
    val cardView: CardView,
    val status: TextView
)

class BMIHistory {
    companion object {
        private val history = mutableListOf<History>()

        fun addHistory(bmi: Double, date: String, cardView: CardView, status: TextView) {
            val entry = History(bmi, date, cardView, status)
            history.add(entry)
        }

        fun getHistory(): List<History> {
            return history.toList()
        }
    }
}
