package no.solheim.adventofcode2022.tasks

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day10Test : AdventTest() {

    val example = this.javaClass.getResource("/inputs/day_9_ex.txt")?.readText() ?: ""

    @Test
    fun example() {
        assertThat(Day10(example).getSignalStrengthSampleSums()).isEqualTo(13140)
    }

    @Test
    fun input() {
        println(Day10(input).getSignalStrengthSampleSums())
    }
}
