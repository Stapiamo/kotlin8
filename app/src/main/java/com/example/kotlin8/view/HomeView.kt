package com.example.kotlin8.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.kotlin8.Componentes.InputField
import com.example.kotlin8.Componentes.SegmentedButtonGroup

@Composable
fun HomeView() {
    var selectedGender by remember { mutableStateOf("Hombre") }
    var edad by remember { mutableStateOf("") }
    var peso by remember { mutableStateOf("") }
    var altura by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Título
        Text(
            text = "Calculadora de IMC",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // MultiButton Segmentado
        SegmentedButtonGroup(
            options = listOf("Hombre", "Mujer"),
            selectedOption = selectedGender,
            onOptionSelected = { selectedGender = it }
        )

        // Input para Edad
        InputField(
            value = edad,
            label = "Edad",
            onValueChange = { edad = it }
        )

        // Input para Peso
        InputField(
            value = peso,
            label = "Peso (Kg)",
            onValueChange = { peso = it }
        )

        // Input para Altura
        InputField(
            value = altura,
            label = "Altura (cm)",
            onValueChange = { altura = it }
        )

        Button(
            onClick = {  },
            colors = ButtonDefaults.buttonColors(
                containerColor = when (selectedGender) {
                    "Hombre" -> Color.Blue
                    "Mujer" -> Color.Blue
                    else -> Color.LightGray
                },
                contentColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text(text = "Calcular")
        }
    }
}