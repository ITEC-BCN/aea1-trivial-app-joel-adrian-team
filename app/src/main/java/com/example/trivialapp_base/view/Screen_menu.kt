package com.example.trivialapp_base.view

import android.R.attr.onClick
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.trivialapp_base.R
import com.example.trivialapp_base.Routes
import com.example.trivialapp_base.viewmodel.GameViewModel
import java.time.format.TextStyle

@SuppressLint("RememberReturnType")
@Composable
fun MenuScreen(navController: NavController, viewModel: GameViewModel) {
    var selectedText by remember {mutableStateOf("")}
    var expanded by remember {mutableStateOf(false)}
    val difficulties = listOf("Easy", "Medium", "Hard")
    Column(
        modifier = Modifier.fillMaxSize().background(Color(0xFF000000)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Main Menu",
            color = Color(0xFF6FFAFF),
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            style = androidx.compose.ui.text.TextStyle(
                shadow = Shadow(
                    color = Color(0xFF00E5FF),
                    blurRadius = 12f
                )
            )
        )

        Image (
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            )

        OutlinedTextField(
            value = selectedText,
            onValueChange = {selectedText = it},
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable { expanded = true }
        )
//Aun falta modificar cosas de aqui
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
        ){
            difficulties.forEach { difficulty ->
                DropdownMenuItem(text = { Text(text = difficulty, color = Color.White) },
                onClick = {
                    expanded = false
                    selectedText = difficulty
                })
            }
        }

        //change the button color to neon purple, and modify gereral format
        Box(modifier = Modifier) {
            Text(
                text = "Play",
                color = Color.White,
                modifier = Modifier
                    .background(Color.Blue)
                    .align(Alignment.Center)
                    .clickable() { navController.navigate(Routes.game.route) })
        }
    }
}