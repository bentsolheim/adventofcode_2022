package no.solheim.adventofcode2022.tasks

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day7Test : AdventTest() {

    val example = this.javaClass.getResource("/inputs/day_7_ex.txt")?.readText() ?: ""

    @Test
    fun example() {
        assertThat(Day7(example).dirsPart1).isEqualTo(95_437)
        assertThat(Day7(example).dirsPart2).isEqualTo(24_933_642)
    }

    @Test
    fun input() {
        Day7(input).apply {
            println(Day7(input).dirsPart1)
            println(Day7(input).dirsPart2)
        }
    }
}
