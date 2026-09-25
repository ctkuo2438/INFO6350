package com.example.addtwonumberscompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.addtwonumberscompose.ui.theme.AddTwoNumbersComposeTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            AddTwoNumbersComposeTheme {

                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    AddTwoNumbers(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun AddTwoNumbers(modifier: Modifier = Modifier) {

    var a by rememberSaveable {
        mutableStateOf("")
    }

    var b by rememberSaveable {
        mutableStateOf("")
    }

    var result by rememberSaveable {
        mutableStateOf("")
    }


    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {

        Text(
            text = "Add Two Numbers",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )


        OutlinedTextField(
            value = a,
            onValueChange = {
                a = it
            },
            label = {
                Text("Enter A")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal
            )
        )


        Spacer(
            modifier = Modifier.height(16.dp)
        )


        OutlinedTextField(
            value = b,
            onValueChange = {
                b = it
            },
            label = {
                Text("Enter B")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal
            )
        )


        Spacer(
            modifier = Modifier.height(16.dp)
        )


        Button(
            onClick = {

                val numA = a.toDoubleOrNull()
                val numB = b.toDoubleOrNull()

                if (numA != null && numB != null) {

                    result = (numA + numB).toString()

                } else {

                    result = "Invalid input"
                }
            }
        ) {

            Text("Add")
        }


        Spacer(
            modifier = Modifier.height(24.dp)
        )


        Text(
            text = "Result: $result",
            style = MaterialTheme.typography.headlineSmall
        )
    }
}


@Preview(showBackground = true)
@Composable
fun AddTwoNumbersPreview() {

    AddTwoNumbersComposeTheme {
        AddTwoNumbers()
    }
}