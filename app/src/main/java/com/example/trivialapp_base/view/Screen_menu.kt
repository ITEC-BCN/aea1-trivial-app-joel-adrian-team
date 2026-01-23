package com.example.trivialapp_base.view

import android.R.attr.enabled
import android.R.attr.onClick
import android.R.attr.type
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.trivialapp_base.R
import com.example.trivialapp_base.Routes
import com.example.trivialapp_base.viewmodel.GameViewModel
import androidx.compose.ui.text.TextStyle
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Alignment


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("RememberReturnType")
@Composable
fun MenuScreen(navController: NavController, viewModel: GameViewModel) {

    var selectedText by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val difficulties = listOf("Easy", "Medium", "Hard")

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Main Menu",
                color = Color(0xFF6FFAFF),
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold
            )

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
            )

            ExposedDropdownMenuBox(
                expanded = expanded, onExpandedChange = { expanded = !expanded }
            )
            {
                OutlinedTextField(
                    value = selectedText,
                    onValueChange = {},
                    readOnly = true, enabled = true,
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth(0.6f),
                    placeholder = { Text("Difficulty", color = Color.Black) },
                    trailingIcon = {

                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                                   },
                    textStyle = TextStyle(color = Color.Black),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedBorderColor = Color.Black,
                        unfocusedBorderColor = Color.Gray,
                        disabledTextColor = Color.Black
                    )
                )
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier ) {
                    difficulties.forEach { difficulty ->
                        DropdownMenuItem( text = { Text(text = difficulty) },
                            onClick = { selectedText = difficulty
                                expanded = false
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(180.dp))

            Box(
                modifier = Modifier
                    .background(
                        Color(0xFFB26CFF),
                        androidx.compose.foundation.shape.RoundedCornerShape(12.dp)
                    )
                    .clickable { navController.navigate(Routes.game.route) }
                    .padding(horizontal = 32.dp, vertical = 12.dp)
            ) {
                Text("Play", fontSize = 24.sp, color = Color.White)
            }
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(80.dp)
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            Icon(Icons.Default.Email, contentDescription = null)
        }
    }
}

