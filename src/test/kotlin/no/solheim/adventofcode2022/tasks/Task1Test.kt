package no.solheim.adventofcode2022.tasks

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.core.io.ByteArrayResource

class Task1Test : AdventTest() {

    val example = """1000
2000
3000

4000

5000
6000

7000
8000
9000

10000"""

    @Test
    fun example() {
        Day1(example).apply {
            assertThat(maxCalories).isEqualTo(24000)
            assertThat(top3Sum).isEqualTo(45000)
        }
    }

    @Test
    fun actual() {
        Day1(input).apply {
            println(maxCalories)
            println(top3Sum)
        }
    }
}
