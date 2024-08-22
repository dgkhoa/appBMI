package com.example.calculatorbmi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculatorbmi.R
import com.example.calculatorbmi.databinding.ActivityMainBinding
import com.example.calculatorbmi.fragment.CalculatorBmiFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val calculatorBmiFragment = CalculatorBmiFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame_layout, calculatorBmiFragment)
            commit()
        }
    }
}