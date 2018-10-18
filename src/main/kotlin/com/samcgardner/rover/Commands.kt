package com.samcgardner.rover

import java.lang.Math.abs
import java.util.Collections.rotate

data class Rover(val x : Int, val y : Int, val heading : Direction)
data class Planet(val maxx : Int, val maxy : Int)
enum class Command{F, B, R, L}
enum class Direction{N, S, E, W}

fun move(rover : Rover, planet: Planet, commands : Sequence<String>) : Rover {
    // Don't check for or catch an exception here - if there is an error in our command sequence, we'd like to know
    // about it _before_ we start moving our rover around
    val parsedCommands = commands.map { Command.valueOf(it) }
    return parsedCommands.fold(rover, { myRover, command  -> applyCommand(myRover, planet, command)})
}

fun applyCommand(rover : Rover, planet : Planet, command : Command) : Rover {
    return when(command) {
        Command.F -> move(rover, planet, rover.heading)
        Command.B -> move(rover, planet, invertDirection(rover.heading))
        Command.R -> rover.copy(heading = rotateClockwise(rover.heading))
        Command.L -> rover.copy(heading = invertDirection(rotateClockwise(rover.heading)))
    }
}

fun move(rover : Rover, planet : Planet, direction : Direction) : Rover {
    return when(direction) {
        Direction.N -> rover.copy(y = (rover.y + 1) % planet.maxy)
        Direction.E -> rover.copy(x = (rover.x + 1) % planet.maxx)
        Direction.S -> rover.copy(y = (abs (rover.y - 1)) % planet.maxy)
        Direction.W -> rover.copy(x = (abs (rover.x - 1)) % planet.maxx)
    }
}

fun rotateClockwise(direction : Direction) : Direction {
    return when(direction) {
        Direction.N -> Direction.E
        Direction.E -> Direction.S
        Direction.S -> Direction.W
        Direction.W -> Direction.N
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



