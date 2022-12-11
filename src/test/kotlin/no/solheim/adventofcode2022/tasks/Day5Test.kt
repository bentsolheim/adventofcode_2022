package no.solheim.adventofcode2022.tasks

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day5Test : AdventTest() {

    val example = """
    [D]    
[N] [C]    
[Z] [M] [P]
 1   2   3 

move 1 from 2 to 1
move 3 from 1 to 3
move 2 from 2 to 1
move 1 from 1 to 2
    """

    @Test
    fun example() {
        Day5(example.substring(example.indexOf('\n')+1)).apply {
            assertThat(crateCode).isEqualTo("CMZ")
            assertThat(crateCode2).isEqualTo("MCD")
        }
    }

    @Test
    fun input() {
        Day5(input).apply {
            println(crateCode)
            println(crateCode2)
        }
    }
}
