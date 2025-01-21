package com.maraloedev.ejemplo01_hola_jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maraloedev.ejemplo01_hola_jetpack_compose.ui.theme.Ejemplo01_Hola_Jetpack_ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // @Composable = Elemento grafico
        // @Preview = Ver el codigo en tiempo de desarrollo
        //Modificadores = Permiten cambiar la apariencia de los elementos
        setContent {
            Ejemplo01_Hola_Jetpack_ComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android", modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        fontSize = 90.sp,
        lineHeight = 116.sp,
        modifier = modifier
            .padding(16.dp)
            .background(Color.LightGray)
            .padding(8.dp)
    )
}

@Preview(
    showBackground = true, showSystemUi = true
)
@Composable
fun GreetingPreview() {
    Ejemplo01_Hola_Jetpack_ComposeTheme {
        Greeting("DAM")
    }
}

@Preview(showBackground = true)
@Composable
fun Gretting(modifier: Modifier = Modifier) {

    Column(modifier = Modifier) {
        Text("Primero")
        Text("Segundo")
    }

    //La función Column nos va a permitir organizar los elementos de forma vertical.
    // Column {
    //     Text("Primero")
    //    Text("Segundo")
    // }

    //La función Column nos va a permitir organizar los elementos de forma horizontal.

    // Row {
    //    Text("Primero")
    //     Text("Segundo")
    // }

    //La función Box sirve para apilarlos

    // Box {
    //     Text("Primero")
    //     Text("Segundo")
    // }
}

