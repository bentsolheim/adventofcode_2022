package no.solheim.adventofcode2022.tasks

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day3Test : AdventTest() {

    val example = """vJrwpWtwJgWrhcsFMMfFFhFp
jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
PmmdzqPrVvPwwTWBwg
wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
ttgJtRGJQctTZtZT
CrZsJsPPZsGzwwsLwLmpwMDw"""

    @Test
    fun example() {
        Day3(example).apply {
            assertThat(sum).isEqualTo(157)
            assertThat(sum2).isEqualTo(70)
        }
    }

    @Test
    fun input() {
        Day3(input).apply {
            println(sum)
            println(sum2)
        }
    }
}
