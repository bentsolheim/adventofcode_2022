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

    val example2 = """
R 5
U 8
L 8
D 3
R 17
D 10
L 25
U 20        
    """.trim()

    @Test
    fun example() {
        assertThat(Day9(example, 2).getTailTouchCount()).isEqualTo(13)
        assertThat(Day9(example2, 10).getTailTouchCount()).isEqualTo(36)
    }

    @Test
    fun input() {
        // println(Day9(input, 2).getTailTouchCount())
        // println(Day9(input, 10).getTailTouchCount())
        assertThat(Day9(input, 2).getTailTouchCount()).isEqualTo(6354)
        assertThat(Day9(input, 10).getTailTouchCount()).isEqualTo(2651)
    }
}
