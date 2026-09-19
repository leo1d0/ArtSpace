package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                ArtSpaceApp()
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {

    var obraActual by remember { mutableStateOf(1) }

    val titulo: String
    val artista: String
    val anio: String
    val simbolo: String
    val colorObra: Color

    when (obraActual) {
        1 -> {
            titulo = "Atardecer en Manta"
            artista = "Leonardo Ortiz"
            anio = "2026"
            simbolo = "☀"
            colorObra = Color(0xFFFFB74D)
        }

        2 -> {
            titulo = "Océano Pacífico"
            artista = "Leonardo Ortiz"
            anio = "2026"
            simbolo = "≈"
            colorObra = Color(0xFF42A5F5)
        }

        else -> {
            titulo = "Noche en la ciudad"
            artista = "Leonardo Ortiz"
            anio = "2026"
            simbolo = "★"
            colorObra = Color(0xFF5C6BC0)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Spacer(modifier = Modifier.height(15.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(vertical = 30.dp)
                .background(colorObra),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = simbolo,
                fontSize = 120.sp,
                color = Color.White
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF2F2F2))
                .padding(20.dp)
        ) {

            Text(
                text = titulo,
                fontSize = 25.sp,
                fontWeight = FontWeight.Normal
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "$artista ($anio)",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(25.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Button(
                onClick = {
                    obraActual =
                        if (obraActual == 1) 3
                        else obraActual - 1
                },
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Anterior",
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.width(20.dp))

            Button(
                onClick = {
                    obraActual =
                        if (obraActual == 3) 1
                        else obraActual + 1
                },
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Siguiente",
                    textAlign = TextAlign.Center
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    MaterialTheme {
        ArtSpaceApp()
    }
}