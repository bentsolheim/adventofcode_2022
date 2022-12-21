package no.solheim.adventofcode2022.tasks

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day9Test : AdventTest() {

    val example = """
R 4
U 4
L 3
D 1
R 4
D 1
L 5
R 2        
    """.trim()

    @Test
    fun example() {
        Day9(example)
    }

    @Test
    fun input() {
    }
}
