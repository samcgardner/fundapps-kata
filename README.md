# fundapps-kata

This project implements the FundApps code test kata. It provides a library function, `move`, which can move a simulated rover
around the surface of a simulated planet whilst detecting collisions with simulated obstacles. Note that it uses a co-ordinate
system ranging between (0, max-x) and (0, max-y) and does not permit negative co-ordinates.

# Example Usage

```kotlin
    val pluto = Planet(100, 100)
    val emptyObstacles = emptySet<Obstacle>()
    val initialRover = Rover(0, 0, Direction.N, false)
    val commands = seqOf("F", "F")
    val movedRover = applyCommand(initialRover, pluto, emptyObstacles, commands)
    // Show our new rover in all its glory
    println(movedRover.toString())
```

# Tests

The test suite can be run with `./gradlew clean test`
