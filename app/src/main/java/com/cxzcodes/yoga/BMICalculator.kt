package com.cxzcodes.yoga

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cxzcodes.helper.Utils
import com.cxzcodes.yoga.databinding.ActivityBmicalculatorBinding
import kotlin.math.pow

class BMICalculator : AppCompatActivity() {
    lateinit var binding: ActivityBmicalculatorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBmicalculatorBinding.inflate(layoutInflater)
        Utils.loadLocale(this)

        setContentView(binding.root)
        binding.calculateButton.setOnClickListener {
            calculateBMI()
        }
        binding.ivback.setOnClickListener {
finish()        }
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
        val bmiText = String.format("BMI:: %.2f", bmi)
        binding.resultTextView.text = bmiText
    }
}
