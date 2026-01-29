package com.example.trivialapp_base.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.trivialapp_base.Routes
import com.example.trivialapp_base.viewmodel.GameViewModel

@Composable
fun GameScreen(navController: NavController, viewModel: GameViewModel) {
    val pregunta = viewModel.preguntaActual
    val respuestas = viewModel.respuestasMezcladas
    val rondaActual = viewModel.indicePreguntaActual + 1
    val totalRounds = 10

    if (viewModel.juegoTerminado) {
        LaunchedEffect(Unit) {
            navController.navigate(Routes.score.createRoute(viewModel.puntuacion)) {
                popUpTo(Routes.menu.route) { inclusive = false }
            }
        }
    }

    Box(
        modifier = Modifier.fillMaxSize().background(Color.Black)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Indicador de Ronda
            Text(
                text = "Round $rondaActual/$totalRounds",
                color = Color.Magenta,
                modifier = Modifier.padding(bottom = 35.dp),
                fontSize = 24.sp,
            )

            // Texto de la Pregunta
            Text(
                text = pregunta?.pregunta ?: "Cargando...",
                color = Color.Magenta,
                fontSize = 30.sp,
                lineHeight = 35.sp,
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 50.dp),
                textAlign = TextAlign.Center
            )

            // Botones de respuesta
            if (respuestas.size >= 4) {
                Row {
                    BotonRespuesta(texto = respuestas[0], viewModel = viewModel)
                    Spacer(modifier = Modifier.width(12.dp))
                    BotonRespuesta(texto = respuestas[1], viewModel = viewModel)
                }
                Spacer(modifier = Modifier.height(40.dp))
                Row {
                    BotonRespuesta(texto = respuestas[2], viewModel = viewModel)
                    Spacer(modifier = Modifier.width(12.dp))
                    BotonRespuesta(texto = respuestas[3], viewModel = viewModel)
                }
            }

            Spacer(modifier = Modifier.height(70.dp))

            // Timer
            LinearProgressIndicator(
                progress = { viewModel.tiempoRestante / 100f },
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(8.dp),
                color = Color.Magenta,
                trackColor = Color.DarkGray,
            )
        }
    }
}

@Composable
fun BotonRespuesta(texto: String, viewModel: GameViewModel) {
    Button(
        onClick = { viewModel.responderPregunta(texto) },
        modifier = Modifier
            .width(160.dp)
            .height(60.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.DarkGray
        )
    ) {
        Text(
            text = texto,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            color = Color.White
        )
    }
}
//Revisar