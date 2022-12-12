package no.solheim.adventofcode2022.tasks

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day10Test : AdventTest() {

    val example = this.javaClass.getResource("/inputs/day_10_ex.txt")?.readText() ?: ""

    val expectedScreen = """
##  ##  ##  ##  ##  ##  ##  ##  ##  ##  
###   ###   ###   ###   ###   ###   ### 
####    ####    ####    ####    ####    
#####     #####     #####     #####     
######      ######      ######      ####
#######       #######       #######     """.trimStart()
    @Test
    fun example() {
        val day10 = Day10(example)
        day10.runInstructions()
        assertThat(day10.getSignalStrengthSampleSums()).isEqualTo(13140)
        assertThat(day10.getScreen()).isEqualTo(expectedScreen)
    }

    @Test
    fun input() {
        val day10 = Day10(input)
        day10.runInstructions()
        println(day10.getSignalStrengthSampleSums())
        println(day10.getScreen())
    }
}
