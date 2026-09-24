package com.example.addtwonumbers

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // get the ID editTextA's EditText, and let the editTextA point to it
        val editTextA = findViewById<EditText>(R.id.editTextA)
        val editTextB = findViewById<EditText>(R.id.editTextB)
        val buttonAdd = findViewById<Button>(R.id.buttonAdd)
        val textResult = findViewById<TextView>(R.id.textResult)

        buttonAdd.setOnClickListener {
            val a = editTextA.text.toString().toDouble()
            val b = editTextB.text.toString().toDouble()

            val result = a + b

            textResult.text = "Result: $result"
        }
    }
}