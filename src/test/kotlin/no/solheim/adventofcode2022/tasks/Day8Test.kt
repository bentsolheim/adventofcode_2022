package no.solheim.adventofcode2022.tasks

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day8Test : AdventTest() {

    val example = """
30373
25512
65332
33549
35390
    """.trimIndent()

    @Test
    fun example() {
        assertThat(Day8(example).getVisibleTreeCount()).isEqualTo(21)
        assertThat(Day8(example).getHighestScenicScore()).isEqualTo(8)
    }

    @Test
    fun input() {
        println (Day8(input).getVisibleTreeCount())
        println (Day8(input).getHighestScenicScore())
    }
}
