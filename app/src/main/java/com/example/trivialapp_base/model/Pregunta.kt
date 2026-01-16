package com.example.trivialapp_base.model

// Definición de la clase de datos Pregunta según requisitos
data class Pregunta(
    val pregunta: String,
    val categoria: String,
    val dificultad: String, // "Facil", "Medio", "Dificil"
    val respuesta1: String,
    val respuesta2: String,
    val respuesta3: String,
    val respuesta4: String,
    val respuestaCorrecta: String // Debe coincidir con una de las anteriores
)

// Objeto para simular la base de datos local (Hardcoded)
object ProveedorPreguntas {
    fun obtenerPreguntas(): MutableList<Any> {
        return mutableListOf(
            Pregunta("¿Cuál fue la primera consola doméstica?", "Historia", "Medio", "Atari 2600", "Magnavox Odyssey", "NES", "ColecoVision", "Magnavox Odyssey"),
            Pregunta("¿En qué año se lanzó Super Mario Bros?", "Historia", "Facil", "1983", "1985", "1987", "1990", "1985"),
            Pregunta("¿Empresa creadora de Sonic?", "Industria", "Facil", "Nintendo", "Sony", "SEGA", "Capcom", "SEGA"),
            Pregunta("¿Primer videojuego comercial de la historia?", "Historia", "Dificil", "Pong", "Space Invaders", "Computer Space", "Asteroids", "Computer Space"),
            Pregunta("¿Color original de Mario?", "Curiosidades", "Medio", "Rojo y azul", "Verde y marrón", "Rojo y marrón", "Azul y amarillo", "Rojo y marrón"),
            Pregunta("¿Nombre del creador de Mario?", "Industria", "Facil", "Hideo Kojima", "Shigeru Miyamoto", "Satoru Iwata", "Yu Suzuki", "Shigeru Miyamoto"),
            Pregunta("¿Primera consola de Sony?", "Historia", "Facil", "PlayStation 2", "PlayStation", "PS One", "PSX", "PlayStation"),
            Pregunta("¿Videojuego más vendido de la historia?", "Datos", "Facil", "GTA V", "Minecraft", "Tetris", "Wii Sports", "Minecraft"),
            Pregunta("¿Saga famosa por el código Konami?", "Curiosidades", "Medio", "Mario", "Castlevania", "Contra", "Zelda", "Contra"),
            Pregunta("¿En qué juego aparece por primera vez Luigi?", "Historia", "Medio", "Mario Bros", "Super Mario Bros", "Donkey Kong", "Luigi’s Mansion", "Mario Bros"),
            Pregunta("¿Mascota de Nintendo?", "Industria", "Facil", "Link", "Mario", "Pikachu", "Kirby", "Mario"),
            Pregunta("¿Consola portátil de Nintendo lanzada en 1989?", "Historia", "Facil", "Game Gear", "Game Boy", "DS", "PSP", "Game Boy"),
            Pregunta("¿Nombre del reino de Zelda?", "Saga", "Facil", "Midgar", "Hyrule", "Termina", "Kanto", "Hyrule"),
            Pregunta("¿Empresa creadora de PlayStation?", "Industria", "Facil", "Microsoft", "Nintendo", "Sony", "SEGA", "Sony"),
            Pregunta("¿Primer Pokémon de la Pokédex?", "Saga", "Facil", "Pikachu", "Bulbasaur", "Charmander", "Mew", "Bulbasaur"),
            Pregunta("¿En qué año salió el primer Pokémon?", "Historia", "Medio", "1994", "1996", "1998", "2000", "1996"),
            Pregunta("¿Nombre del protagonista de The Legend of Zelda?", "Saga", "Facil", "Zelda", "Link", "Ganondorf", "Epona", "Link"),
            Pregunta("¿Primer juego de la saga GTA?", "Historia", "Dificil", "GTA III", "GTA Vice City", "Grand Theft Auto", "GTA San Andreas", "Grand Theft Auto"),
            Pregunta("¿Compañía creadora de Halo?", "Industria", "Medio", "Bethesda", "Bungie", "343 Industries", "EA", "Bungie"),
            Pregunta("¿Consola más vendida de la historia?", "Datos", "Facil", "PS2", "Nintendo DS", "PS4", "Wii", "PS2"),
            Pregunta("¿Personaje principal de Metroid?", "Saga", "Medio", "Samus Aran", "Ridley", "Link", "Fox", "Samus Aran"),
            Pregunta("¿Primer juego de Mario?", "Historia", "Dificil", "Mario Bros", "Donkey Kong", "Super Mario Bros", "Wrecking Crew", "Donkey Kong"),
            Pregunta("¿Empresa creadora de Minecraft?", "Industria", "Facil", "Valve", "Epic Games", "Mojang", "Microsoft", "Mojang"),
            Pregunta("¿En qué juego nació Lara Croft?", "Saga", "Facil", "Uncharted", "Tomb Raider", "Prince of Persia", "Assassin’s Creed", "Tomb Raider"),
            Pregunta("¿Consola rival directa de la SNES?", "Historia", "Medio", "PlayStation", "Mega Drive", "Atari Jaguar", "Neo Geo", "Mega Drive"),
            Pregunta("¿Nombre del villano principal de Mario?", "Saga", "Facil", "Bowser", "Wario", "Donkey Kong", "Koopa", "Bowser"),
            Pregunta("¿Primer juego de la saga Final Fantasy?", "Historia", "Medio", "Final Fantasy II", "Final Fantasy", "Final Fantasy VII", "Final Fantasy X", "Final Fantasy"),
            Pregunta("¿Empresa creadora de Street Fighter?", "Industria", "Facil", "SNK", "Capcom", "SEGA", "Namco", "Capcom"),
            Pregunta("¿Consola de Microsoft?", "Industria", "Facil", "PlayStation", "Xbox", "GameCube", "Dreamcast", "Xbox"),
            Pregunta("¿En qué juego aparece Kratos?", "Saga", "Facil", "God of War", "Assassin’s Creed", "Dark Souls", "Skyrim", "God of War"),
            Pregunta("¿Primer Zelda lanzado?", "Historia", "Medio", "Ocarina of Time", "The Legend of Zelda", "A Link to the Past", "Majora’s Mask", "The Legend of Zelda"),
            Pregunta("¿Saga famosa por sigilo y cajas?", "Curiosidades", "Medio", "Splinter Cell", "Metal Gear", "Hitman", "Deus Ex", "Metal Gear"),
            Pregunta("¿Nombre del hermano malvado de Mario?", "Saga", "Facil", "Waluigi", "Bowser", "Wario", "Luigi", "Wario"),
            Pregunta("¿Juego famoso por el mensaje 'Finish Him'?", "Curiosidades", "Facil", "Street Fighter", "Tekken", "Mortal Kombat", "Killer Instinct", "Mortal Kombat"),
            Pregunta("¿Empresa creadora de Assassin’s Creed?", "Industria", "Facil", "EA", "Ubisoft", "Bethesda", "Activision", "Ubisoft"),
            Pregunta("¿Primer FPS popular en PC?", "Historia", "Dificil", "Quake", "Doom", "Wolfenstein 3D", "Half-Life", "Wolfenstein 3D"),
            Pregunta("¿Saga famosa por mundos cúbicos?", "Curiosidades", "Facil", "Terraria", "Roblox", "Minecraft", "Fortnite", "Minecraft"),
            Pregunta("¿Nombre del protagonista de Halo?", "Saga", "Facil", "Marcus Fenix", "Master Chief", "Doomguy", "Shepard", "Master Chief"),
            Pregunta("¿Empresa creadora de The Witcher?", "Industria", "Medio", "CD Projekt", "Bethesda", "Bioware", "FromSoftware", "CD Projekt"),
            Pregunta("¿Primer juego de Pokémon en España?", "Historia", "Medio", "Rojo y Azul", "Amarillo", "Oro y Plata", "Verde", "Rojo y Azul"),
            Pregunta("¿Saga conocida por morir muchas veces?", "Curiosidades", "Facil", "Dark Souls", "Devil May Cry", "Skyrim", "Zelda", "Dark Souls"),
            Pregunta("¿Consola de SEGA con lector de CD?", "Historia", "Dificil", "Saturn", "Mega Drive", "Dreamcast", "Master System", "Saturn"),
            Pregunta("¿Juego battle royale más popular?", "Datos", "Facil", "PUBG", "Apex Legends", "Fortnite", "Warzone", "Fortnite"),
            Pregunta("¿Empresa creadora de Pac-Man?", "Industria", "Facil", "SEGA", "Namco", "Atari", "Nintendo", "Namco"),
            Pregunta("¿Año de lanzamiento de Pac-Man?", "Historia", "Dificil", "1978", "1980", "1982", "1985", "1980"),
            Pregunta("¿Saga de terror con Raccoon City?", "Saga", "Facil", "Silent Hill", "Resident Evil", "Dead Space", "Outlast", "Resident Evil"),
            Pregunta("¿Nombre del protagonista de God of War?", "Saga", "Facil", "Kratos", "Ares", "Zeus", "Atreus", "Kratos"),
            Pregunta("¿Cual és el pokemon que se conoce como el guardian del mar?","Pokemon", "Medio", "Kyogre", "Magikarp", "Lapras", "Lugia", "Lugia")
        )
    }
}