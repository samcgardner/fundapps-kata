package com.samcgardner.rover

import java.lang.Math.abs

data class Rover(val x : Int, val y : Int, val heading : Direction)
data class Planet(val maxx : Int, val maxy : Int)
data class Obstacle(val x : Int, val y : Int)
enum class Command{F, B, R, L}
enum class Direction{N, S, E, W}

fun move(rover : Rover, planet: Planet, obstacles : Set<Obstacle>, commands : Sequence<String>) : Rover {
    // Don't check for or catch an exception here - if there is an error in our command sequence, we'd like to know
    // about it _before_ we start moving our rover around
    val parsedCommands = commands.map { Command.valueOf(it) }
    return parsedCommands.fold(rover, { myRover, command  -> applyCommand(myRover, planet, obstacles, command)})
}

fun applyCommand(rover : Rover, planet : Planet, obstacles: Set<Obstacle>, command : Command) : Rover {
    return when(command) {
        Command.F -> move(rover, planet, obstacles, rover.heading)
        Command.B -> move(rover, planet, obstacles, invertDirection(rover.heading))
        Command.R -> rover.copy(heading = rotateClockwise(rover.heading))
        Command.L -> rover.copy(heading = invertDirection(rotateClockwise(rover.heading)))
    }
}

fun move(rover : Rover, planet : Planet, obstacles: Set<Obstacle>, direction : Direction) : Rover {
    return when(direction) {
        Direction.N -> rover.copy(y = (rover.y + 1) % planet.maxy)
        Direction.E -> rover.copy(x = (rover.x + 1) % planet.maxx)
        // We take absolutes here because Kotlin's % operator doesn't do this by default even though it should
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



