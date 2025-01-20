package com.maraloedev.ejemplo02_variables

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InterfazPrincipal()
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun InterfazPrincipal() {
    // by remember es para que no se pierda el valor de la variable
    var nombrePersona by remember { mutableStateOf("") }
    var edadPersona by remember { mutableStateOf(0) }
    var isVisibility by remember { mutableStateOf(true) }
    var mostrarDatos by remember { mutableStateOf(false) }
    val listaPersonas = remember { mutableStateListOf<Persona>() }
    val radioButtonOption = listOf("Hombre", "Mujer")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioButtonOption[0]) }

    if (isVisibility) {
        Column {
            // Fila para el saludo y el campo de texto
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Hola", modifier = Modifier.weight(0.25f))
                TextField(value = nombrePersona, onValueChange = { nombrePersona = it })
            }

            // Fila para el botón de incrementar edad y mostrar la edad
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth()
            ) {
                Button(onClick = { edadPersona++ }) {
                    Text(text = "Pulsa para incrementar")
                }
                Text(
                    edadPersona.toString(),
                    fontSize = 20.sp,
                    modifier = Modifier.padding(horizontal = 15.dp)
                )
            }

            // Fila para el botón de saludar
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth()
            ) {
                Button(onClick = { /* Acción de saludo */ }) {
                    Text(text = "Pulsa para saludar")
                }
            }

            // Fila para los botones de radio y el botón de mostrar datos
            Row {
                Column(modifier = Modifier.selectableGroup()) {
                    radioButtonOption.forEach { sexo ->
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .height(56.dp)
                                .selectable(
                                    selected = (sexo == selectedOption),
                                    onClick = { onOptionSelected(sexo) },
                                    role = Role.RadioButton
                                )
                                .padding(horizontal = 16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(selected = (sexo == selectedOption), onClick = null)
                            Text(
                                text = sexo,
                                style = MaterialTheme.typography.bodyLarge,
                                modifier = Modifier.padding(start = 16.dp)
                            )
                        }
                    }

                    // Cuando le des al botón de Mostrar datos, se añadirá el sexo a la lista
                    Button(
                        onClick = {
                            listaPersonas.add(Persona(nombrePersona, edadPersona, selectedOption))
                            mostrarDatos = true // Muestro los datos
                        }
                    ) {
                        Text("Mostrar datos")
                    }
                }
            }

            // Mostrar la lista de personas usando LazyColumn
            LazyColumn(
                modifier = Modifier
                    .padding(vertical = 25.dp)
            ) {
                
                items(listaPersonas) { item ->
                    Text(
                        text = item.nombre,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    } else {
        // Botón para mostrar el formulario de nuevo
        Button(onClick = { isVisibility = true }) {
            Text("Volver")
        }

        // Texto para mostrar los datos de la persona
        Text("Hola ${listaPersonas.lastOrNull()?.nombre ?: ""} ${selectedOption}")
    }
}