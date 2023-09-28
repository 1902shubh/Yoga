package com.cxzcodes.yoga

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cxzcodes.yoga.databinding.ActivityBmicalculatorBinding
import kotlin.math.pow

class BMICalculator : AppCompatActivity() {
    lateinit var binding: ActivityBmicalculatorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBmicalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener {
            calculateBMI()
        }
    }

    private fun calculateBMI() {
        val weightText = binding.weightEditText.text.toString()
        val heightText = binding.heightEditText.text.toString()

        if (weightText.isEmpty() || heightText.isEmpty()) {
            binding.resultTextView.text = "Please enter weight and height."
            return
        }

        val weight = weightText.toDouble()
        val heightInCm = heightText.toDouble()

         val heightInMeters = heightInCm / 100.0

        val bmi = weight / heightInMeters.pow(2)
        val bmiText = String.format("आपका बीएमआई:: %.2f", bmi)
        binding.resultTextView.text = bmiText
    }
}
