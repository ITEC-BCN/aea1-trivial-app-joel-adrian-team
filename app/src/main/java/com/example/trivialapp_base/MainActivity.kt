package com.example.trivialapp_base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AdUnits
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.ThumbUpAlt
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.trivialapp_base.ui.theme.TrivialAPP_BaseTheme
import com.example.trivialapp_base.view.GameScreen
import com.example.trivialapp_base.view.MenuScreen
import com.example.trivialapp_base.view.ResultScreen
import com.example.trivialapp_base.viewmodel.GameViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TrivialAPP_BaseTheme {
                val navController = rememberNavController()
                val myViewModel by viewModels<GameViewModel>()

                Box(modifier = Modifier.fillMaxSize()) {

                    NavHost(
                        navController = navController,
                        startDestination = Routes.menu.route
                    ) {
                        composable(Routes.menu.route) { MenuScreen(navController, myViewModel) }
                        composable(Routes.game.route) { GameScreen(navController, myViewModel) }
                        composable(
                            Routes.score.route,
                            arguments = listOf(navArgument("score") { type = NavType.IntType })
                        ) { backStackEntry ->
                            ResultScreen(
                                navController,
                                myViewModel,
                                backStackEntry.arguments?.getInt("score") ?: 0,
                            )
                        }
                    }

                    Row(
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .fillMaxWidth()
                            .height(80.dp)
                            .background(Color.White),
                         horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(Icons.Filled.Email, contentDescription = "Email")
                        Spacer(modifier = Modifier.width(46.dp))
                        Icon(Icons.Filled.Phone, contentDescription = "Phone")
                        Spacer(modifier = Modifier.width(46.dp))
                        Icon(Icons.Filled.ThumbUpAlt, contentDescription = "ThumbUpAlt")
                        Spacer(modifier = Modifier.width(46.dp))
                        Icon(Icons.Filled.Notifications, contentDescription = "Notifications")
                    }
                }
            }
        }
    }
}
