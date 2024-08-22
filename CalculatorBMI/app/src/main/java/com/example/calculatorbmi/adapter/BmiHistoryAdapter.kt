package com.example.calculatorbmi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.calculatorbmi.R
import com.example.calculatorbmi.model.History

class BmiHistoryAdapter(private val list: List<History>) :
    RecyclerView.Adapter<BmiHistoryAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val bmiResult: TextView = view.findViewById(R.id.txt_historyBmi)
        val dateHistory: TextView = view.findViewById(R.id.txt_historyDate)
        val img: CardView = view.findViewById(R.id.cardviewHistory)
        val status: TextView = view.findViewById(R.id.txt_sttHistory)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val bmiHistory = list[position]
        holder.bmiResult.text = bmiHistory.bmi.toString()
        holder.dateHistory.text = bmiHistory.date
        holder.img.setCardBackgroundColor(holder.itemView.context.getColor(R.color.white))
        holder.status.text = ""
        when {
            bmiHistory.bmi < 16 -> {
                holder.img.setCardBackgroundColor(holder.itemView.context.getColor(R.color.purple))
                holder.status.text = holder.itemView.context.getString(R.string.underWeight2)
            }

            bmiHistory.bmi in 16.0..16.9 -> {
                holder.img.setCardBackgroundColor(holder.itemView.context.getColor(R.color.darkblue))
                holder.status.text = holder.itemView.context.getString(R.string.underWeight1)
            }

            bmiHistory.bmi in 17.0..18.4 -> {
                holder.img.setCardBackgroundColor(holder.itemView.context.getColor(R.color.lightblue))
                holder.status.text = holder.itemView.context.getString(R.string.underWeight)
            }

            bmiHistory.bmi in 18.5..24.9 -> {
                holder.img.setCardBackgroundColor(holder.itemView.context.getColor(R.color.green))
                holder.status.text = holder.itemView.context.getString(R.string.normal)
            }

            bmiHistory.bmi in 25.0..29.9 -> {
                holder.img.setCardBackgroundColor(holder.itemView.context.getColor(R.color.yellow))
                holder.status.text = holder.itemView.context.getString(R.string.preObese)
            }

            bmiHistory.bmi in 30.0..34.9 -> {
                holder.img.setCardBackgroundColor(holder.itemView.context.getColor(R.color.orange))
                holder.status.text = holder.itemView.context.getString(R.string.obese1)
            }

            bmiHistory.bmi in 35.0..39.9 -> {
                holder.img.setCardBackgroundColor(holder.itemView.context.getColor(R.color.orangeBrown))
                holder.status.text = holder.itemView.context.getString(R.string.obese2)
            }

            bmiHistory.bmi >= 40 -> {
                holder.img.setCardBackgroundColor(holder.itemView.context.getColor(R.color.red))
                holder.status.text = holder.itemView.context.getString(R.string.obese3)
            }
        }
    }
}