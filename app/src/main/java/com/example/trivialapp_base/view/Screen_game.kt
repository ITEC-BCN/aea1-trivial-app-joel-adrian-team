package com.example.trivialapp_base.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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

@Composable
fun GameScreen(navController: NavController, viewModel: GameViewModel) {
    var round by remember { mutableStateOf(1) }//Cambia de valor al clickar respuesta
    val totalRounds = 10 // Número total de rondas

    Box(
        modifier = Modifier.fillMaxSize().background(Color.Black)) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = "Round $round/$totalRounds", color = Color.Magenta,
            modifier = Modifier.padding(bottom = 70.dp),
            fontSize = 18.sp,
        )
        Text(
            text = viewModel.preguntaActual?.pregunta ?: "Pregunta", color = Color.Magenta,
            fontSize = 39.sp,
            modifier = Modifier.padding(bottom = 70.dp)
        )
        Row {
            Button(onClick = {round ++}){
                Text(text = "Answer 1",
                    fontSize = 33.sp,)
            }
            Spacer(modifier = Modifier.width(12.dp))
            Button(onClick = {round ++}){
                Text(text = "Answer 2",
                    fontSize = 33.sp,)
            }
        }
        Spacer(modifier = Modifier.height(40.dp))
        Row {
            Button(onClick = {round ++}){
                Text(text = "Answer 3",
                    fontSize = 33.sp,)
                }
            Spacer(modifier = Modifier.width(12.dp))
            Button(onClick = {round ++}){
                Text(text = "Answer 4",
                    fontSize = 33.sp,)
            }
        }
    }
    }
}
