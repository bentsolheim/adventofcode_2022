package no.solheim.adventofcode2022.tasks

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day4Test : AdventTest() {

    val example = """2-4,6-8
2-3,4-5
5-7,7-9
2-8,3-7
6-6,4-6
2-6,4-8"""

    @Test
    fun example() {
        Day4(example).apply {
            assertThat(containedIn).isEqualTo(2)
            assertThat(overlaps).isEqualTo(4)
        }
    }

    @Test
    fun input() {
        Day4(input).apply {
            println(containedIn)
            println(overlaps)
        }
    }
}
