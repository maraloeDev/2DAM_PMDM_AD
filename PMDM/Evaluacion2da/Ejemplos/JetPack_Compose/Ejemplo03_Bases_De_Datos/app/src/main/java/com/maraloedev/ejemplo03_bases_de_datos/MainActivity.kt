package com.maraloedev.ejemplo03_bases_de_datos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BasesDeDatos()
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)

@Composable
fun BasesDeDatos() {
    val (nombre, setNombre) = remember { mutableStateOf("") }
    val (estado, setEstado) = remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .padding(
                    start = 25.dp,
                    top = 150.dp
                )
        ) {
            Text(
                modifier = Modifier
                    .padding(top = 10.dp),
                fontSize = 25.sp,
                text = "Nombre: "
            )

            TextField(
                modifier = Modifier
                    .width(250.dp),
                value = nombre,
                onValueChange = { setNombre(it) }
            )
        }

        Row(
            modifier = Modifier
                .padding(top = 25.dp)
        ) {
            Checkbox(
                checked = estado,
                onCheckedChange = { setEstado(it) }
            )

            Text(
                modifier = Modifier
                    .padding(top = 15.dp),
                text = if (estado) "Casado" else "Soltero"
            )
        }

        Button(
            onClick = { /* Cuando le des al boton, va hacer algo*/ },
            enabled = true
        ) {
            Text(
                text = "Guardar"
            )
        }
    }
}
