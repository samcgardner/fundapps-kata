package com.samcgardner.rover

data class Rover(val foo: String)
data class Command (val foo : String)

fun move(rover : Rover, commands : Sequence<Command>) : Rover {
    return rover
}

