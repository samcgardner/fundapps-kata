package com.samcgardner.rover

import junit.framework.Assert.assertEquals
import org.junit.Test

class Commands {

    @Test
    fun movesNorth() {
        val initialRover = Rover(0, 0, Direction.N)
        val movedRover = applyCommand(initialRover, Command.F)
        assertEquals(0, movedRover.x)
        assertEquals(1, movedRover.y)
        assertEquals(Direction.N, movedRover.heading)
    }

    @Test
    fun movesEast() {
        val initialRover = Rover(0, 0, Direction.E)
        val movedRover = applyCommand(initialRover, Command.F)
        assertEquals(1 , movedRover.x)
        assertEquals(0, movedRover.y)
        assertEquals(Direction.E, movedRover.heading)
    }

    @Test
    fun movesSouth() {
        val initialRover = Rover(0, 0, Direction.S)
        val movedRover = applyCommand(initialRover, Command.F)
        assertEquals(0, movedRover.x)
        assertEquals(-1, movedRover.y)
        assertEquals(Direction.S, movedRover.heading)
    }

    @Test
    fun movesWest() {
        val initialRover = Rover(0, 0, Direction.W)
        val movedRover = applyCommand(initialRover, Command.F)
        assertEquals(-1, movedRover.x)
        assertEquals(0, movedRover.y)
        assertEquals(Direction.W, movedRover.heading)
    }

    @Test
    fun movesBackwards() {
        val initialRover = Rover(0, 0, Direction.N)
        val movedRover = applyCommand(initialRover, Command.B)
        assertEquals(0, movedRover.x)
        assertEquals(-1, movedRover.y)
        assertEquals(Direction.N, movedRover.heading)
    }

}