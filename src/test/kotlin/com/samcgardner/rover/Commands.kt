package com.samcgardner.rover

import junit.framework.TestCase.assertEquals
import org.junit.Test

class Commands {

    val tinyTestPlanet = Planet(2, 2)
    val emptyObstacles = emptySet<Obstacle>()

    @Test
    fun movesNorth() {
        val initialRover = Rover(0, 0, Direction.N, false)
        val movedRover = applyCommand(initialRover, tinyTestPlanet, emptyObstacles, Command.F)
        assertEquals(0, movedRover.x)
        assertEquals(1, movedRover.y)
        assertEquals(Direction.N, movedRover.heading)
    }

    @Test
    fun movesEast() {
        val initialRover = Rover(0, 0, Direction.E, false)
        val movedRover = applyCommand(initialRover, tinyTestPlanet, emptyObstacles, Command.F)
        assertEquals(1 , movedRover.x)
        assertEquals(0, movedRover.y)
        assertEquals(Direction.E, movedRover.heading)
    }

    @Test
    fun movesSouth() {
        val initialRover = Rover(0, 0, Direction.S, false)
        val movedRover = applyCommand(initialRover, tinyTestPlanet, emptyObstacles, Command.F)
        assertEquals(0, movedRover.x)
        assertEquals(1, movedRover.y)
        assertEquals(Direction.S, movedRover.heading)
    }

    @Test
    fun movesWest() {
        val initialRover = Rover(0, 0, Direction.W, false)
        val movedRover = applyCommand(initialRover, tinyTestPlanet, emptyObstacles, Command.F)
        assertEquals(1, movedRover.x)
        assertEquals(0, movedRover.y)
        assertEquals(Direction.W, movedRover.heading)
    }

    @Test
    fun movesBackwards() {
        val initialRover = Rover(0, 0, Direction.N, false)
        val movedRover = applyCommand(initialRover, tinyTestPlanet, emptyObstacles, Command.B)
        assertEquals(0, movedRover.x)
        assertEquals(1, movedRover.y)
        assertEquals(Direction.N, movedRover.heading)
    }

    @Test
    fun turnsNorthToEast() {
        val initialRover = Rover(0, 0, Direction.N, false)
        val movedRover = applyCommand(initialRover, tinyTestPlanet, emptyObstacles, Command.R)
        assertEquals(0, movedRover.x)
        assertEquals(0, movedRover.y)
        assertEquals(Direction.E, movedRover.heading)
    }

    @Test
    fun turnsEastToSouth() {
        val initialRover = Rover(0, 0, Direction.E, false)
        val movedRover = applyCommand(initialRover, tinyTestPlanet, emptyObstacles, Command.R)
        assertEquals(0, movedRover.x)
        assertEquals(0, movedRover.y)
        assertEquals(Direction.S, movedRover.heading)
    }

    @Test
    fun turnsSouthToWest() {
        val initialRover = Rover(0, 0, Direction.S, false)
        val movedRover = applyCommand(initialRover, tinyTestPlanet, emptyObstacles, Command.R)
        assertEquals(0, movedRover.x)
        assertEquals(0, movedRover.y)
        assertEquals(Direction.W, movedRover.heading)
    }


    @Test
    fun turnsWestToNorth() {
        val initialRover = Rover(0, 0, Direction.W, false)
        val movedRover = applyCommand(initialRover, tinyTestPlanet, emptyObstacles, Command.R)
        assertEquals(0, movedRover.x)
        assertEquals(0, movedRover.y)
        assertEquals(Direction.N, movedRover.heading)
    }

    @Test
    fun turnsLeft() {
        val initialRover = Rover(0, 0, Direction.N, false)
        val movedRover = applyCommand(initialRover, tinyTestPlanet, emptyObstacles, Command.L)
        assertEquals(0, movedRover.x)
        assertEquals(0, movedRover.y)
        assertEquals(Direction.W, movedRover.heading)
    }

    @Test
    fun detectsObstacles() {
        val obstacle = setOf<Obstacle>(Obstacle(0, 1))
        val initialRover = Rover(0, 0, Direction.N, false)
        val movedRover = applyCommand(initialRover, tinyTestPlanet, obstacle, Command.F)
        assertEquals(0, movedRover.x)
        assertEquals(0, movedRover.y)
        assertEquals(Direction.N, movedRover.heading)
        assertEquals(true, movedRover.stuck)
    }

    @Test
    fun doesNotMoveWhileStuck() {
        val initialRover = Rover(0, 0, Direction.N, true)
        val movedRover = applyCommand(initialRover, tinyTestPlanet, emptyObstacles, Command.F)
        assertEquals(0, movedRover.x)
        assertEquals(0, movedRover.y)
        assertEquals(Direction.N, movedRover.heading)
    }

}