package com.example.trivialapp_base.viewmodel

import android.os.CountDownTimer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.trivialapp_base.model.Pregunta
import com.example.trivialapp_base.model.ProveedorPreguntas

class GameViewModel : ViewModel() {
    private var preguntasPartida: List<Pregunta> = emptyList()

    var indicePreguntaActual by mutableIntStateOf(0)
        private set

    var preguntaActual by mutableStateOf<Pregunta?>(null)
        private set

    var respuestasMezcladas by mutableStateOf<List<String>>(emptyList())
        private set

    var puntuacion by mutableIntStateOf(0)
        private set

    var tiempoRestante by mutableFloatStateOf(100f)
        private set

    var juegoTerminado by mutableStateOf(false)
        private set

    var dificultadSeleccionada by mutableStateOf("Easy")
        private set

    private var timer: CountDownTimer? = null
    private val TIEMPO_POR_PREGUNTA = 10000L

    fun setDificultad(dificultad: String) {
        dificultadSeleccionada = dificultad
    }

    fun iniciarJuego() {
        indicePreguntaActual = 0
        puntuacion = 0
        juegoTerminado = false
        tiempoRestante = 100f
        timer?.cancel() // Cancelamos timer

        // Obtenemos  las preguntas
        val todasLasPreguntas = ProveedorPreguntas.obtenerPreguntas()
            .filterIsInstance<Pregunta>()

        var preguntasFiltradas = todasLasPreguntas.filter {
            it.dificultad.equals(dificultadSeleccionada, ignoreCase = true)
        }

        if (preguntasFiltradas.isEmpty()) {
            val dificultadEsp = when(dificultadSeleccionada) {
                "Easy" -> "Facil"
                "Medium" -> "Medio"
                "Hard" -> "Dificil"
                else -> ""
            }
            preguntasFiltradas = todasLasPreguntas.filter {
                it.dificultad.equals(dificultadEsp, ignoreCase = true)
            }
        }

        // Esto evita que el juego se cierre inmediatamente gemini carreo porque se cerraba solo.
        if (preguntasFiltradas.isEmpty()) {
            println("DEBUG: No se encontraron preguntas para '$dificultadSeleccionada'. Cargando todas.")
            preguntasFiltradas = todasLasPreguntas
        }

        preguntasPartida = preguntasFiltradas.shuffled().take(10)

        if (preguntasPartida.isNotEmpty()) {
            cargarSiguientePregunta()
        } else {
            juegoTerminado = true // Si no hay preguntas, el juego termina
        }
    }

    private fun cargarSiguientePregunta() {
        if (indicePreguntaActual >= preguntasPartida.size) {
            juegoTerminado = true
            timer?.cancel()
            return
        }

        preguntaActual = preguntasPartida[indicePreguntaActual]

        respuestasMezcladas = listOf(
            preguntaActual!!.respuesta1,
            preguntaActual!!.respuesta2,
            preguntaActual!!.respuesta3,
            preguntaActual!!.respuesta4
        ).shuffled()

        iniciarTimer()
    }

    fun responderPregunta(respuestaUsuario: String) {
        timer?.cancel()

        if (respuestaUsuario == preguntaActual?.respuestaCorrecta) {
            puntuacion++
        }

        avanzarRonda()
    }

    private fun avanzarRonda() {
        indicePreguntaActual++
        cargarSiguientePregunta()
    }

    private fun iniciarTimer() {
        timer?.cancel()
        tiempoRestante = 100f

        timer = object : CountDownTimer(TIEMPO_POR_PREGUNTA, 100) {
            override fun onTick(millisUntilFinished: Long) {
                tiempoRestante = (millisUntilFinished.toFloat() / TIEMPO_POR_PREGUNTA * 100f)
            }

            override fun onFinish() {
                tiempoRestante = 0f
                avanzarRonda()
            }
        }.start()
    }

    override fun onCleared() {
        super.onCleared()
        timer?.cancel()
    }
}