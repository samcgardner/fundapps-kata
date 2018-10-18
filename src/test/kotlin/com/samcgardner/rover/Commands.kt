package com.samcgardner.rover

import junit.framework.TestCase.assertEquals
import org.junit.Test

class Commands {

    val tinyTestPlanet = Planet(2, 2)

    @Test
    fun movesNorth() {
        val initialRover = Rover(0, 0, Direction.N)
        val movedRover = applyCommand(initialRover, tinyTestPlanet,  Command.F)
        assertEquals(0, movedRover.x)
        assertEquals(1, movedRover.y)
        assertEquals(Direction.N, movedRover.heading)
    }

    @Test
    fun movesEast() {
        val initialRover = Rover(0, 0, Direction.E)
        val movedRover = applyCommand(initialRover, tinyTestPlanet, Command.F)
        assertEquals(1 , movedRover.x)
        assertEquals(0, movedRover.y)
        assertEquals(Direction.E, movedRover.heading)
    }

    @Test
    fun movesSouth() {
        val initialRover = Rover(0, 0, Direction.S)
        val movedRover = applyCommand(initialRover, tinyTestPlanet, Command.F)
        assertEquals(0, movedRover.x)
        assertEquals(1, movedRover.y)
        assertEquals(Direction.S, movedRover.heading)
    }

    @Test
    fun movesWest() {
        val initialRover = Rover(0, 0, Direction.W)
        val movedRover = applyCommand(initialRover, tinyTestPlanet, Command.F)
        assertEquals(1, movedRover.x)
        assertEquals(0, movedRover.y)
        assertEquals(Direction.W, movedRover.heading)
    }

    @Test
    fun movesBackwards() {
        val initialRover = Rover(0, 0, Direction.N)
        val movedRover = applyCommand(initialRover, tinyTestPlanet, Command.B)
        assertEquals(0, movedRover.x)
        assertEquals(1, movedRover.y)
        assertEquals(Direction.N, movedRover.heading)
    }

    @Test
    fun turnsNorthToEast() {
        val initialRover = Rover(0, 0, Direction.N)
        val movedRover = applyCommand(initialRover, tinyTestPlanet, Command.R)
        assertEquals(0, movedRover.x)
        assertEquals(0, movedRover.y)
        assertEquals(Direction.E, movedRover.heading)
    }

    @Test
    fun turnsEastToSouth() {
        val initialRover = Rover(0, 0, Direction.E)
        val movedRover = applyCommand(initialRover, tinyTestPlanet, Command.R)
        assertEquals(0, movedRover.x)
        assertEquals(0, movedRover.y)
        assertEquals(Direction.S, movedRover.heading)
    }

    @Test
    fun turnsSouthToWest() {
        val initialRover = Rover(0, 0, Direction.S)
        val movedRover = applyCommand(initialRover, tinyTestPlanet, Command.R)
        assertEquals(0, movedRover.x)
        assertEquals(0, movedRover.y)
        assertEquals(Direction.W, movedRover.heading)
    }


    @Test
    fun turnsWestToNorth() {
        val initialRover = Rover(0, 0, Direction.W)
        val movedRover = applyCommand(initialRover, tinyTestPlanet, Command.R)
        assertEquals(0, movedRover.x)
        assertEquals(0, movedRover.y)
        assertEquals(Direction.N, movedRover.heading)
    }

    @Test
    fun turnsLeft() {
        val initialRover = Rover(0, 0, Direction.N)
        val movedRover = applyCommand(initialRover, tinyTestPlanet, Command.L)
        assertEquals(0, movedRover.x)
        assertEquals(0, movedRover.y)
        assertEquals(Direction.W, movedRover.heading)
    }

}