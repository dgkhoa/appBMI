package com.example.calculatorbmi.controller

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.calculatorbmi.R

class ResultController {
    fun setColorForStatus(
        bmi: Double,
        context: Context,
        cardView: CardView,
        status: TextView,
        notification: TextView,
        idelWight: LinearLayout
    ) {
        val underweightI = context.resources.getString(R.string.underWeight)
        val underweightII = context.resources.getString(R.string.underWeight1)
        val underweightIII = context.resources.getString(R.string.underWeight2)
        val normal = context.resources.getString(R.string.normal)
        val preObese = context.resources.getString(R.string.preObese)
        val obeseClassI = context.resources.getString(R.string.obese1)
        val obeseClassII = context.resources.getString(R.string.obese2)
        val obeseClassIII = context.resources.getString(R.string.obese3)
        val notificaton = context.resources.getString(R.string.notification)
        when {
            bmi < 16 -> {
                val color = ContextCompat.getColor(context, R.color.purple)
                cardView.setCardBackgroundColor(color)
                status.text = underweightI
            }

            bmi in 16.0..16.9 -> {
                val color = ContextCompat.getColor(context, R.color.darkblue)
                cardView.setCardBackgroundColor(color)
                status.text = underweightII
            }

            bmi in 17.0..18.4 -> {
                val color = ContextCompat.getColor(context, R.color.lightblue)
                cardView.setCardBackgroundColor(color)
                status.text = underweightIII
            }

            bmi in 18.5..24.9 -> {
                val color = ContextCompat.getColor(context, R.color.green)
                cardView.setCardBackgroundColor(color)
                status.text = normal
                notification.text = notificaton
                idelWight.visibility = View.GONE
            }

            bmi in 25.0..29.9 -> {
                val color = ContextCompat.getColor(context, R.color.yellow)
                cardView.setCardBackgroundColor(color)
                status.text = preObese
            }

            bmi in 30.0..34.9 -> {
                val color = ContextCompat.getColor(context, R.color.orange)
                cardView.setCardBackgroundColor(color)
                status.text = obeseClassI
            }

            bmi in 35.0..39.9 -> {
                val color = ContextCompat.getColor(context, R.color.orangeBrown)
                cardView.setCardBackgroundColor(color)
                status.text = obeseClassII
            }

            bmi >= 40 -> {
                val color = ContextCompat.getColor(context, R.color.red)
                cardView.setCardBackgroundColor(color)
                status.text = obeseClassIII
            }
        }
    }
}