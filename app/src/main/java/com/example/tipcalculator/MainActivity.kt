package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tipcalculator.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener { calculateTip() }
    }

    private fun calculateTip(){
        val cost_Of_Service = binding.costOfServiceEditText.text.toString().toDoubleOrNull()
        if(cost_Of_Service==null){
            binding.tipResult.text = ""
            return }
        val tipPercentage = when(binding.tipOptions.checkedRadioButtonId){
            R.id.twenty_percent -> 0.20
            R.id.eighteen_percent -> 0.18
            else -> 0.15
        }
        var tip = tipPercentage * cost_Of_Service
        if (binding.roundUpSwitch.isChecked) { tip = ceil(tip)}
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text= getString(R.string.tipResult, formattedTip)
    }

}