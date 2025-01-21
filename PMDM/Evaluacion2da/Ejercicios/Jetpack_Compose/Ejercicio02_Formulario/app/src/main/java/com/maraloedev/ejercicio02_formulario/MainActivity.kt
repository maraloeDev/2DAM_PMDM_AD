package com.maraloedev.ejercicio02_formulario

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Formulario()

        }
    }

    @Preview(
        showBackground = true, showSystemUi = true
    )
    @Composable
    fun Formulario() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 55.dp)
                .padding(horizontal = 35.dp)
        ) {
            
            Text(
                text = "Nombre"
            )
        }
    }
}