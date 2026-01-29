package com.example.trivialapp_base.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.trivialapp_base.Routes
import com.example.trivialapp_base.viewmodel.GameViewModel
import androidx.compose.material3.LinearProgressIndicator


@Composable
fun GameScreen(navController: NavController, viewModel: GameViewModel) {
    val pregunta = viewModel.preguntaActual
    val respuestas = viewModel.respuestasMezcladas
    val rondaActual = viewModel.indicePreguntaActual + 1
    val totalRounds = 10 // Número total de rondas
    val tiempoRestante by viewModel::tiempoRestante

    Box(
        modifier = Modifier.fillMaxSize().background(Color.Black)) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = "Round $rondaActual/$totalRounds", color = Color.Magenta,
            modifier = Modifier.padding(bottom = 70.dp),
            fontSize = 18.sp,
        )
        Text(
            text = pregunta?.pregunta ?: "Cargando...",
            color = Color.Magenta,
            fontSize = 30.sp,
            lineHeight = 35.sp,
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 50.dp),
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )
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
                .fillMaxWidth()
                .height(8.dp),
            color = Color.Magenta,
            trackColor = Color.DarkGray,
        )
    }
    }
}

@Composable
fun BotonRespuesta(texto: String, viewModel: GameViewModel) {
    TODO("Not yet implemented")
}

//REVISAR
