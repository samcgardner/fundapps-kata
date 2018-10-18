package com.samcgardner.rover

data class Rover(val x : Int, val y : Int, val heading : Direction)
enum class Command{F, B, R, L}
enum class Direction{N, S, E, W}

fun move(rover : Rover, commands : Sequence<String>) : Rover {
    // Don't check for or catch an exception here - if there is an error in our command sequence, we'd like to know
    // about it _before_ we start moving our rover around
    val parsedCommands = commands.map { Command.valueOf(it) }
    return parsedCommands.fold(rover, { myRover, command  -> applyCommand(myRover, command)})
}

fun applyCommand(rover : Rover, command : Command) : Rover {
    return when(command) {
        Command.F -> move(rover, rover.heading)
        Command.B -> move(rover, invertDirection(rover.heading))
        Command.R -> rover
        Command.L -> rover
    }
}

fun move(rover : Rover, direction : Direction) : Rover {
    return when(direction) {
        Direction.N -> rover.copy(y = rover.y + 1)
        Direction.E -> rover.copy(x = rover.x + 1)
        Direction.S -> rover.copy(y = rover.y - 1)
        Direction.W -> rover.copy(x = rover.x - 1)
    }
}

fun invertDirection(direction : Direction) : Direction {
    return when(direction) {
        Direction.N -> Direction.S
        Direction.E -> Direction.W
        Direction.S -> Direction.N
        Direction.W -> Direction.E
    }
}

