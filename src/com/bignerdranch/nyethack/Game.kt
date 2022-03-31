package com.bignerdranch.nyethack

import java.lang.Exception
import java.util.*

fun main(args: Array<String>) {

    Game.play()

}

object Game {
    private val player = Player("Madrigal")
    private var currentRoom: Room = TownSquare()

    private var worldMap = listOf(
        listOf(currentRoom, Room("Tavern"), Room("Back Room")),
        listOf(Room("Long Coridor"), Room("Generic Room"))
    )

    init {
        println("Welcome, adventurer")
        player.castFireball()
    }

    private class GameInput(arg: String?) {
        private val input = arg ?: ""
        val command = input.split(" ")[0]
        val argument = input.split(" ").getOrElse(1) { "" }

        fun processCommand() = when(command.lowercase(Locale.getDefault())) {
            "move" -> move(argument)
            else -> commandNotFound()
        }

        private fun commandNotFound() = "I'm not quite sure what you're trying to do!"
    }

    fun play() {
        while (true) {
            println(currentRoom.description())
            println(currentRoom.load())
            printPlayerStatus(player)
            print("> Enter your command: ")
            println(GameInput(readLine()).processCommand())
            println()
        }
    }

    private fun move(directionInput: String) =
        try {
            val direction = Direction.valueOf(directionInput.uppercase(Locale.getDefault()))
            val newPosition = direction.updateCoordinate(player.currentPosition)
            if (!newPosition.isInBounds) {
                throw IllegalStateException("$direction is out of bounds.")
            }

            val newRoom = worldMap[newPosition.y][newPosition.x]
            player.currentPosition = newPosition
            currentRoom = newRoom
            "OK, you move $direction to the ${newRoom.name}.\n${newRoom.load()}"
        } catch (e: Exception) {
            "Invalid direction: $directionInput"
        }

    private fun printPlayerStatus(player: Player) {
        println("(Aura: ${player.auraColor(true)}) " +
                "(Blessed: ${if (player.isBlessed) "YES" else "NO"})"
        )
        println("${player.name} ${player.formatHealthStatus(player.healthPoints, player.isBlessed)}")
    }



}



//private fun castFireball(numFireballs: Int = 2) =
//    when(numFireballs) {
//        in 1..10 -> "Tipsy"
//        in 11..20 -> "Sloshed"
//        in 21..30 -> "Soused"
//        in 31..40 -> "Stewed"
//        in 41..50 -> "t0aSt3d"
//        else -> "A glass of Fireball springs into existence. (x$numFireballs)"
//    }

//    println("A glass of Fireball springs into existence. (x$numFireballs)")

