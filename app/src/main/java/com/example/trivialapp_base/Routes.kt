package com.example.trivialapp_base

sealed class Routes(val route: String) {
    object Splash : Routes("splash")
    object menu : Routes("menu")
    object game : Routes("game")
    object score : Routes("score")
}

//DONE
