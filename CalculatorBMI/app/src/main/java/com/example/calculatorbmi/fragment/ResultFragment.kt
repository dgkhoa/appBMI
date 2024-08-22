package com.example.calculatorbmi.fragment

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.calculatorbmi.R
import com.example.calculatorbmi.controller.ResultController
import com.example.calculatorbmi.databinding.FragmentResultBinding
import com.example.calculatorbmi.model.BMIHistory

class ResultFragment : Fragment(R.layout.fragment_result) {

    private lateinit var controller: ResultController
    private lateinit var binding: FragmentResultBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentResultBinding.bind(view)

        val cardView = view.findViewById<CardView>(R.id.cardViewStatus)
        val status = view.findViewById<TextView>(R.id.txt_sttBmi)
        val notification = view.findViewById<TextView>(R.id.txt_notification)
        val linearLayout = view.findViewById<LinearLayout>(R.id.linearLayoutIdeal)

        controller = ResultController()

        // Lấy dữ liệu truyền từ CalculatorBmiFragment
        val bmi = arguments?.getDouble("bmi", 0.0)
        val date = arguments?.getString("date")
        val sex = arguments?.getString("sex")
        val age = arguments?.getString("age")
        val height = arguments?.getDouble("height", 0.0)
        val weight = arguments?.getDouble("weight", 0.0)
        val minIdealWeight = arguments?.getDouble("minIdealWeight", 0.0)
        val maxIdealWeight = arguments?.getDouble("maxIdealWeight", 0.0)

        if (bmi != null && date != null && cardView != null && status != null) {
            BMIHistory.addHistory(bmi, date, cardView, status)
        }

        binding.txtResultBmi.text = bmi.toString()
        binding.txtHeight.text = height.toString()
        binding.txtWeight.text = weight.toString()
        binding.txtMinIdealWeight.text = minIdealWeight.toString()
        binding.txtMaxIdealWeight.text = maxIdealWeight.toString()
        binding.txtDateResult.text = date.toString()
        binding.txtSex.text = sex.toString()
        binding.txtAge.text = age.toString()

        if (bmi != null) {
            controller.setColorForStatus(
                bmi,
                requireContext(),
                cardView,
                status,
                notification,
                linearLayout
            )
        }

        binding.imgBack.setOnClickListener {
            val calculatorBmiFragment = CalculatorBmiFragment()

            calculatorBmiFragment.arguments = Bundle().apply {
                putString("date", date)
                putString("sex", sex)
                putString("age", age)
                putDouble("height", height ?: 0.0)
                putDouble("weight", weight ?: 0.0)
            }
            parentFragmentManager.beginTransaction()
                .replace(R.id.frame_layout, calculatorBmiFragment)
                .addToBackStack(null)
                .commit()
        }

        binding.txtHistory.setOnClickListener {
            val historyFragment = HistoryFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.frame_layout, historyFragment)
                .addToBackStack(null)
                .commit()
        }
    }
}