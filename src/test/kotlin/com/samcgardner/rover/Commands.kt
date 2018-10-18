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
        val initialRover = Rover(0, 0, Direction.N)
        val movedRover = applyCommand(initialRover, Command.F)
        assertEquals(0, movedRover.x)
        assertEquals(1, movedRover.y)
        assertEquals(Direction.N, movedRover.heading)
    }

    @Test
    fun movesSouth() {
        val initialRover = Rover(0, 0, Direction.N)
        val movedRover = applyCommand(initialRover, Command.F)
        assertEquals(0, movedRover.x)
        assertEquals(1, movedRover.y)
        assertEquals(Direction.N, movedRover.heading)
    }

    @Test
    fun movesWest() {
        val initialRover = Rover(0, 0, Direction.N)
        val movedRover = applyCommand(initialRover, Command.F)
        assertEquals(0, movedRover.x)
        assertEquals(1, movedRover.y)
        assertEquals(Direction.N, movedRover.heading)
    }

}