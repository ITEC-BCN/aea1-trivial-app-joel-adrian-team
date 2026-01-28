package com.example.trivialapp_base

sealed class Routes(val route: String) {
    object menu : Routes("menu")
    object game : Routes("game")
    object score : Routes("score/{score}"){
        fun createRoute(score:Int) = "score/$score"
    }
}

//DONE
