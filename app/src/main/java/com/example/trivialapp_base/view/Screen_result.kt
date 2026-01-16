package com.example.trivialapp_base.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.trivialapp_base.Routes
import com.example.trivialapp_base.viewmodel.GameViewModel

@Composable
fun ResultScreen(navController: NavController, viewModel: GameViewModel) {
    Box(
        modifier = Modifier.fillMaxSize().background(Color.Green)) {
        Text(
            text = "Pantalla 4",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable() { navController.navigate(Routes.menu.route) })
    }
}
