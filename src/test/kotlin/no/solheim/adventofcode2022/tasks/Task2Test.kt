package no.solheim.adventofcode2022.tasks

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Task2Test : AdventTest() {

    val example = """A Y
B X
C Z"""

    @Test
    fun example() {
        Day2(example).apply {
            assertThat(sumFirstStrategy).isEqualTo(15)
            assertThat(sumSecondStrategy).isEqualTo(12)
        }
    }

    @Test
    fun actual() {
        Day2(input).apply {
            println(sumFirstStrategy)
            println(sumSecondStrategy)
        }
    }
}
