package com.samcgardner.rover

data class Rover(val x : Int, val y : Int, val heading : Direction)
enum class Command{F, B}
enum class Direction{N, S, E, W}

fun move(rover : Rover, commands : Sequence<String>) : Rover {
    // Don't check for or catch an exception here - if there is an error in our command sequence, we'd like to know
    // about it _before_ we start moving our rover around
    val parsedCommands = commands.map { Command.valueOf(it) }
    return parsedCommands.fold(rover, { myRover, command  -> applyCommand(myRover, command)})
}

fun applyCommand(rover : Rover, command : Command) : Rover {
    return when(command) {
        Command.F ->
        Command.B ->
    }
}

