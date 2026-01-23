package com.example.trivialapp_base.view

import android.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.trivialapp_base.Routes
import com.example.trivialapp_base.viewmodel.GameViewModel

@Composable
fun ResultScreen(navController: NavController, viewModel: GameViewModel, score: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF000000)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "YOUR SCORE",
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
        Spacer(modifier = Modifier.height(70.dp))
        Text(
            text = "$score Points",
            color = Color(0xFF6FFAFF),
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            style = TextStyle(
                shadow = Shadow(
                    color = Color(0xFF00E5FF),
                    blurRadius = 12f
                )
            )
        )
        Image(
            painter = painterResource(id = com.example.trivialapp_base.R.drawable.yeeeeytext),
            contentDescription = "Logo",
        )


        Box(
            modifier = Modifier
                .background(
                    color = Color(0xFFB26CFF),
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp)
                )
                .clickable{navController.navigate(Routes.menu.route)}
                .padding(horizontal = 32.dp, vertical = 12.dp)
        ) {
            Text(
                text = "Share",
                fontSize = 24.sp,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(50.dp))

        Box(
            modifier = Modifier
                .background(
                    color = Color(0xFFB26CFF),
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp)
                )
                .clickable{navController.navigate(Routes.menu.route)}
                .padding(horizontal = 32.dp, vertical = 12.dp)
        ){
            Text(
                text = "Main Menu",
                fontSize = 32.sp,
                color = Color.White
            )
        }
    }

}
