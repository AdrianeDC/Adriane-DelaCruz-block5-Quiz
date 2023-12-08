package com.delacruz.adriane.block5.p1.quiz


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var number1EditText: EditText
    private lateinit var number2EditText: EditText
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        number1EditText = findViewById(R.id.number1EditText)
        number2EditText = findViewById(R.id.number2EditText)
        resultTextView = findViewById(R.id.resultTextView)
    }

    fun onButtonClick(view: View) {
        val number1Str = number1EditText.text.toString()
        val number2Str = number2EditText.text.toString()

        if (number1Str.isEmpty() || number2Str.isEmpty()) {
            resultTextView.text = "Please enter both numbers"
            return
        }

        try {
            val number1 = number1Str.toDouble()
            val number2 = number2Str.toDouble()

            when (view.id) {
                R.id.btnAdd -> resultTextView.text = "Result: ${number1 + number2}"
                R.id.btnSubtract -> resultTextView.text = "Result: ${number1 - number2}"
                R.id.btnMultiply -> resultTextView.text = "Result: ${number1 * number2}"
                R.id.btnDivide -> {
                    if (number2 != 0.0) {
                        resultTextView.text = "Result: ${number1 / number2}"
                    } else {
                        resultTextView.text = "Cannot divide by zero"
                    }
                }
            }
        } catch (e: NumberFormatException) {
            resultTextView.text = "Please enter valid numbers"
        }
    }
}